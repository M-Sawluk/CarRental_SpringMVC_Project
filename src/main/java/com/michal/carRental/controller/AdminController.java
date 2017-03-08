package com.michal.carRental.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.michal.carRental.domain.Car;
import com.michal.carRental.domain.CarStorage;
import com.michal.carRental.domain.Order;
import com.michal.carRental.domain.OrderStatus;
import com.michal.carRental.domain.RentingPlace;
import com.michal.carRental.domain.User;
import com.michal.carRental.domain.UserStatus;
import com.michal.carRental.forms.CarStorageForm;
import com.michal.carRental.service.OrderService;
import com.michal.carRental.service.ProductService;
import com.michal.carRental.service.RentingPlaceService;
import com.michal.carRental.service.UserService;

@Controller
@RequestMapping("/adminPage")
public class AdminController {

	private ProductService productService;

	private UserService userService;

	private RentingPlaceService rentingPlaceService;

	private OrderService orderService;

	@Autowired
	public AdminController(ProductService productService, UserService userService,
			RentingPlaceService rentingPlaceService, OrderService orderService) {

		this.productService = productService;
		this.userService = userService;
		this.rentingPlaceService = rentingPlaceService;
		this.orderService = orderService;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String admin(Model model) {

		Car newCar = new Car();

		model.addAttribute("newCar", newCar);

		model.addAttribute("users", userService.getUserList());

		model.addAttribute("orders", orderService.getAllOrders());

		return "adminPage";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String procedAdmin(@ModelAttribute("newCar") @Valid Car newCar, BindingResult result,
			HttpServletRequest request, Model model) {
		if (result.hasErrors()) {

			return "adminPage";
		}

		MultipartFile productImage = newCar.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");

		if (productImage != null && !productImage.isEmpty()) {
			try {

				productImage.transferTo(new File(rootDirectory + "resources\\cars\\" + newCar.getCarId() + ".png"));
			} catch (Exception e) {
				throw new RuntimeException("Niepowodzenie podczas próby zapisu obrazka samochodu", e);
			}
		}

		productService.add(newCar);

		return "adminPage";
	}

	@RequestMapping("/user")
	public String selectUser(Model model, @RequestParam("name") String name) {
		List<User> user = new ArrayList<User>();
		user.add(userService.getUserByUserName(name));

		model.addAttribute("selectedUser", user);

		return "selectUser";

	}

	@RequestMapping("/delete")
	public String deleteUser(Model model, @RequestParam("name") String name) {

		userService.deleteUser(name);

		return "redirect:/adminPage";
	}

	@RequestMapping("/change")
	public String changeRole(Model model, @RequestParam("name") String name) {
		User user = userService.getUserByUserName(name);
		String role;

		if (user.getRoles().get(0).getRoleName().equalsIgnoreCase("ROLE_ADMIN")) {
			role = "ROLE_USER";
			user.getRoles().clear();
		} else {
			role = "ROLE_ADMIN";
			user.getRoles().clear();
		}

		userService.changeUserRole(user, role);

		return "redirect:/adminPage";
	}

	@RequestMapping("/block")
	public String block(Model model, @RequestParam("name") String name) {
		User user = userService.getUserByUserName(name);

		if (user.getStatus() == UserStatus.ACTIVE) {
			user.setStatus(UserStatus.INACTIVE);
		} else {
			user.setStatus(UserStatus.ACTIVE);
		}

		userService.updateUser(user);

		return "redirect:/adminPage?name=";
	}

	@RequestMapping(value = "/addPlace", method = RequestMethod.GET)
	public String adminAddPlace(Model model) {

		RentingPlace place = new RentingPlace();

		model.addAttribute("place", place);

		return "addPlace";
	}

	@RequestMapping(value = "/addPlace", method = RequestMethod.POST)
	public String adminProcessPlace(@ModelAttribute("place") @Valid RentingPlace place, BindingResult result,
			Model model) {

		if (result.hasErrors()) {

			return "addPlace";
		}

		rentingPlaceService.addPlace(place);

		return "redirect:/adminPage?name=";
	}

	@RequestMapping("/carrent/delete")
	public String deleteCar(Model model, @RequestParam("car") String name) {

		productService.deleteCar(name);

		return "redirect:/carrent";

	}

	@RequestMapping(value = "/carrent/edit", method = RequestMethod.GET)
	public String editCar(Model model, @RequestParam("car") String name) {
		Car newCar = new Car();

		newCar = productService.findCarByCarId(name);

		model.addAttribute("newCar", newCar);

		return "editCar";

	}

	@RequestMapping(value = "/carrent/edit", method = RequestMethod.POST)
	public String processEditCar(@ModelAttribute("newCar") @Valid Car newCar, BindingResult result, Model model,
			@RequestParam("car") String name) {
		if (result.hasErrors()) {

			return "editCar";
		}

		Car oldCar = productService.findCarByCarId(name);

		newCar.setCarId(oldCar.getCarId());
		newCar.setId(oldCar.getId());

		productService.updateCar(newCar);

		return "redirect:/carrent";
	}

	@RequestMapping(value = "/carrent/setUnits", method = RequestMethod.GET)
	public String selectCarToAddUnits(Model model, @RequestParam("car") String carId) {
		Car car = productService.findCarByCarId(carId);

		List<RentingPlace> places = rentingPlaceService.getPlaceList();

		model.addAttribute("car", car);

		CarStorageForm cSF = new CarStorageForm();

		for (int i = 0; i < places.size(); i++) {
			CarStorage carS = new CarStorage();
			carS.setRentingPlace(places.get(i));
			carS.setPlaceName(places.get(i).getCity());
			carS.setCar(car);
			cSF.getStorages().add(carS);

		}

		model.addAttribute("CarStorageForm", cSF);

		return "setUnits";

	}

	@RequestMapping(value = "/carrent/setUnits", method = RequestMethod.POST)
	public String processCarToAddUnits(Model model, @RequestParam("car") String carId,
			@ModelAttribute("CarStorageForm") CarStorageForm cSF) {

		Car car = productService.findCarByCarId(carId);

		List<RentingPlace> places = rentingPlaceService.getPlaceList();

		for (int i = 0; i < cSF.getStorages().size(); i++) {
			cSF.getStorages().get(i).setCar(car);
			cSF.getStorages().get(i).setRentingPlace(places.get(i));

		}

		productService.setCarUnits(cSF);

		return "redirect:/carrent";

	}

	@RequestMapping("/deleteOrder")
	public String deleteOrder(@RequestParam("order") long order) {

		orderService.deleteOrder(order);

		return "redirect:/adminPage";
	}

	@RequestMapping("/changeOrder")
	public String changeOrder(@RequestParam("order") long order) {
		Order ord = orderService.findOrderById(order);

		ord.setStatus(OrderStatus.INACTIVE);

		orderService.updateOrder(ord);

		return "redirect:/adminPage";
	}
}

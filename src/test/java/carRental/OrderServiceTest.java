package carRental;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.michal.carRental.domain.Car;
import com.michal.carRental.domain.Order;
import com.michal.carRental.domain.RentingPlace;
import com.michal.carRental.domain.repository.OrderRepository;
import com.michal.carRental.exception.InvalidCarException;
import com.michal.carRental.service.impl.OrderServiceImpl;

public class OrderServiceTest {

	OrderRepository orderRepository;
	Order order;
	Car car;
	RentingPlace rentingPlace;
	OrderServiceImpl orderService;

	@Before
	public void setUp() {

		orderRepository = mock(OrderRepository.class);

		order = new Order();
		car = new Car();
		rentingPlace = new RentingPlace();
		order.setCar(car);
		order.setRentingPlace(rentingPlace);

		orderService = new OrderServiceImpl(orderRepository);

	}

	@Test(expected = InvalidCarException.class)
	public void validExceptionTest() {

		when(orderRepository.getUnitsOfCarInSpecificPlace(order.getCar().getId(), order.getRentingPlace().getId()))
				.thenReturn(3);

		when(orderRepository.getOrdersInSpecificPeriodOfTimeWithCarIdAndPlaceId(order.getCar().getId(),
				order.getRentingPlace().getId(), order.getRentStart(), order.getRentEnd())).thenReturn(3);

		assertEquals(order, orderService.validOrder(order));

	}

	@Test()
	public void validPassTest() {

		when(orderRepository.getUnitsOfCarInSpecificPlace(order.getCar().getId(), order.getRentingPlace().getId()))
				.thenReturn(4);

		when(orderRepository.getOrdersInSpecificPeriodOfTimeWithCarIdAndPlaceId(order.getCar().getId(),
				order.getRentingPlace().getId(), order.getRentStart(), order.getRentEnd())).thenReturn(3);

		assertThat(orderService.validOrder(order),instanceOf(Order.class) );
		
		

	}
}

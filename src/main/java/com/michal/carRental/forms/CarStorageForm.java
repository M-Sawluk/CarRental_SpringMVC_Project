package com.michal.carRental.forms;

import java.util.ArrayList;
import java.util.List;

import com.michal.carRental.domain.CarStorage;

public class CarStorageForm
{
	private List<CarStorage> storages = new ArrayList<CarStorage>();

	public List<CarStorage> getStorages() {
		return storages;
	}

	public void setStorages(List<CarStorage> storages) {
		this.storages = storages;
	}

	@Override
	public String toString() {
		return "CarStorageForm [storages=" + storages + "]";
	}
	

}

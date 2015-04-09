package com.dio.warehouse;

import com.dio.javamentoring.warehouse.StorageType;
import com.dio.javamentoring.warehouse.TVStorageInterface;
import com.dio.javamentoring.warehouse.Warehouse;

public class StorageWebState {
	
	private static StorageWebState instance;	
	private StorageWebState() {}
	
	private Warehouse warehouse;
	private StorageType storageSelected;

	public String getStorageSelected() {
		return storageSelected.name();
	}


	public void setStorageSelected(String storageSelected) {
		this.storageSelected = StorageType.valueOf(storageSelected);
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}


	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
	
	
	public TVStorageInterface getCurrentStorage() {
		try {
			return warehouse.getStorage(storageSelected);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	


	public static StorageWebState getInstance() {
		if (instance == null) {
			instance = new StorageWebState();

			Warehouse warehouse = new Warehouse();
			try {
				warehouse.initTVManageService("C:\\111\\");
			} catch (Exception e) {
				e.printStackTrace();
				warehouse = null;
			}
			
			instance.setWarehouse(warehouse);
		}
		
		return instance;
	}
}

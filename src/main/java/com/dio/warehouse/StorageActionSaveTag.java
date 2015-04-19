package com.dio.warehouse;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.dio.javamentoring.warehouse.MatrixType;
import com.dio.javamentoring.warehouse.TV;
import com.dio.javamentoring.warehouse.TVStorage;

public class StorageActionSaveTag extends SimpleTagSupport {
	

	@Override
	public void doTag() throws JspException, IOException {
		StorageWebState instance = StorageWebState.getInstance();
		//TVManageService service = instance.getWarehouse().getManageService();
		TVStorage storage = instance.getCurrentStorage(); 
		
		try {
			storage.saveLastLoaded();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

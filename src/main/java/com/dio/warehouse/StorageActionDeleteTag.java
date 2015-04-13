package com.dio.warehouse;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.dio.javamentoring.warehouse.TVStorage;

public class StorageActionDeleteTag extends SimpleTagSupport {
	
	private int id;
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void doTag() throws JspException, IOException {
		StorageWebState instance = StorageWebState.getInstance();
		//TVManageService service = instance.getWarehouse().getManageService();
		TVStorage storage = instance.getCurrentStorage(); 
		storage.deleteItem(id);
	}
}

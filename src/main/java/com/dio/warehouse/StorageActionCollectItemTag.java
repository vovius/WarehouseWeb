package com.dio.warehouse;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.dio.javamentoring.warehouse.TV;
import com.dio.javamentoring.warehouse.TVStorage;

public class StorageActionCollectItemTag extends SimpleTagSupport {
	
	TV item;

	public TV getItem() {
		return item;
	}

	public void setItem(TV item) {
		this.item = item;
	}

	@Override
	public void doTag() throws JspException, IOException {
		StorageWebState instance = StorageWebState.getInstance();
		TVStorage storage = instance.getCurrentStorage(); 
		storage.setItem(item);
	}
	
}

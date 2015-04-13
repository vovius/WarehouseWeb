package com.dio.warehouse;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.dio.javamentoring.warehouse.MatrixType;
import com.dio.javamentoring.warehouse.TV;
import com.dio.javamentoring.warehouse.TVStorage;

public class StorageActionSaveTag extends SimpleTagSupport {
	
	private int id;
	private String brand;
	private int diagonal;
	private MatrixType matrixType;
	private Date dateMade;

	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getBrand() {
		return brand;
	}



	public void setBrand(String brand) {
		this.brand = brand;
	}



	public int getDiagonal() {
		return diagonal;
	}



	public void setDiagonal(int diagonal) {
		this.diagonal = diagonal;
	}



	public MatrixType getMatrixType() {
		return matrixType;
	}



	public void setMatrixType(MatrixType matrixType) {
		this.matrixType = matrixType;
	}



	public Date getDateMade() {
		return dateMade;
	}



	public void setDateMade(Date dateMade) {
		this.dateMade = dateMade;
	}



	@Override
	public void doTag() throws JspException, IOException {
		TV item = new TV.Builder()
						.id(id)
						.brand(brand)
						.diagonal(diagonal)
						.matrixType(matrixType)
						.dateMade(dateMade)
						.build();
		
		
		StorageWebState instance = StorageWebState.getInstance();
		//TVManageService service = instance.getWarehouse().getManageService();
		TVStorage storage = instance.getCurrentStorage(); 
		storage.setItem(item);
		
	}

}

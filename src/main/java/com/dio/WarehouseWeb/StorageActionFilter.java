package com.dio.WarehouseWeb;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.dio.javamentoring.warehouse.*;

public class StorageActionFilter implements Filter {
	
	private String storageSelected;
	private TVStorageInterface storage;
	private List<TV> storageList;

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {

		String storageSelectedCur = request.getParameter("storages");
		if (storageSelected == null || storageSelected.isEmpty() || storageSelectedCur != null && !storageSelectedCur.equals(storageSelected) ) {
			Warehouse warehouse = (Warehouse)request.getAttribute("warehouse");
			try {
				storage = warehouse.getStorage(StorageType.valueOf(storageSelectedCur));
				storageList = storage.getStorageList();
				
				storageSelected = storageSelectedCur;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		request.setAttribute("storageList", storageList);
		request.setAttribute("storage", storage);
		
		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

}

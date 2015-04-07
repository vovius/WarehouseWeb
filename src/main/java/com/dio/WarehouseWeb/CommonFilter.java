package com.dio.WarehouseWeb;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.dio.javamentoring.warehouse.Warehouse;


public class CommonFilter implements Filter {
	
	private Warehouse warehouse;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		request.setAttribute("warehouse", warehouse);
		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		warehouse = new Warehouse();
		try {
			warehouse.initTVManageService("C:\\111\\");
		} catch (Exception e) {
			e.printStackTrace();
			warehouse = null;
		}
		
	}

}

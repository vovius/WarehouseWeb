package com.dio.warehouse;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.dio.javamentoring.warehouse.StorageType;

public class StorageSelectFilter implements Filter {
	
	@Override
	public void destroy() {		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {

		request.setAttribute("storageWebState", StorageWebState.getInstance());
		
		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		StorageWebState.getInstance().setStorageSelected(StorageType.TXT.name());
	}

}

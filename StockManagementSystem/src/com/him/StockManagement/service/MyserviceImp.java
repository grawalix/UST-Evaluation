package com.him.StockManagement.service;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.him.StockManagement.dao.MyDAO;
import com.him.StockManagement.model.ModelDTO;
import com.him.StockManagement.model.OrderDTO;
import com.him.StockManagement.model.RegistrationDTO;


@Component
public class MyserviceImp implements MyService {
	
	@Autowired 
	MyDAO mdao;


	@Override
	public boolean MangerRegistration(RegistrationDTO rdto) {
		// TODO Auto-generated method stub
				boolean b=mdao.MangerRegistration(rdto);
				return b;
	}

	@Override
	public boolean ManagerLogin(HttpServletRequest req) {
		 boolean	b=mdao.ManagerLogin(req);
			
			return b;
	}

	@Override
	public boolean addproduct(ModelDTO mdto) {
		// TODO Auto-generated method stub
		boolean b= mdao.addproduct(mdto);
		return b;
	}

	@Override
	public List<ModelDTO> allproduct() {
		
		return mdao.allproduct();
	}
	

	@Override
	public List<ModelDTO> searchproduct(String search,String filter) {
		// TODO Auto-generated method stub
		List<ModelDTO>mlist=mdao.searchproduct(search,filter);
		return  mlist;
	}

	@Override
	public List<ModelDTO> updateproduct(ModelDTO mdto) {
		
		return mdao.updateproduct(mdto);
	}

	@Override
	public List<ModelDTO> addtocart(ModelDTO mdto) {
		// TODO Auto-generated method stub
		return mdao.addtocart(mdto);
	}

	@Override
	public List<ModelDTO> cartadded(ModelDTO mdto) {
		// TODO Auto-generated method stub
		return mdao.cartadded(mdto);
	}

	@Override
	public List<OrderDTO> showCart() {
		// TODO Auto-generated method stub
		return mdao.showCart();
	}
	

}

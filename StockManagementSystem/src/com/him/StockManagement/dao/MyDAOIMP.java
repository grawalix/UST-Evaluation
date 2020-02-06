package com.him.StockManagement.dao;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.him.StockManagement.model.ModelDTO;
import com.him.StockManagement.model.OrderDTO;
import com.him.StockManagement.model.RegistrationDTO;



@Component
public class MyDAOIMP implements MyDAO {
	@Autowired
	SessionFactory sf;
	
	HttpSession ss;

	@Override
	public boolean MangerRegistration(RegistrationDTO rdto) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(RegistrationDTO.class);
		cr.add(Restrictions.eq("email", rdto.getEmail()));
		RegistrationDTO dto= (RegistrationDTO) cr.uniqueResult();
		if(dto==null) {
			ss.save(rdto);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		}
		else
		{
			return false;
		}

	}


	@Override
	public boolean ManagerLogin(HttpServletRequest req) {
		String password=req.getParameter("password");
		String email=req.getParameter("email");
		Session ss=sf.openSession();
		Criteria cr =ss.createCriteria(RegistrationDTO.class);
		cr.add(Restrictions.eq("password",password));
		cr.add(Restrictions.eq("email",email));
		RegistrationDTO rdto= (RegistrationDTO) cr.uniqueResult();
		ss.beginTransaction().commit();
		ss.close();
		if(rdto!=null) {
			return true;
		}else {
			return false;
		}
	}


	@Override
	public boolean addproduct(ModelDTO mdto) {
		System.out.println("inside dao");
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(ModelDTO.class);
		cr.add(Restrictions.eqOrIsNull("pname",mdto.getPname()));
		cr.add(Restrictions.eq("pcompany",mdto.getPcompany()));
		ModelDTO dto=(ModelDTO) cr.uniqueResult();
		if(dto==null){
		ss.save(mdto);
		ss.beginTransaction().commit();
		ss.close();
		return true;
	}
		else{
		ss.close();
		return false;
	}
	}


	@Override
	public List<ModelDTO> allproduct() {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(ModelDTO.class);
		List<ModelDTO> mlist=cr.list();
		return mlist;
	}

	@Override
	public List<ModelDTO> searchproduct(String search,String filter) {
		// TODO Auto-generated method stub
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(ModelDTO.class);
		cr.add(Restrictions.ilike(filter,search, MatchMode.ANYWHERE));
		List<ModelDTO>mlist=cr.list();
		return mlist;
	}


	@Override
	public List<ModelDTO> updateproduct(ModelDTO mdto) {
		// TODO Auto-generated method stub
		Session ss=sf.openSession();
		ss.update(mdto);
		ss.beginTransaction().commit();
		Criteria cr=ss.createCriteria(ModelDTO.class);
		List<ModelDTO>mlist=cr.list();	
		return mlist;
	}

	@Override
	public List<ModelDTO> addtocart(ModelDTO mdto) {
		// TODO Auto-generated method stub
		Session ss=sf.openSession();
		System.out.println("inside dao");
		Criteria cr=ss.createCriteria(ModelDTO.class);
		List<ModelDTO>mlist=cr.list();
		for (ModelDTO modelDTO : mlist) {
			System.out.println(modelDTO);
		}
		return mlist;

	}


	@Override
	public List<ModelDTO> cartadded(ModelDTO mdto) {
		Session ss=sf.openSession();
		ModelDTO mmdto=ss.load(ModelDTO.class, mdto.getPid());
		mmdto.setPquantity(mmdto.getPquantity()-mdto.getPquantity());
		double tt=((mmdto.getPrice()*mdto.getPquantity())*1.18);
		OrderDTO odto=new OrderDTO(); 
		System.out.println(mdto.getPquantity());
		odto.setTprice(mdto.getPquantity()*mmdto.getPrice());
		odto.setTpricegst(tt);
		List<OrderDTO>olist=mmdto.getOlist();
		olist.add(odto);
		ss.saveOrUpdate(mmdto);
		ss.beginTransaction().commit();
		return null;
	}


	@Override
	public List<OrderDTO> showCart() {
		// TODO Auto-generated method stub
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(OrderDTO.class);
		List<OrderDTO>olist=cr.list();
		return olist;
	}
	
}
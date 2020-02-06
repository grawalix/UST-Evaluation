package com.mail.simulation.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.mail.simulation.DTO.Mail_Info;
import com.mail.simulation.DTO.User_Info;
import com.mail.simulation.dao.MyDAO;




@Component
public class MyServiceImp1 implements MyService {
	@Autowired
	MyDAO md;
	
	
	
	@Override
	public boolean register(User_Info ui) {
     System.out.println("inside service");
		return md.register(ui);
		
	}
	
	@Override
	public User_Info login(User_Info ui) {
		System.out.println("inside service");
		User_Info b=md.login(ui);
	return b;
	}

	@Override
	public boolean compose(HttpServletRequest req) {
		return md.compose(req);
	}
	
	@Override
	public List<Mail_Info> getdraft() {
		List<Mail_Info> mlist=md.getdraft();
		return mlist;
	}
	@Override
	public List<Mail_Info> sentmail() {
		List<Mail_Info> mlist=md.sentmail();
		return mlist;
	}
	@Override
	public List<Mail_Info> getinbox() {
		List<Mail_Info> mlist=md.getinbox();
		return mlist;
	}
	
	@Override
	public List<Mail_Info> getdeletemessage() {
		List<Mail_Info > m=md.getdeletemessage();
		return m;
	}
	@Override
	
	public boolean delete(int id) {
		boolean b=md.delete(id);
		return b;
	}
	@Override
	public boolean forget(User_Info ui, HttpServletResponse res, HttpSession session, HttpServletRequest req) {
		
		return md.forget(ui, res, session, req);
	}
	@Override
	public boolean changePass(User_Info ui, HttpServletResponse res, HttpSession session, HttpServletRequest req) {
		md.changePass(ui, res, session, req);
		return false;
	}
	
	@Override
	public boolean logout(User_Info ui, HttpServletResponse res, HttpSession session, HttpServletRequest req) {
		// TODO Auto-generated method stub
		boolean b =md.logout(ui, res, session, req);
		if (b) {
			return  true;
			
		} else {
			return false;

		}
		
	}

	@Override
	public Mail_Info showinbox(int id) {
		Mail_Info m=md.showinbox(id);
		return m;
	}

	@Override
	public Mail_Info showsent(int id) {
		Mail_Info m=md.showsent(id);
		return m;
	}

	@Override
	public boolean editcompose(HttpServletRequest req) {
		return md.editcompose(req);
	}

	@Override
	public Mail_Info composeDraft(int id) {
		// TODO Auto-generated method stub
		return md.composeDraft(id);
	}

	

//	@Override
//	public Mail_Info composedraft(int id) {
//		// TODO Auto-generated method stub
//		return md.composeedit(id);
//	}

	

	

	
	
}

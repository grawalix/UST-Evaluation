package com.mail.simulation.service;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HttpServletBean;

import com.mail.simulation.DTO.Mail_Info;
import com.mail.simulation.DTO.User_Info;





public interface MyService {
	public boolean register(User_Info ui);
	public User_Info login(User_Info ui);
	public boolean compose(HttpServletRequest req);
	List<Mail_Info> getdraft();
	List<Mail_Info> sentmail();
	List<Mail_Info> getinbox();
	
	public boolean changePass(User_Info ui,HttpServletResponse res,HttpSession session,HttpServletRequest req);
	public boolean forget(User_Info ui,HttpServletResponse res,HttpSession session,HttpServletRequest req);
	public boolean logout(User_Info ui,HttpServletResponse res,HttpSession session,HttpServletRequest req);
    public boolean delete(int id);
     public List<Mail_Info> getdeletemessage();
     
	public Mail_Info showinbox(int id);
	public Mail_Info showsent(int id);
	boolean editcompose(HttpServletRequest req);
	public Mail_Info composeDraft(int id);	

}

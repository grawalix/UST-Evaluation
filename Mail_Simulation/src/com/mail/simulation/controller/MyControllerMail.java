package com.mail.simulation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mail.simulation.DTO.Mail_Info;
import com.mail.simulation.DTO.User_Info;
import com.mail.simulation.service.MyService;

@Component
@RequestMapping("/")
public class MyControllerMail {
	@Autowired
	MyService ms;
	@Autowired
	HttpSession session;

	@RequestMapping("/login")
	public String login() {
		return "login";

	}

	@RequestMapping("/compose")
	public ModelAndView composeMail() {
		if (session.getAttribute("email")!=null) {
			return new ModelAndView( "compose","msg","welcome to compose");
		}
		else {
			return new ModelAndView( "login","msg","login first");
		}
	}
	
	/*
	 * @RequestMapping("/editcompose") public String editcompose() { return
	 * "draftedit"; }
	 */
	
	@RequestMapping("/logout")
	public ModelAndView logout(@ModelAttribute User_Info use,HttpSession session) {
//		boolean b=ms.logout(use, res, session, req);
		
		if (session.getAttribute("email")!=null) {
			session.setAttribute("email", null);
			return new ModelAndView("login","msg","logout successfull");
		} else {
			return new ModelAndView("login","msg","logout successfull");
		}
	}
	
	@RequestMapping("/draftMail")
	public ModelAndView draft() {
		List<Mail_Info> mlist=ms.getdraft();
		if (session.getAttribute("email")!=null) {
			return new ModelAndView( "draft","msg",mlist);
		}
		else {
			return new ModelAndView( "login","msg","login first");
		}
		
	}
	
	@RequestMapping("/delMessage")
	public ModelAndView delMessage() {
		List<Mail_Info> mlist=ms.getdeletemessage();
		
		if (session.getAttribute("email")!=null) {
			return new ModelAndView("delete","msg",mlist);
		}
		else {
			return new ModelAndView( "login","msg","login first");
		}

	}
	
	@RequestMapping("/sentMail")
	public ModelAndView sent() {
		List<Mail_Info> mlist=ms.sentmail();
		
		if (session.getAttribute("email")!=null) {
			return new ModelAndView( "sent","msg",mlist);
		}
		else {
			return new ModelAndView( "login","msg","login first");
		}
	}
	
	@RequestMapping("/inboxMail")
	public ModelAndView inbox() {
		List<Mail_Info> mlist=ms.getinbox();
		
		if (session.getAttribute("email")!=null) {
			return new ModelAndView( "inbox","msg",mlist);
		}
		else {
			return new ModelAndView( "login","msg","login first");
		}
	}
	
	@RequestMapping("/registration")
	public String registration() {
		return "registration";

	}
	
	@RequestMapping("/changePass")
	public String changePass() {
		return "changePass";

	}
	@RequestMapping("/forget")
	public String forget() {
		return "forget";

	}
	


	@RequestMapping(value="/loginvalidation",method=RequestMethod.POST)
	public ModelAndView loginvalidation(@ModelAttribute User_Info ui,HttpSession hn) {
		
		System.out.println("inside controller");
		User_Info uinf=ms.login(ui);
		if(uinf!=null) {
			hn.setAttribute("email", uinf.getEmail());
			System.out.println("login success");
			return new ModelAndView("menu","dto",uinf);
		}else {
			System.out.println("login failed");
			return new ModelAndView( "login");
		}
	}


	@RequestMapping(value="/registrationData",method=RequestMethod.POST)
	public ModelAndView registrationData(@ModelAttribute User_Info ui) {
       System.out.println("inside controller");
		boolean b=ms.register(ui);
		if (b) {
			
			return new ModelAndView("registration","msg","registration successfull");
		} else {
			return new ModelAndView("registration","msg","user already registered");

		}
		
	}
	
	@RequestMapping(value="/changePass",method=RequestMethod.POST)
	public String changePass(@ModelAttribute User_Info ui,HttpServletResponse res,HttpSession session,HttpServletRequest req) {

		System.out.println("inside controller");
		ms.changePass(ui,res,session,req);
		return "login";
	}
	
	@RequestMapping(value="/forget",method=RequestMethod.POST)
	public String forget(@ModelAttribute User_Info ui,HttpServletResponse res,HttpSession session,HttpServletRequest req) {

		System.out.println("inside controller");
		boolean b=ms.forget(ui,res,session,req);
		if (b) {
			return "login";
		} else {
             return "forget";
		}
	}
	
	@RequestMapping(value="/composemail",method=RequestMethod.POST)
	public ModelAndView composemail(HttpServletRequest req) {
    System.out.println("inside controller");
	boolean b=	ms.compose(req);
	if(b) {
		return new  ModelAndView("menu","msg","Mail has been sent");
	}
	else {
		return new  ModelAndView("menu","msg","Mail unsuccessful");
	}
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam int id) {
		boolean b=ms.delete(id);
		if(b){
			return new ModelAndView("menu","msg","deleted message succefull");
		}else{
			return new ModelAndView("menu","msg","deleted not message succefull");
		}

	}
	
	@RequestMapping(value="/editcomp",method=RequestMethod.GET)
	public ModelAndView editCompose(HttpServletRequest req) {
		System.out.println("inside controller");
		boolean b=ms.editcompose (req);
		if (b) {
			return new ModelAndView("menu","msg","mail sent");
		} else {
			return new ModelAndView("menu","msg","mail saved as draft");
		}
	}
	
	@RequestMapping("/showInbox")
	public ModelAndView showInbox(@RequestParam int id) {
	Mail_Info dto=ms.showinbox(id);
		if(dto!=null){
			return new ModelAndView("showinbox","dto",dto);
		}else{
			return new ModelAndView();
		}

	}
	
	@RequestMapping("/showsent")
	public ModelAndView showsent(@RequestParam int id) {
	Mail_Info dto=ms.showsent(id);
		if(dto!=null){
			return new ModelAndView("showsent","dto",dto);
		}else{
			return new ModelAndView();
		}

	}
	
	@RequestMapping("/editcompose")
	public ModelAndView composeDraft(@RequestParam int id) {
		Mail_Info dto=ms.composeDraft(id);
		System.out.println(dto.getDraft_message());
		return new ModelAndView("draftedit","dto",dto);
	}
	
	
	
	
	
	
	
	
	

}
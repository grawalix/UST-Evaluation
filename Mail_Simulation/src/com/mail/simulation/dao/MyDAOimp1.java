package com.mail.simulation.dao;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mail.simulation.DTO.Mail_Info;
import com.mail.simulation.DTO.User_Info;

@Component
public class MyDAOimp1 implements MyDAO {
@Autowired
SessionFactory sf;
@Autowired
HttpSession hn;



@Override
//for delete message
public boolean delete(int id) {
	Session ss=sf.openSession();
	Criteria cr=ss.createCriteria(Mail_Info.class);
	cr.add(Restrictions.eq("mid", id));
	Mail_Info md=(Mail_Info) cr.uniqueResult();
	if(md!=null){
		md.setStatus("delMessage");
		ss.saveOrUpdate(md);
		ss.beginTransaction().commit();
		ss.close();
		return true;	
	}else{
	return false;
	}
}

@Override
//for forget password
public boolean forget(User_Info ui, HttpServletResponse res, HttpSession session, HttpServletRequest req) {
	Session ss=sf.openSession();
	String email=req.getParameter("email");
	String newpass=req.getParameter("newpassword");
	String question=req.getParameter("question");
	String answer=req.getParameter("answer");

	Criteria cr=ss.createCriteria(User_Info.class);
	cr.add(Restrictions.eq("email", email));
	cr.add(Restrictions.eq("question", question));
	cr.add(Restrictions.eq("answer", answer));
	User_Info udto=(User_Info) cr.uniqueResult();
	if(udto!=null){
		udto.setPassword(newpass);
		ss.saveOrUpdate(udto);
		ss.beginTransaction().commit();
		ss.close();
		return true;
	}
	else{
	

return false;
	}
	
	
}
	@Override
	//for change password
public boolean changePass(User_Info ui, HttpServletResponse res, HttpSession session, HttpServletRequest req) {
		Session ss=sf.openSession();
		String email=req.getParameter("email");
		String oldpass=req.getParameter("oldpassword");
		String newpass=req.getParameter("newpassword");
		
		Criteria cr=ss.createCriteria(User_Info.class);
		cr.add(Restrictions.eq("email", email));
		cr.add(Restrictions.eq("password", oldpass));
		User_Info udto=(User_Info) cr.uniqueResult();
		if(udto!=null){
			udto.setPassword(newpass);
			ss.saveOrUpdate(udto);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		}
		else{
		

	return false;
		}
}
	@Override
	//for registration of user
	public boolean register(User_Info ui) {
		
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(User_Info.class);
		cr.add(Restrictions.eq("email", ui.getEmail()));
		User_Info uii=(User_Info) cr.uniqueResult();
		if (uii!=null) {
			return false;
			
		} else {
			ss.save(ui);
			ss.beginTransaction().commit();
			ss.close();
			return true;

		}
		
		}
	
	@Override
	//for user login
	public User_Info login(User_Info ui) {
		System.out.println("inside dao");
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(User_Info.class);
	    cr.add(Restrictions.eq("username", ui.getUsername()));
	    cr.add(Restrictions.eq("password", ui.getPassword()));
	    User_Info uui=(User_Info) cr.uniqueResult();
		ss.close();
		return uui;	
	}
  
	@Override
	//for compose message
	public boolean compose(HttpServletRequest req) {
		Session ss=sf.openSession();
		String to=req.getParameter("to");
		String msg=req.getParameter("msg");
		String subject=req.getParameter("subject");
		this.hn=req.getSession();
		String sentby=(String) hn.getAttribute("email");
		Mail_Info min=null;
		Criteria cr=ss.createCriteria(User_Info.class);
		cr.add(Restrictions.eq("email", to));
		User_Info uinf=(User_Info) cr.uniqueResult();
		
		if(uinf!=null) {
			min=new Mail_Info(); 
			min.setSubject(subject);
			min.setInbox(msg);
			min.setSent(to);
			min.setSentBy(sentby);
			Criteria cr1=ss.createCriteria(User_Info.class);
			cr1.add(Restrictions.eq("email", sentby));
			User_Info uin=(User_Info) cr1.uniqueResult();
			List<Mail_Info> mlist1=uin.getMlist();
			mlist1.add(min);
			ss.saveOrUpdate(uin);
			ss.beginTransaction().commit();
//			min.setStatus("sent");
//			ss.saveOrUpdate(min);
//			ss.beginTransaction().commit();
			ss.close();
			return true;
		}else {
			min=new Mail_Info();
			min.setSubject(subject);
			min.setDraft(to);
			min.setSentBy(sentby);
			min.setDraft_message(msg);
			Criteria cr1=ss.createCriteria(User_Info.class);
			cr1.add(Restrictions.eq("email", sentby));
			User_Info uin=(User_Info) cr1.uniqueResult();
			List<Mail_Info> mlist=uin.getMlist();
			mlist.add(min);
			ss.saveOrUpdate(uin);
			ss.beginTransaction().commit();
//			min.setStatus("draft");
//			ss.saveOrUpdate(min);
//			ss.beginTransaction().commit();
			ss.close();
            return false;
		}	
	}
	
	@Override
	//for draft message list
	public List<Mail_Info> getdraft() {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Mail_Info.class);
		String sentby=(String) hn.getAttribute("email");
		cr.add(Restrictions.eq("sentBy", sentby));
		System.out.println("my em"+sentby);
		cr.add(Restrictions.isNull("sent"));
		cr.add(Restrictions.isNotNull("draft"));
		cr.add(Restrictions.isNotNull("draft_message"));
//		cr.add(Restrictions.eq("status", "draft"));
		List<Mail_Info> mlist=cr.list();
		return mlist;
	} 
	
	@Override
	//for sent message list
	public List<Mail_Info> sentmail() {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Mail_Info.class);
		String sentby=(String) hn.getAttribute("email");
		cr.add(Restrictions.eq("sentBy", sentby));
		cr.add(Restrictions.isNotNull("sent"));
		cr.add(Restrictions.isNull("draft"));
//		cr.add(Restrictions.isNull("draft_message"));
		cr.add(Restrictions.isNull("inbox"));
//		cr.add(Restrictions.isNull("status"));

//     	cr.add(Restrictions.eq("status", "sent"));
	    List<Mail_Info> mlist=cr.list();
	   ss.close();
		return mlist;
	}
	
	@Override
	//for delete message list
	public List<Mail_Info> getdeletemessage() {
		System.out.println("inside dao");
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Mail_Info.class);
		String sentby=(String) hn.getAttribute("email");
		//cr.add(Restrictions.eq("sentby", sentby));
		cr.add(Restrictions.eq("sentBy", sentby));
		cr.add(Restrictions.eq("status","delMessage"));
		List<Mail_Info> mlist=cr.list();
		ss.close();
		return mlist;
		
		
	}
	@Override
	//for logout the user

	public boolean logout(User_Info ui, HttpServletResponse res, HttpSession session, HttpServletRequest req) {
	
		session=req.getSession(false);
		if (session.getAttribute("email")!=null){
			session.setAttribute("email", null);
			return true;
			
		} else {
			return false;
		}
		
	}
	
	@Override
	//to show inbox message list
	public List<Mail_Info> getinbox() {
		System.out.println("inside dao");
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Mail_Info.class);
		String sentby=(String) hn.getAttribute("email");
		cr.add(Restrictions.eq("sent", sentby));
//		cr.add(Restrictions.eq("status", "sent"));
//		cr.add(Restrictions.eq("sent", sentby));
		cr.add(Restrictions.isNull("draft"));

		cr.add(Restrictions.isNull("status"));

		List<Mail_Info> mlist=cr.list();
		return mlist;
	}
	
	@Override
	//to show inbox message
	public Mail_Info showinbox(int id) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Mail_Info.class);
		cr.add(Restrictions.eq("mid", id));
		Mail_Info m=(Mail_Info) cr.uniqueResult();
		return m;
	}
	@Override
	//to show sent message
	public Mail_Info showsent(int id) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Mail_Info.class);
//	String sentby=(String) hn.getAttribute("email");
		cr.add(Restrictions.eq("mid", id));
//		cr.add(Restrictions.eq("sent", sentby));
		Mail_Info m=(Mail_Info) cr.uniqueResult();
		ss.close();
		return m;
	}
	
	@Override
	//for edit the draft message

	public boolean editcompose(HttpServletRequest req) {
		Session ss=sf.openSession();
		String to=req.getParameter("to");
		String smid=req.getParameter("id");
        int mid=Integer.parseInt(smid);
		String msg=req.getParameter("msg");
		String subject=req.getParameter("subject");
		this.hn=req.getSession();
		String sentby=(String) hn.getAttribute("email");
		Mail_Info min=null;
		Criteria cr=ss.createCriteria(User_Info.class);
		cr.add(Restrictions.eq("email", to));
		User_Info uinf=(User_Info) cr.uniqueResult();
		Mail_Info mdto=ss.load(Mail_Info.class, mid);
		if (uinf!=null) {
			mdto.setInbox(msg);
			mdto.setSent(to);
			mdto.setSubject(subject);
			mdto.setSentBy(sentby);
			mdto.setDraft(null);
			List<Mail_Info> mlist1=uinf.getMlist();
			mlist1.add(mdto);
			ss.update(uinf);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		} else {
			mdto.setInbox(msg);
			mdto.setSent(to);
			mdto.setSubject(subject);
			mdto.setSentBy(sentby);
			mdto.setDraft(msg);
			Criteria cr1=ss.createCriteria(User_Info.class);
			cr1.add(Restrictions.eq("email", sentby));
			User_Info uin=(User_Info) cr1.uniqueResult();
			List<Mail_Info> mlist=uin.getMlist();
			mlist.add(min);
			ss.saveOrUpdate(uin);
			ss.beginTransaction().commit();

			ss.close();
            return false;
		}
	}

	@Override
	public Mail_Info composeDraft(int id) {
		Session ss=sf.openSession();
		Criteria cr = ss.createCriteria(Mail_Info.class);
		cr.add(Restrictions.eq("mid",id));
		Mail_Info dto=(Mail_Info) cr.uniqueResult();
		return dto;
	}
	
	
	
	

	
}



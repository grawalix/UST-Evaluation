package com.mail.simulation.DTO;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Mail_Info implements Serializable {
@Id
@GenericGenerator(name = "auto",strategy = "increment")
@GeneratedValue(generator = "auto")

private int mid;
private String subject;
private String inbox;
private String sent;
private String draft;
private String sentBy;
private String draft_message;
private String status;



public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}

public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

public String getDraft_message() {
	return draft_message;
}
public void setDraft_message(String draft_message) {
	this.draft_message = draft_message;
}
public String getSentBy() {
	return sentBy;
}
public void setSentBy(String sentBy) {
	this.sentBy = sentBy;
}
public int getMid() {
	return mid;
}
public void setMid(int mid) {
	this.mid = mid;
}
public String getInbox() {
	return inbox;
}
public void setInbox(String inbox) {
	this.inbox = inbox;
}
public String getSent() {
	return sent;
}
public void setSent(String sent) {
	this.sent = sent;
}
public String getDraft() {
	return draft;
}
public void setDraft(String draft) {
	this.draft = draft;
}


}

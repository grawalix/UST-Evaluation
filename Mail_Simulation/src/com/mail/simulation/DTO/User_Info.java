package com.mail.simulation.DTO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class User_Info implements Serializable {
@Id
@GenericGenerator(name = "auto",strategy = "increment")
@GeneratedValue(generator = "auto")
private int uid;
private String username;
private String password;
@Column(unique=true)
private String email;
private String question;
private String answer;
private int age;
@OneToMany(cascade = CascadeType.ALL)
@JoinColumn(referencedColumnName = "uid")
private List<Mail_Info> mlist;

public String getQuestion() {
	return question;
}
public void setQuestion(String question) {
	this.question = question;
}
public String getAnswer() {
	return answer;
}
public void setAnswer(String answer) {
	this.answer = answer;
}


public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public List<Mail_Info> getMlist() {
	return mlist;
}
public void setMlist(List<Mail_Info> mlist) {
	this.mlist = mlist;
}


}

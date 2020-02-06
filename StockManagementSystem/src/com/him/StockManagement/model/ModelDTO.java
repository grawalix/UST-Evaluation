package com.him.StockManagement.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="stockmodel")
public class ModelDTO {
	
	@Id
	@GenericGenerator(name="auto",strategy="increment")
	@GeneratedValue(generator="auto")
	private int pid;
	private String pname;
	private String pcategory;
	private String pcompany;
	private int pquantity;
	private double price;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Order_History",joinColumns=@JoinColumn(name="pid"),inverseJoinColumns=@JoinColumn(name="oid"))
	private List<OrderDTO>olist;
	
	public List<OrderDTO> getOlist() {
		return olist;
	}
	public void setOlist(List<OrderDTO> olist) {
		this.olist = olist;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPcategory() {
		return pcategory;
	}
	public void setPcategory(String pcategory) {
		this.pcategory = pcategory;
	}
	public String getPcompany() {
		return pcompany;
	}
	public void setPcompany(String pcompany) {
		this.pcompany = pcompany;
	}
	public int getPquantity() {
		return pquantity;
	}
	public void setPquantity(int pquantity) {
		this.pquantity = pquantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}


}

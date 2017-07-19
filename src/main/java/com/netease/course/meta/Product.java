package com.netease.course.meta;

import com.mysql.jdbc.Blob;

public class Product {
	int id;
	int price;
	String title;
	Blob icon;
	String abStract;
	Blob text;
	boolean isBuy;
	String image;

	public boolean isBuy() {
		return isBuy;
	}
	public void setBuy(boolean isBuy) {
		this.isBuy = isBuy;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Blob getIcon() {
		return icon;
	}
	public void setIcon(Blob icon) {
		this.icon = icon;
	}
	public String getAbStract() {
		return abStract;
	}
	public void setAbStract(String abStract) {
		this.abStract = abStract;
	}
	public Blob getText() {
		return text;
	}
	public void setText(Blob text) {
		this.text = text;
	}

}

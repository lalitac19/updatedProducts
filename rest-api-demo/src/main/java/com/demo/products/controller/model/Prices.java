package com.demo.products.controller.model;

import java.text.DecimalFormat;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Prices {
	
	private String was;
	private String then1;
	private String then2;
	private String now;
	private String currency;
	
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getWas() {
		return was;
	}
	public void setWas(String was) {
		this.was = was;
	}
	public String getThen1() {
		return then1;
	}
	public void setThen1(String then1) {
		this.then1 = then1;
	}
	public String getThen2() {
		return then2;
	}
	public void setThen2(String then2) {
		this.then2 = then2;
	}
	
	public String getNow() {
		return now;
	}
	public void setNow(Object now) {
		if(now instanceof String) {
			this.now = now.toString();
		}else 
			this.now = "";
	}
	
	public String formatPrice (String now) {
		String price = "";
		float nowFloat = Float.valueOf(now);
		if (nowFloat < 10.00) {
				price = new DecimalFormat("#.##").format(nowFloat);
			  } else {
				price = Integer.toString(Math.round(nowFloat));
			  }
 
		return "£"+ price;
	}
	@Override
	public String toString() {
		return "Prices [was=" + was + ", then1=" + then1 + ", then2=" + then2 + ", now=" + now + ", currency="
				+ currency + "]";
	} 
}

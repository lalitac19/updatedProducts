package com.demo.products.controller.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ColorSwatch {
	
	private String color; 
	private String basicColor;
	private String skuId;
	
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBasicColor() {
		return basicColor;
	}

	public void setBasicColor(String basicColor) {
		this.basicColor = basicColor;
	}

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	@Override
	public String toString() {
		return "ColorSwatch [Color=" + getColor() + ", BasicColor=" + getBasicColor() + ", SkuId="
				+ getSkuId() + "]";
	}

	public int hashCode(String code) { // java String#hashCode
	    int hash = 0;
	    for (int i = 0; i < code.length(); i++) {
	       hash = code.charAt(i) + ((hash << 5) - hash);
	    }
	    return hash;
	} 

	public static String intToARGB(int i){
	    return Integer.toHexString(((i>>24)&0xFF))+
	        Integer.toHexString(((i>>16)&0xFF))+
	        Integer.toHexString(((i>>8)&0xFF))+
	        Integer.toHexString((i&0xFF));
	}
	

}

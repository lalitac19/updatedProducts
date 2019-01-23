package com.demo.products.controller.model;

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

	 public  String colorToHex(String code) {
	        int hash = 0;
	        for (int i = 0; i < code.length(); i++) {
	            hash = code.charAt(i) + ((hash << 5) - hash);
	        }
	        return 
	                Integer.toHexString(((hash >>16)&0xFF))+
	                Integer.toHexString(((hash>>8)&0xFF))+
	                Integer.toHexString(((hash>>0)&0xFF));
	    }
}

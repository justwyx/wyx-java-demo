package com.sharpcj;

public class Product {
	private String name;  // 商品名称
	private double prePrice;  // 商品定价
	private double realPrice;  //商品实际售价

	public Product() {
	}

	public Product(String name, double prePrice) {
		this.name = name;
		this.prePrice = prePrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrePrice() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return prePrice;
	}

	public void setPrePrice(double prePrice) {
		this.prePrice = prePrice;
	}

	public double getRealPrice() {
		return realPrice;
	}

	public void setRealPrice(double realPrice) {
		this.realPrice = realPrice;
	}
}
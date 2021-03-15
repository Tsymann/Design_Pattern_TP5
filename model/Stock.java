package com.tactfactory.designpatternniveau1.command.tp1.model;

public class Stock {

	private String name; 
	private int quantity;
	private GlobalStock globalStock;
	
	public Stock(String nom) {
		this.name = nom;
		this.quantity = 0;
		this.globalStock = new GlobalStock();
	}
	
	public Stock(String nom, int quantité, GlobalStock globalStock) {
		this.name = nom;
		this.quantity = quantité;
		this.globalStock = globalStock;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGlobalStock(GlobalStock globalStock) {
		this.globalStock = globalStock;
	}

	public String getName() {
		return name;
	}

	public GlobalStock getGlobalStock() {
		return globalStock;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String toString() {
		return "Stock [ Name: " + name + ", Quantity: " + quantity + "]";
	}
	
	
}

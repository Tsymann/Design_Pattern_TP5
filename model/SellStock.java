package com.tactfactory.designpatternniveau1.command.tp1.model;

public class SellStock implements Command{

private Stock stock;
	
	public SellStock(Stock stock) {
		this.stock = stock;
	}


	public boolean execute() throws CloneNotSupportedException {
		for(Stock stock : this.stock.getGlobalStock().getStocks()) {
			if(stock.getName().equals(this.stock.getName())) {
				stock.setQuantity(stock.getQuantity() - this.stock.getQuantity());
				System.out.println(this.toString());
			}
		}
		return true;
	}
	
	public String toString() {
		return "Stock [ Name: " + stock.getName() + ", Quantity: " + stock.getQuantity() + "] sold";
	}
}

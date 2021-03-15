package com.tactfactory.designpatternniveau1.command.tp1.model;

public class BuyStock implements Command{

	private Stock stock;
	
	public BuyStock(Stock stock) {
		this.stock = stock;
	}

	public boolean execute() throws CloneNotSupportedException {
		for(Stock stock : this.stock.getGlobalStock().getStocks()) {
			if(stock.getName().equals(this.stock.getName())) {
				stock.setQuantity(stock.getQuantity() + this.stock.getQuantity());
				System.out.println(this.toString());
			}
		}
		return true;
	}
	
	public boolean executeUndo() throws CloneNotSupportedException {
		for(Stock stock : this.stock.getGlobalStock().getStocks()) {
			if(stock.getName().equals(this.stock.getName())) {
				stock.setQuantity(stock.getQuantity() + this.stock.getQuantity());
				System.out.println("Stock [ Name: " + stock.getName() + ", Quantity: " + stock.getQuantity() + "] undo sell");
			}
		}
		return true;
	}
	
	public Stock getStock() {
		return stock;
	}
	
	public String toString() {
		return "Stock [ Name: " + stock.getName() + ", Quantity: " + stock.getQuantity() + "] bought";
	}

}

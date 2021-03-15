package com.tactfactory.designpatternniveau1.command.tp1.model;

public class SellStock implements Command {

	private Stock stock;

	public SellStock(Stock stock) {
		this.stock = stock;
	}

	public boolean execute() throws CloneNotSupportedException {
		for(Stock stock : this.stock.getGlobalStock().getStocks()) {
			if(stock.getName().equals(this.stock.getName())) {
				if((stock.getQuantity() - this.stock.getQuantity()) < 0) {
					System.out.println("impossible, pas assez de stock pour vendre");
					return false;
				} else {
				stock.setQuantity(stock.getQuantity() - this.stock.getQuantity());
				System.out.println(this.toString());
				}
			}
		}
		return true;
	}

	public boolean executeUndo() throws CloneNotSupportedException {
		for (Stock stock : this.stock.getGlobalStock().getStocks()) {
			if (stock.getName().equals(this.stock.getName())) {
				stock.setQuantity(stock.getQuantity() - this.stock.getQuantity());
				System.out.println(
						"Stock [ Name: " + stock.getName() + ", Quantity: " + stock.getQuantity() + "] undo buy");
			}
		}
		return true;
	}

	public Stock getStock() {
		return stock;
	}

	public String toString() {
		return "Stock [ Name: " + stock.getName() + ", Quantity: " + stock.getQuantity() + "] sold";
	}

}

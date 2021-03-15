package com.tactfactory.designpatternniveau1.command.tp1.model;

import java.util.ArrayList;
import java.util.List;

import com.tactfactory.designpatternniveau1.command.tp1.utils.Invoker;

public class GlobalStock {

	private List<Stock> stocks = new ArrayList<Stock>();
	private Invoker invoker = new Invoker();

	public List<Stock> getStocks() {
		return stocks;
	}

	public void executeCommand(Command command) throws CloneNotSupportedException {
		if (command.execute()) {
			this.invoker.push(command);
		}
	}

	public void showHistory() {
		this.invoker.showHistory();
	}

	public void printStock() {
		if (!stocks.isEmpty()) {
			for (Stock stock : stocks) {
				System.out.println(stock.toString());
			}
		} else {
			System.out.println("il n'y a pas de stock");
		}
	}

	public void undo() throws CloneNotSupportedException {
		if (!this.invoker.isEmpty()) {
			Command lastCommand = this.invoker.pop();
			if (lastCommand instanceof BuyStock) {
				SellStock sellStock = new SellStock(
						new Stock(lastCommand.getStock().getName(), lastCommand.getStock().getQuantity(), this));
				sellStock.executeUndo();
			} else if (lastCommand instanceof SellStock) {
				BuyStock buyStock = new BuyStock(
						new Stock(lastCommand.getStock().getName(), lastCommand.getStock().getQuantity(), this));
				buyStock.executeUndo();
			}
			System.out.println("undo éffectué");
		} else {
			System.out.println("undo impossible");
		}
	}
}

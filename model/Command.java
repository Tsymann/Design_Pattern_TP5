package com.tactfactory.designpatternniveau1.command.tp1.model;

public interface Command {

	  public abstract boolean execute() throws CloneNotSupportedException;

	public abstract Stock getStock();
	  	  
}
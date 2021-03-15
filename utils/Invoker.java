package com.tactfactory.designpatternniveau1.command.tp1.utils;

import java.util.Stack;

import com.tactfactory.designpatternniveau1.command.tp1.model.Command;

public class Invoker {

  private Stack<Command> history = new Stack<>();

  public void push(Command c) {
      history.push(c);
  }

  public Command pop() {
      return history.pop();
  }

  public boolean isEmpty() { return history.isEmpty(); }

  public void showHistory() {
    System.out.println("Invoker history");
    for (Command command : history) {
      System.out.println(command.toString());
    }
  }
}
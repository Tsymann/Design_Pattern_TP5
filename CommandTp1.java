package com.tactfactory.designpatternniveau1.command.tp1;

import com.tactfactory.designpatternniveau1.command.tp1.model.*;

/**
*
* @author tactfactory
*
* - Le programme doit utiliser un design pattern "Command" afin d'avoir les éléments suivant :
*   - 1 : Le programme permettra de gérer des stocks d'élément :
*       - 1 : On définira GlobalStock comme possédant une liste de Stock
*       - 2 : On ne pourra rajouter dans un GlobalStock que des éléments de Stock configurer par leur nom et une
*           quantité initialement égale à zéro
*       - 3 : Un Stock, à part comme configuration d'un GlobalStock, sera toujours construit en prenant comme
*           informations un nom, une quantité et le GlobalStock au quel il appartient
*       - 4 : Un Stock pourra être acheté ou vendu
*   - 2 : Votre design pattern "Command" doit permettre :
*       - 1 : De concerver toutes les commandes d'achat et de vente
*       - 2 : D'appliquer en une fois toutes les commandes sur le GlobalStock qui leur est rattaché
*       - 3 : Attention il est possible de continuer à passer d'autre commandes d'achat et de vente avec les même objets
*   - 3 : Le lancement de l'application doit afficher les éléments suivant :
*
*       Stock [ Name: myItem,Quantity: 0]
*       Stock [ Name: apple,Quantity: 0]
*       Stock [ Name: pinapple,Quantity: 0]
*
*
*       Stock [ Name: myItem,Quantity: 20 ] bought
*       Stock [ Name: myItem,Quantity: 20 ] sold
*       Stock [ Name: apple,Quantity: 4 ] sold
*       Stock [ Name: pinapple,Quantity: 7 ] bought
*
*
*       Stock [ Name: myItem,Quantity: 0]
*       Stock [ Name: apple,Quantity: -4]
*       Stock [ Name: pinapple,Quantity: 7]
*/
public class CommandTp1 {
  public static void main(String[] args) throws CloneNotSupportedException {

	  GlobalStock globalStock = new GlobalStock();
	  globalStock.getStocks().add(new Stock("myItem"));
	  globalStock.getStocks().add(new Stock("apple"));
	  globalStock.getStocks().add(new Stock("pinapple"));
	  
	  
	  globalStock.printStock();
	  
	  
	  System.out.println("\n");

	  BuyStock buyStock1 = new BuyStock(new Stock("myItem", 20, globalStock));
	  SellStock sellStock1 = new SellStock(new Stock("myItem", 20, globalStock));
	  globalStock.executeCommand(buyStock1);
	  globalStock.executeCommand(sellStock1);
	  
	  SellStock sellStock2 = new SellStock(new Stock("apple", 4, globalStock));
	  globalStock.executeCommand(sellStock2);

	  BuyStock BuyStock2 = new BuyStock(new Stock("pinapple", 7, globalStock));
	  globalStock.executeCommand(BuyStock2);

	  System.out.println("\n");
	  
	  globalStock.printStock();
	  
	  System.out.println("\n");

	  
	  globalStock.showHistory();
	  
  }
}

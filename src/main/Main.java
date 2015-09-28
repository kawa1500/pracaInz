package main;

import view.PanelLogowania;
import dataBase.DataBase;

public class Main {

	public Main(){
		
	}
	public static DataBase	dataBase = new DataBase();
	public static void main(String[] args) {
		Main main = new Main();
		PanelLogowania pl = new PanelLogowania(main);
		
	}
	


}

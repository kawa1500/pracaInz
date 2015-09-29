package main;

import view.PanelLogowania;

import java.io.IOException;
import java.util.Enumeration;

import USART.USART;
import dataBase.DataBase;
import gnu.io.CommPortIdentifier;

public class Main {

	static Enumeration	      portList;
	static CommPortIdentifier portId;
	static boolean		      portFound = false;
    static String		      defaultPort = "COM1";
    public static USART reader=null;
	public Main(){
		
	}
	public static DataBase	dataBase = new DataBase();
	public static void main(String[] args) {
		Main main = new Main();
		PanelLogowania pl = new PanelLogowania(main);
		
		
		

	 	if (args.length > 0) {
		    defaultPort = args[0];
		} 
	   
		portList = CommPortIdentifier.getPortIdentifiers();

		while (portList.hasMoreElements()) {
		    portId = (CommPortIdentifier) portList.nextElement();
		    if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
		    	if (portId.getName().equals(defaultPort)) {
		    		System.out.println("Found port: "+defaultPort);
		    		portFound = true;
		    		reader = new USART(portId,pl);
		    	} 
		    } 
		} 
		
		if (!portFound) {
		    System.out.println("port " + defaultPort + " not found.");
		}
		
	}
	
	
	


}

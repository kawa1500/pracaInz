package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import log.Log;

public class DataBase {

	Connection 		connection;
	Statement 		statement;
	String 			DB_URL 					= "jdbc:sqlite:tester.db";
	boolean			statusPolaczenia		= false;
	public 			Funkcje			funkcja;
	
	public DataBase() {
		polacz();
		funkcja = new Funkcje(this);
	}

	public boolean polacz(){
		
		try{
			connection = DriverManager.getConnection(DB_URL);
			statement = connection.createStatement();
			statusPolaczenia = true;
			Log.logKomunikat("Pol¹czono z baz¹ danych",false);
		}catch(SQLException e){
			statusPolaczenia = false;
			Log.logKomunikat("Nie mo¿na po³¹czyæ z baz¹ danych "+e.getLocalizedMessage(),true);
		}
		return statusPolaczenia;
	}
	
	public boolean rozlacz(){
		
		try{
			connection.close();
			Log.logKomunikat("Roz³¹czono z baza danych", false);
			statusPolaczenia = false;
		}catch(SQLException e){
			Log.logKomunikat("Nie mo¿na roz³¹czyæ z baza danych "+e.getLocalizedMessage(), true);
		}	
		return statusPolaczenia;
	}
	
}

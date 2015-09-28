package dataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import log.Log;
import modele.GroupModel;
import modele.OdczytModel;
import modele.PomiarModel;

public class Funkcje {

	DataBase		dataBase;
	ResultSet		result;
	
	public Funkcje(DataBase dataBase) {
		this.dataBase = dataBase;
	}
// operacje na grupach
	public void dodajGrupe(String nazwaGrupy)
	{
		String zapytanie = "INSERT INTO TB__GRUPY_POMIARU(NAZWA_GRUPY, DATA_UTWORZENIA) VALUES (\""+nazwaGrupy+"\",\""+obecnaData()+"\")";
		try{
			dataBase.statement.execute(zapytanie);
			Log.logKomunikat("Dodano now¹ grupê do bazy danych", false);
		}catch(SQLException e){
			Log.logKomunikat("Nie mozna wykonac zapytania "+e.getLocalizedMessage(), true);
		}	
	}
	
	public GroupModel getGroupModel(int id){
		GroupModel wynik = new GroupModel();
		String zapytanie = "SELECT * FROM TB__GRUPY_POMIARU WHERE ID_GRUPY="+id;
		try{
			result=dataBase.statement.executeQuery(zapytanie);
			while(result.next())
			{
				wynik = new GroupModel(result.getInt(1), 
						result.getString(2), 
						result.getString(3));				
			}
			Log.logKomunikat("Pobrano grup o ID "+id, false);
		}catch(SQLException e){
			Log.logKomunikat("Nie mozna wykonac zapytania "+e.getLocalizedMessage(), true);
		}
		return wynik;
	}
	
	public LinkedList<GroupModel> pobierzListeGrup()
	{
		LinkedList<GroupModel> wynik = new LinkedList<>();
		String zapytanie = "SELECT * FROM TB__GRUPY_POMIARU";
		try{
			result=dataBase.statement.executeQuery(zapytanie);
			while(result.next())
			{
				wynik.add(new GroupModel(result.getInt(1), 
										result.getString(2), 
										result.getString(3)));
				
			}
			Log.logKomunikat("Pobrano liste grup", false);
		}catch(SQLException e){
			Log.logKomunikat("Nie mozna wykonac zapytania "+e.getLocalizedMessage(), true);
		}	
		return wynik;
	}

	
//operacje na pomiarach
	public void dodajPomiar(String nazwaPomiaru,Integer idGrupy){
		String zapytanie = "INSERT INTO TB__POMIARY(NAZWA_POMIARU, DATA_UTWORZENIA, ID_GRUPY) VALUES (\""+
					nazwaPomiaru+"\",\""+obecnaData()+"\",\""+idGrupy+"\")";
		try{
			dataBase.statement.execute(zapytanie);
			Log.logKomunikat("Dodano nowy pomiar do bazy danych", false);
		}catch(SQLException e){
			Log.logKomunikat("Nie mozna wykonac zapytania "+e.getLocalizedMessage(), true);
		}
	}
	
	public PomiarModel getPomiar(int id){
		PomiarModel wynik = new PomiarModel();
		String zapytanie = "SELECT * FROM TB__POMIARY WHERE ID_POMIARU="+id;
		try{
			result=dataBase.statement.executeQuery(zapytanie);
			while(result.next())
			{
				if(result.getInt(4)>0){
					wynik = new PomiarModel(
							result.getInt(1), 
							result.getString(2), 
							result.getString(3), 
							getGroupModel(result.getInt(4)));
				}
				else{
					wynik = new PomiarModel(
							result.getInt(1), 
							result.getString(2), 
							result.getString(3));
				}
			}
			Log.logKomunikat("Pobrano pomiar o ID "+id, false);
		}catch(SQLException e){
			Log.logKomunikat("Nie mozna wykonac zapytania "+e.getLocalizedMessage(), true);
		}
		return wynik;
	}
	
	public LinkedList<PomiarModel> pobierzListePomiarow(int idGrupy){
		LinkedList<PomiarModel> wynik = new LinkedList<>();
		String zapytanie = "SELECT * FROM TB__POMIARY WHERE ID_POMIARU="+idGrupy;
		try{
			result=dataBase.statement.executeQuery(zapytanie);
			while(result.next())
			{
					wynik.add(new PomiarModel(
							result.getInt(1), 
							result.getString(2), 
							result.getString(3), 
							getGroupModel(result.getInt(4))));
				
				
			}
			Log.logKomunikat("Pobrano liste pomiarów dal ID grupy "+idGrupy, false);
		}catch(SQLException e){
			Log.logKomunikat("Nie mozna wykonac zapytania "+e.getLocalizedMessage(), true);
		}	
		return wynik;
	}

//operacje na napieciach
	public void dodajWartoscNapiecia(double wartosc, String jednostka, Integer idPomiaru){
		String zapytanie = "INSERT INTO TB__NAPIECIE(WARTOSC, JEDNOSTKA, DATA_UTWORZENIA, ID_POMIARU) VALUES (\""+
				wartosc+"\",\""+jednostka+"\",\""+obecnaData()+"\",\""+idPomiaru+"\")";
		try{
			dataBase.statement.execute(zapytanie);
			Log.logKomunikat("Dodano nowe napiêcie do bazy danych", false);
		}catch(SQLException e){
			Log.logKomunikat("Nie mozna wykonac zapytania "+e.getLocalizedMessage(), true);
		}
	}
	
	public LinkedList<OdczytModel> pobierzListeNapiec(int idPomiaru){
		LinkedList<OdczytModel> wynik = new LinkedList<>();
		String zapytanie = "SELECT * FROM TB__NAPIECIE WHERE ID_POMIARU="+idPomiaru;
		try{
			result=dataBase.statement.executeQuery(zapytanie);
			while(result.next())
			{
					wynik.add(new OdczytModel(
							result.getInt(1),
							result.getDouble(2),
							result.getString(3),
							result.getString(4),
							getPomiar(idPomiaru),
							OdczytModel.NAPIECIE));	
			}
			Log.logKomunikat("Pobrano liste napiec dla ID "+idPomiaru, false);
		}catch(SQLException e){
			Log.logKomunikat("Nie mozna wykonac zapytania "+e.getLocalizedMessage(), true);
		}	
		return wynik;
	}
	
//operacje na pradach
	public void dodajWartoscPradu(double wartosc, String jednostka, Integer idPomiaru){
		String zapytanie = "INSERT INTO TB__PRAD(WARTOSC, JEDNOSTKA, DATA_UTWORZENIA, ID_POMIARU) VALUES (\""+
					wartosc+"\",\""+jednostka+"\",\""+obecnaData()+"\",\""+idPomiaru+"\")";
		try{
			dataBase.statement.execute(zapytanie);
			Log.logKomunikat("Dodano nowy prad do bazy danych", false);
		}catch(SQLException e){
			Log.logKomunikat("Nie mozna wykonac zapytania "+e.getLocalizedMessage(), true);
		}
	}
	
	public LinkedList<OdczytModel> pobierzListePradow(int idPomiaru){
		LinkedList<OdczytModel> wynik = new LinkedList<>();
		String zapytanie = "SELECT * FROM TB__PRAD WHERE ID_POMIARU="+idPomiaru;
		try{
			result=dataBase.statement.executeQuery(zapytanie);
			while(result.next())
			{
					wynik.add(new OdczytModel(
								result.getInt(1),
								result.getDouble(2),
								result.getString(3),
								result.getString(4),
								getPomiar(idPomiaru),
								OdczytModel.PRAD));	
			}
			Log.logKomunikat("Pobrano liste pradow dla ID "+idPomiaru, false);
		}catch(SQLException e){
			Log.logKomunikat("Nie mozna wykonac zapytania "+e.getLocalizedMessage(), true);
		}	
		return wynik;
	}
		
//operacje na czasie
	public void dodajWartoscCzasu(double wartosc, String jednostka, Integer idPomiaru){
		String zapytanie = "INSERT INTO TB__CZASY(WARTOSC, JEDNOSTKA, DATA_UTWORZENIA, ID_POMIARU) VALUES (\""+
					wartosc+"\",\""+jednostka+"\",\""+obecnaData()+"\",\""+idPomiaru+"\")";
		try{
			dataBase.statement.execute(zapytanie);
			Log.logKomunikat("Dodano nowe napiêcie do bazy danych", false);
		}catch(SQLException e){
			Log.logKomunikat("Nie mozna wykonac zapytania "+e.getLocalizedMessage(), true);
		}
	}
	
	public LinkedList<OdczytModel> pobierzListeCzasow(int idPomiaru){
		LinkedList<OdczytModel> wynik = new LinkedList<>();
		String zapytanie = "SELECT * FROM TB__CZASY WHERE ID_POMIARU="+idPomiaru;
		try{
			result=dataBase.statement.executeQuery(zapytanie);
			while(result.next())
			{
						wynik.add(new OdczytModel(
								result.getInt(1),
								result.getDouble(2),
								result.getString(3),
								result.getString(4),
								getPomiar(idPomiaru),
								OdczytModel.CZAS));	
			}
			Log.logKomunikat("Pobrano liste czasow dla ID "+idPomiaru, false);
		}catch(SQLException e){
			Log.logKomunikat("Nie mozna wykonac zapytania "+e.getLocalizedMessage(), true);
		}	
		return wynik;
	}

	private String obecnaData()
	{
		String data="";
		Date date = new Date();
		SimpleDateFormat ft = 
			      new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		data = ft.format(date);
		return data;
	}
	
	
	
}

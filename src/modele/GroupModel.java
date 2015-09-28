package modele;

public class GroupModel {

	private 		int			idGrupy;
	private 		String 		nazwa;
	private 		String		dataUtworzenia;
	
	public GroupModel() {
		// TODO Auto-generated constructor stub
	}

	public GroupModel(int id, String nazwa, String data)
	{
		this.idGrupy=id;
		this.nazwa=nazwa;
		this.dataUtworzenia=data;
	}
	public void setId(int id){
		this.idGrupy=id;
	}
	
	public int getId(){
		return this.idGrupy;
	}
	
	public void setNazwa(String nazwa){
		this.nazwa=nazwa;
	}
	
	public String getNazwa(){
		return this.nazwa;
	}
	
	public void setDataUtworzenia(String data){
		this.dataUtworzenia=data;
	}
	
	public String getDataUtworzenia(){
		return this.dataUtworzenia;
	}
}

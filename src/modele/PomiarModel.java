package modele;

public class PomiarModel {

	private			int			id;
	private 		String		nazwa;
	private			String		dataUtworzenia;
	private			GroupModel	parent;
	
	public PomiarModel() {
		
	}
	
	public PomiarModel(int id, String nazwa, String dataUtworzenia,
			GroupModel parent) {
		this.id = id;
		this.nazwa = nazwa;
		this.dataUtworzenia = dataUtworzenia;
		this.parent = parent;
	}

	
	public PomiarModel(int id, String nazwa, String dataUtworzenia) {
		this.id = id;
		this.nazwa = nazwa;
		this.dataUtworzenia = dataUtworzenia;
	}

	
	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getDataUtworzenia() {
		return dataUtworzenia;
	}

	public void setDataUtworzenia(String dataUtworzenia) {
		this.dataUtworzenia = dataUtworzenia;
	}

	public GroupModel getParent() {
		return parent;
	}

	public void setParent(GroupModel parent) {
		this.parent = parent;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id){
		this.id=id;
	}
}

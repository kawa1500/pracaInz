package modele;

public class OdczytModel {

	private 		int 		id;
	private			double		wartosc;
	private			String 		jednostka;
	private			String 		dataUtworzenia;
	private			PomiarModel	parent;
	private			int			typ;
	
	public static int		NAPIECIE=1;
	public static int		PRAD=2;
	public static int		CZAS=3;
	
	public OdczytModel() {
	
	}

	public OdczytModel(int id, double wartosc, String jednostka,
			String dataUtworzenia, PomiarModel parent, int typ) {
		this.id = id;
		this.wartosc = wartosc;
		this.jednostka = jednostka;
		this.dataUtworzenia = dataUtworzenia;
		this.parent = parent;
		this.typ = typ;
	}

	public OdczytModel(int id, double wartosc, String jednostka,
			String dataUtworzenia, int typ) {
		this.id = id;
		this.wartosc = wartosc;
		this.jednostka = jednostka;
		this.dataUtworzenia = dataUtworzenia;
		this.typ = typ;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getWartosc() {
		return wartosc;
	}

	public void setWartosc(double wartosc) {
		this.wartosc = wartosc;
	}

	public String getJednostka() {
		return jednostka;
	}

	public void setJednostka(String jednostka) {
		this.jednostka = jednostka;
	}

	public String getDataUtworzenia() {
		return dataUtworzenia;
	}

	public void setDataUtworzenia(String dataUtworzenia) {
		this.dataUtworzenia = dataUtworzenia;
	}

	public int getTyp() {
		return typ;
	}

	public void setTyp(int typ) {
		this.typ = typ;
	}

	public PomiarModel getParent() {
		return parent;
	}

	public void setParent(PomiarModel parent) {
		this.parent = parent;
	}

}

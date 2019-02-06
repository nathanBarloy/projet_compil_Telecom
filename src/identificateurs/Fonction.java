package identificateurs;

import tableSymbole.TableSymboles;

public class Fonction extends Identificateur {
	private Type typeRetour;
	private TableSymboles tdsFonction;

	public Fonction(String name, Type retour,TableSymboles tds) {
		super(name);
		this.typeRetour=retour;
		this.tdsFonction=tds;
	}

	public TableSymboles getTdsFonction() {
		return tdsFonction;
	}



}

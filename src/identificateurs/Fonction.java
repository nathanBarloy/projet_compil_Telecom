package identificateurs;

import tableSymbole.TableSymbolesAbs;

public class Fonction extends Identificateur {
	private Type typeRetour;
	private TableSymbolesAbs tdsFonction;

	public Fonction(String name, Type retour,TableSymbolesAbs tds) {
		super(name);
		this.typeRetour=retour;
		this.tdsFonction=tds;
	}

	public TableSymbolesAbs getTdsFonction() {
		return tdsFonction;
	}
	public Type getTypeRetour() {
		return typeRetour;
	}



}

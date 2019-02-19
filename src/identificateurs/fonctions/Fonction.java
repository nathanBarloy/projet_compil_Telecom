package identificateurs.fonctions;

import identificateurs.Identificateur;
import identificateurs.Type;
import tableSymbole.TableSymbolesAbs;

public abstract class Fonction extends Identificateur {
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

	public String genererCode()
	{
		String res=nom+"_ \t\n";
		res+=codeAssembleurFonction();
		return res+'\n';
	}
	
	@Override
	public String toString() {
		return "Fonction '"+nom+"' [typeRetour : '" + typeRetour.getName() + "', tdsFonction=" + tdsFonction + "]";
	}
	
	protected abstract String codeAssembleurFonction();
	



}

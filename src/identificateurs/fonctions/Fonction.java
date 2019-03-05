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
		res+="\tSTW BP, -(SP)\n"; // empile le contenu du registre BP
		res+="\tLDW BP, SP\n"; // charge contenu SP ds BP
		res+=codeAssembleurFonction();
		res+="\tLDW SP, BP\n"; // abandon infos locales
		res+="\tLDW BP, (SP)+\n"; // charge BP avec ancien BP
		res+="\tRTS"; // retour au programme appelant
		return res+'\n';
	}
	
	@Override
	public String toString() {
		return "Fonction '"+nom+"' [typeRetour : '" + typeRetour.getName() + "', tdsFonction=" + tdsFonction + "]";
	}
	
	protected abstract String codeAssembleurFonction();
	



}

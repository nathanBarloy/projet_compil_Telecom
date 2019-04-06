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
	
	public String nomCodeFonction()
	{
		return nom+"_ \t\n";
	}
	
	public String debutFonction()
	{
		String res=nomCodeFonction();
		res+="\tSTW BP, -(SP)\n"; // empile le contenu du registre BP
		res+="\tLDW BP, SP\n"; // charge contenu SP ds BP
		return res;
	}
	
	public String finFonction()
	{
		String res ="\tLDW SP, BP\n"; // abandon infos locales
		res+="\tLDW BP, (SP)+\n"; // charge BP avec ancien BP
		res+="\tRTS"; // retour au programme appelant
		return res+'\n';
	}

	public String genererCode()
	{
		return "";		
	}
	
	@Override
	public String toString() {
		return "Fonction '"+nom+"' [typeRetour : '" + typeRetour.getName() + "', tdsFonction=" + tdsFonction + "]";
	}
	
	protected abstract String codeAssembleurFonction();
	



}

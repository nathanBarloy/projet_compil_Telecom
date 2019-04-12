package identificateurs.fonctions;

import generationCode.GenerateurDeCode;
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
		res+="\tSTW BP, -(SP) //empile le contenu du registre BP\n"; // empile le contenu du registre BP
		res+="\tLDW BP, SP //charge contenu SP ds BP\n"; // charge contenu SP ds BP
		res+="\tSTW WR, -(SP) //On empile le chainage statique contenu dans WR\n";//on empile le statique
		res+=GenerateurDeCode.sauvegarderRegistres();
		return res;
	}
	
	public String finFonction()
	{
		String res = GenerateurDeCode.restaurerRegistres();
		res +="\tADQ 2,SP\n";
		res+="\tLDW SP, BP //abandon infos locales\n"; // abandon infos locales
		res+="\tLDW BP, (SP)+ //charge BP avec ancien BP\n"; // charge BP avec ancien BP
		res+="\tRTS"; // retour au programme appelant
		return res+'\n';
	}

	public String genererCode()
	{
		String res=debutFonction();
		res+=codeAssembleurFonction();
		res+=finFonction();
		return res;		
	}
	
	@Override
	public String toString() {
		return "Fonction '"+nom+"' [typeRetour : '" + typeRetour.getName() + "', tdsFonction=" + tdsFonction + "]";
	}
	
	protected abstract String codeAssembleurFonction();
	



}

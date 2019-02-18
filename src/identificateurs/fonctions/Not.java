package identificateurs.fonctions;

import identificateurs.Type;

public class Not extends Fonction {

	public Not(Type retour) {
		super("not", retour, null);
	}

	@Override
	public String genererCode() {
		String codeAssembleur="";
		//TODO : On déplace l'adresse de la variable dont on veut la négation dans un registre
		codeAssembleur += "NEG R1,R2";
		return codeAssembleur;
	}
	
	
}

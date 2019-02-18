package identificateurs.fonctions;

import identificateurs.Type;
import identificateurs.TypePrimitif;

public class Not extends Fonction {

	public Not() {
		super("not", TypePrimitif.INT, null);
	}

	@Override
	protected String codeAssembleurFonction() {
		String codeAssembleur="";
		//TODO : On déplace l'adresse de la variable dont on veut la négation dans un registre if i=0 then 1 else 0.
		codeAssembleur += "\tNEG R1,R2";
		return codeAssembleur;
	}

	
	
	
}

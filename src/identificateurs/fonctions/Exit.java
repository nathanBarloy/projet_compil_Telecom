package identificateurs.fonctions;

import identificateurs.TypePrimitif;

public class Exit extends Fonction {

	public Exit() {
		super("exit", TypePrimitif.VOID, null);
	}

	@Override
	public String genererCode() {
		String codeAssembleur="";
		codeAssembleur += "LDQ EXIT_EXC, WR"; // charge n° de trappe EXIT dans registre WR
		codeAssembleur += "TRP WR"; // lance la trappe EXIT
		return codeAssembleur;
	}
	
	
}

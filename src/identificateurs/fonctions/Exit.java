package identificateurs.fonctions;

import identificateurs.TypePrimitif;

public class Exit extends FonctionBase {

	public Exit() {
		super("exit", TypePrimitif.VOID);
	}

	@Override
	protected String codeAssembleurFonction() {
		String codeAssembleur="";
		codeAssembleur += "\tLDQ EXIT_EXC, WR\n"; // charge n° de trappe EXIT dans registre WR
		codeAssembleur += "\tTRP WR\n"; // lance la trappe EXIT
		return codeAssembleur;
	}
	
	
	
	
}

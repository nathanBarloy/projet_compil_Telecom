package identificateurs.fonctions;

import identificateurs.Type;
import identificateurs.TypePrimitif;

public class Not extends FonctionBase {

	private final static String REGISTRESOURCE = "R1";
	private final static String REGISTREDESTINATION = "R2";
	public Not() {
		super("not", TypePrimitif.INT);
	}

	@Override
	protected String codeAssembleurFonction() {
		String codeAssembleur="";
		//TODO : On déplace l'adresse de la variable dont on veut la négation dans un registre if i=0 then 1 else 0.
		codeAssembleur += "\tNOT "+REGISTRESOURCE+","+REGISTREDESTINATION+'\n';
		return codeAssembleur;
	}

	
	
	
}

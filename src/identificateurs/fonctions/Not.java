package identificateurs.fonctions;

import identificateurs.Type;
import identificateurs.TypePrimitif;

public class Not extends FonctionBase {

	private final static String REGISTRESOURCE = "R0";
	private final static String REGISTREDESTINATION = "R0";
	public Not() {
		super("not", TypePrimitif.INT);
	}

	@Override
	protected String codeAssembleurFonction() {
		String codeAssembleur="";
		//TODO : On déplace l'adresse de la variable dont on veut la négation dans un registre if i=0 then 1 else 0.
		codeAssembleur+="\tLDW WR,BP\t// On recupere la base\n";
		codeAssembleur+="\tADQ 4,WR\t//On recupere l'adresse du parametre\n";
		codeAssembleur+="\tLDW R0, (WR)\t//On met le parametre dans R0\n";
		codeAssembleur+="\tLDW R1, #0\t//On charge 0 dans R1\n";
		codeAssembleur+="\tCMP R0,R1\n";
		codeAssembleur+="\tBNE 6\n";
		codeAssembleur+="\tLDW R0, #1\t//On met 1 dans R0\n";
		codeAssembleur+="\tBMP 2\n";
		codeAssembleur+="\tLDW R0, #0\t//Pas egal donc 0 dans R0\n";
		
		
		
		return codeAssembleur;
	}

	
	
	
}

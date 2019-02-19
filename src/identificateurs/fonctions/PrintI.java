package identificateurs.fonctions;

import identificateurs.Type;
import identificateurs.TypePrimitif;
import tableSymbole.TableSymbolesAbs;

public class PrintI extends Fonction {

	public PrintI() {
		super("printi", TypePrimitif.VOID, null);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected String codeAssembleurFonction() {
		//TODO : déplacer l'adresse de la variable à afficher dans R0
		//R0 contient l'adresse de la chaîne de caractères se terminant par NUL ;
		String codeAssembleur="";
		codeAssembleur +="\tLDQ WRITE_EXC, WR\n"; // charge n° de trappe WRITE dans registre WR
		codeAssembleur +="\tTRP WR\n"; // lance la trappe WRITE
		return codeAssembleur;
	}

	
}

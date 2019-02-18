package identificateurs.fonctions;

import identificateurs.Type;
import identificateurs.TypePrimitif;
import tableSymbole.TableSymbolesAbs;

public class GetChar extends Fonction {

	public GetChar() {
		super("getchar", TypePrimitif.STRING, null);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String codeAssembleurFonction() {
		//R0 contient l'adresse de la zone mémoire où placer la chaîne de caractères qui sera terminée par NUL;
		String codeAssembleur="";
		codeAssembleur+="\tLDQ READ_EXC, WR\n"; // charge n° de trappe READ dans registre WR
		codeAssembleur+="\tTRP WR\n"; // lance la trappe READ
		return codeAssembleur;
	}



}

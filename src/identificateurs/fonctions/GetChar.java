package identificateurs.fonctions;

import identificateurs.Type;
import tableSymbole.TableSymbolesAbs;

public class GetChar extends Fonction {

	public GetChar(Type retour) {
		super("getchar", retour, null);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String genererCode() {
		// TODO 
		//R0 contient l'adresse de la zone mémoire où placer la chaîne de caractères qui sera terminée par NUL;
		String codeAssembleur="";
		codeAssembleur+="LDQ READ_EXC, WR"; // charge n° de trappe READ dans registre WR
		codeAssembleur+="TRP WR"; // lance la trappe READ
		return codeAssembleur;
	}
	
	
	
}

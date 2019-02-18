package identificateurs.fonctions;

import identificateurs.Fonction;
import identificateurs.Type;

public class Print extends Fonction{

	public Print(Type retour) {
		super("print", retour, null);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String genererCode() {
		//TODO : déplacer l'adresse de la variable à afficher dans R0
		//R0 contient l'adresse de la chaîne de caractères se terminant par NUL ;
		String codeAssembleur="";
		codeAssembleur +="LDQ WRITE_EXC, WR"; // charge n° de trappe WRITE dans registre WR
		codeAssembleur +="TRP WR"; // lance la trappe WRITE
		return codeAssembleur;
	}
	
	

}

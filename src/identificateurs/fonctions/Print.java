package identificateurs.fonctions;

import identificateurs.TypePrimitif;

public class Print extends FonctionBase{

	public Print() {
		super("print", TypePrimitif.VOID);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String codeAssembleurFonction() {
		//TODO : déplacer l'adresse de la variable à afficher dans R0
		//R0 contient l'adresse de la chaîne de caractères se terminant par NUL ;
		String codeAssembleur="";
		//on déplace le paramètre dans R0
		codeAssembleur+="\tLDW R0,BP//On charge le BasePointer dans le Work Register\n";
		codeAssembleur+="\tADQ 4,R0//On remonte de 2 pour arriver au paramètre\n";
		codeAssembleur +="\tLDW R0,(R0)//On charge l'adresse du paramètre dans R0\n";
		codeAssembleur +="\tLDQ WRITE_EXC, WR\n"; // charge n° de trappe WRITE dans registre WR
		codeAssembleur +="\tTRP WR\n"; // lance la trappe WRITE
		return codeAssembleur;
	}
}

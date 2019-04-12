package identificateurs.fonctions;

import identificateurs.Type;
import identificateurs.TypePrimitif;
import tableSymbole.TableSymbolesAbs;

public class GetChar extends FonctionBase {

	public GetChar() {
		super("getchar", TypePrimitif.STRING);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String codeAssembleurFonction() {
		//R0 contient l'adresse de la zone mémoire où placer la chaîne de caractères qui sera terminée par NUL;
		String codeAssembleur="";
		codeAssembleur+="\tSTW R0, -(SP)\n";
		codeAssembleur+="\tLDW R0, SP\t//On met l'adresse du haut de la pile dans R0\n";
		codeAssembleur+="\tLDQ READ_EXC, WR\n"; // charge n° de trappe READ dans registre WR
		codeAssembleur+="\tTRP WR\n"; // lance la trappe READ
		codeAssembleur+="\tLDW R0, (SP)\t//On met la valeur de retour dans R0\n";
		codeAssembleur+="\tADQ 2, SP\n";
		return codeAssembleur;
	}



}

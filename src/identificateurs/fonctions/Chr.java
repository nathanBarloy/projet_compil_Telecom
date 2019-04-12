package identificateurs.fonctions;

import identificateurs.Type;
import identificateurs.TypePrimitif;
import tableSymbole.TableSymbolesAbs;

public class Chr extends FonctionBase {

	public Chr() {
		super("chr", TypePrimitif.STRING);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String codeAssembleurFonction() {
		// TODO Retourne le caractère correspondant au code ASCII passé en paramètre
		String codeAssembleur="";
		codeAssembleur+="\tLDW WR,BP\t// On recupere la base\n";
		codeAssembleur+="\tADQ 4,WR\t//On recupere l'adresse du parametre\n";
		codeAssembleur+="\tLDW R0, (WR)\t//On met le parametre dans R0\n";
		codeAssembleur+="\tLDW R1, #256\t//On met R1 a 256\n";
		codeAssembleur+="\tLDW R2, #10\t//Valeur max\n";
		codeAssembleur+="\tLDW R3, #0\t//Valeur min \n";
		codeAssembleur+="\tCMP R0, R3\t//Test si R0 superieur a 0\n";
		codeAssembleur+="\tBLW 4\t//Si non exit\n";
		codeAssembleur+="\tCMP R0, R2\t//Test si R0 inferieur a la valeur max\n";
		codeAssembleur+="\tBLW 4\t//Si non, exit\n";
		codeAssembleur+="\tLDQ EXIT_EXC, WR\n"; // charge n° de trappe EXIT dans registre WR
		codeAssembleur+="\tTRP WR\n"; // lance la trappe EXIT
		codeAssembleur+="\tADQ 48, R0\t//On convertit en ASCII\n";	
		codeAssembleur+="\tMUL R0, R1, R0\t//On decale de 8 bits\n";
		codeAssembleur+="\tSTW R0, (HP)\t//On met la valeur dans le tas\n";
		codeAssembleur+="\tLDW R0, HP\t//On met l'adresse du char dans R0\n";
		codeAssembleur+="\tADQ 2, HP\t//On incremente HP\n";
		codeAssembleur+="\tBLW 2\n";


		return codeAssembleur;
	}
	
	
	
	
	
	

}

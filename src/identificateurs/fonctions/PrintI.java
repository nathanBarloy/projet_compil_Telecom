package identificateurs.fonctions;

import generationCode.GenerateurDeCode;
import identificateurs.Type;
import identificateurs.TypePrimitif;
import tableSymbole.TableSymbolesAbs;

public class PrintI extends FonctionBase {

	public PrintI() {
		super("printi", TypePrimitif.VOID);
		// TODO Auto-generated constructor stub
	}
	
	
	protected String codeAssembleurFonction() {
		//TODO : déplacer l'adresse de la variable à afficher dans R0
		//R0 contient l'adresse de la chaîne de caractères se terminant par NUL ;
		
		/* Realiser des divisions entiere par 10 successives 
		 * Stocke le reste en haut de la pile
		 * S'arrete quand le nombre a diviser est inferieur a 10
		 * Affiche ensuite a partir du haut de la pile chaque chiffre un par un
		 * Stocke dans R3 le nombre de chiffre a afficher
		 * */
		String codeAssembleur="";
		codeAssembleur+="\tLDW WR,BP\t// On recupere la base\n";
		codeAssembleur+="\tADQ 4,WR\t//On recupere l'adresse du parametre\n";
		codeAssembleur+="\tLDW R0, (WR)\t//On met le parametre dans R0\n";
		codeAssembleur +="\tLDQ WRITE_EXC, WR\n"; // charge n° de trappe WRITE dans registre WR
		codeAssembleur+="\tLDW R1, #10\t//On met 10 dans R1 (servira pour les division)\n";
		codeAssembleur+="\tLDW R3, #0\t//On met R3 a 0\n";
		codeAssembleur+="\tLDW R4, #0\t//On met R4 a 0\n";
		codeAssembleur+="\tLDW R5, #256\t//On met R5 a 256\n";
		codeAssembleur+="division\n";
		codeAssembleur+="\tADQ 1, R3\t//On incremente R3\n";
		codeAssembleur+="\tCMP R0, R1\t//On verifie si R0 est superieur a R1\n";
		codeAssembleur+="\tBLW 12\t//Si oui on passe a l'affichage\n";
		codeAssembleur+="\tDIV R0, R1, R2\t//On divise R0 par 10, resultat dans R2 et reste dans R0\n";
		codeAssembleur+="\tADQ 48, R0\t//on convertit en ASCII\n";
		codeAssembleur+="\tMUL R0, R5, R0\t//On decale de 8 bits\n";
		codeAssembleur+="\tSTW R0, -(SP)\t//On empile le reste\n";
		codeAssembleur+="\tLDW R0,R2\t//On met le resultat dans R0\n";
		codeAssembleur+="\tJEA @division\t//On repete l'operation\n";
		codeAssembleur+="\tADQ 48, R0\t//On convertit en ASCII\n";	
		codeAssembleur+="\tMUL R0, R5, R0\t//On decale de 8 bits\n";
		codeAssembleur+="\tSTW R0, -(SP)\t//On empile le reste\n";
		codeAssembleur+="affichage\n";
		codeAssembleur+="\tCMP R3,R4\t//On regarde si R3 est egal à 0\n";
		codeAssembleur+="\tBEQ 10\t//Si oui on a tout affiche\n";
		codeAssembleur+="\tLDW R0, SP\t//On met l'adresse de SP dans R0\n";
		codeAssembleur+="\tTRP WR\n"; // lance la trappe WRITE
		codeAssembleur+="\tADQ 2, SP\t//On decremente SP\n";
		codeAssembleur+="\tADQ -1, R3\t//On decremente R3\n";
		codeAssembleur+="\tJEA @affichage\t//On repete l'operation\n";
		
		return codeAssembleur;
	}

	
}

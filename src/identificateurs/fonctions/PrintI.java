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
		codeAssembleur+="\tLDW R2, (WR)\t//On met le parametre dans R2\n";
		codeAssembleur+="\tLDQ WRITE_EXC, WR\n"; // charge n° de trappe WRITE dans registre WR
		codeAssembleur+="\tLDW R1, #10\t//On met 10 dans R1 (servira pour les division)\n";
		codeAssembleur+="\tLDW R3, #0\t//On met R3 a 0\n";
		codeAssembleur+="\tLDW R4, #0\t//On met R4 a 0\n";
		codeAssembleur+="\tLDW R5, #256\t//On met R5 a 256\n";
		codeAssembleur+="\tLDW R6, #2\n";
		codeAssembleur+="\tLDW R8, HP\t//On sauvegarde le pointeur de tas\n";
		codeAssembleur+="\tLDW R9, SP\t//On sauvegarde le pointeur de tas\n";
		codeAssembleur+="division\n";
		codeAssembleur+="\tADQ 1, R3\t//On incremente R3\n";	
		codeAssembleur+="\tCMP R2, R1\t//On verifie si R2 est superieur a R1\n";
		codeAssembleur+="\tJLW #operation-$-2\t//Si oui on passe a l'affichage\n";
		codeAssembleur+="\tDIV R2, R1, R0\t//On divise R0 par 10, resultat dans R0 et reste dans R2\n";
		codeAssembleur+="\tDIV R3, R6, R3\t//On test la parite du compteur\n";
		codeAssembleur+="\tCMP R3, R4\n";
		codeAssembleur+="\tBEQ 6\n";
		codeAssembleur+="\tADQ 48, R2\t//on convertit en ASCII\n";
		codeAssembleur+="\tLDW R7, R2\n";
		codeAssembleur+="\tBMP 8\n";
		codeAssembleur+="\tADQ 48, R2\t//on convertit en ASCII\n";
		codeAssembleur+="\tMUL R2, R5, R2\t//On decale de 8 bits\n";
		codeAssembleur+="\tADC R2, R7, R2\n";
		codeAssembleur+="\tSTW R2, -(SP)\t//On empile le reste\n";
		codeAssembleur+="\tLDW R2,R0\t//On met le resultat dans R2\n";
		codeAssembleur+="\tJEA @division\t//On repete l'operation\n";
		codeAssembleur+="operation\n";
		codeAssembleur+="\tDIV R3, R6, R3\t//On test la parite du compteur\n";
		codeAssembleur+="\tCMP R3, R4\n";
		codeAssembleur+="\tBEQ 6\n";
		codeAssembleur+="\tADQ 48, R2\t//on convertit en ASCII\n";
		codeAssembleur+="\tSTW R2, -(SP)\t//On empile le reste\n";
		codeAssembleur+="\tBMP 8\n";
		codeAssembleur+="\tADQ 48, R2\t//on convertit en ASCII\n";
		codeAssembleur+="\tMUL R2, R5, R2\t//On decale de 8 bits\n";
		codeAssembleur+="\tADC R2, R7, R2\n";
		codeAssembleur+="\tSTW R2, -(SP)\t//On empile le reste\n";
		/*
		codeAssembleur+="\tADQ 48, R2\t//On convertit en ASCII\n";	
		codeAssembleur+="\tMUL R2, R5, R2\t//On decale de 8 bits\n";
		codeAssembleur+="\tSTW R2, -(SP)\t//On empile le reste\n";*/
		codeAssembleur+="affichage\n";
		/*
		codeAssembleur+="\tCMP R3,R4\t//On regarde si R3 est egal à 0\n";
		codeAssembleur+="\tBEQ 10\t//Si oui on a tout affiche\n";
		codeAssembleur+="\tLDW R0, SP\t//On met l'adresse de SP dans R0\n";
		codeAssembleur+="\tTRP WR\n"; // lance la trappe WRITE
		codeAssembleur+="\tADQ 2, SP\t//On decremente SP\n";
		codeAssembleur+="\tADQ -1, R3\t//On decremente R3\n";*/
		codeAssembleur+="\tSUB R9, SP, R2\n";
		codeAssembleur+="\tCMP R2, R4\n";
		codeAssembleur+="\tBEQ 8\n";
		codeAssembleur+="\tLDW R0, (SP)+\n";
		codeAssembleur+="\tSTW R0, (HP)+\n";
		codeAssembleur+="\tJEA @affichage\t//On repete l'operation\n";
		codeAssembleur+="\tSTW R4, (HP)\t//On met le mot null\n";
		codeAssembleur+="\tLDW R0, R8\n";
		codeAssembleur+="\tADC R0, R3, R0\n";
		codeAssembleur+="\tTRP WR\n"; // lance la trappe WRITE
		codeAssembleur+="\tLDW HP, R8\n";
		
		return codeAssembleur;
	}

	
}

package identificateurs.fonctions;

import identificateurs.TypePrimitif;

public class Read extends FonctionBase{
	public Read() {
		super("read", TypePrimitif.INT);
	}

	@Override
	protected String codeAssembleurFonction() {
		String codeAssembleur="";
		codeAssembleur+="\tLDW R0, HP\t//On met l'adresse du tas dans R0\n";
		codeAssembleur+="\tLDW R9, HP\t//On sauvegarde l'adresse du tas\n";
		codeAssembleur+="\tLDW R2, #0\t//Compteur de chiffre\n";
		codeAssembleur+="\tLDW R3, #65280\t//Mask pour le AND, recupere les octets 3 et 4\n";
		codeAssembleur+="\tLDW R4, #255\t//Mask pour le AND, recupere les octets 1 et 2\n";
		codeAssembleur+="\tLDW R5, #0\n";
		codeAssembleur+="\tLDW R6, #2\n";
		codeAssembleur+="\tLDQ READ_EXC, WR\n"; // charge n° de trappe READ dans registre WR
		codeAssembleur+="\tTRP WR\n"; // lance la trappe READ 
		codeAssembleur+="empilement\n";
		codeAssembleur+="\tLDW R0, (HP)\t//On charge R0 avec le mot\n";
		codeAssembleur+="\tLDW R1, R0\t//On charge R1 avec le mot\n";
		codeAssembleur+="\tAND R0, R3, R0\t//On applique le premier masque\n";
		codeAssembleur+="\tDIV R0, R4, R7\t//On divise par 255 pour etre sur les deux premiers octets\n";
		codeAssembleur+="\tCMP R0, R5\t//On test si on a null\n";
		codeAssembleur+="\tBEQ 22\t//Si oui on s'arrete\n";
		codeAssembleur+="\tADQ -48, R0\t//On decode l'ASCII\n";	
		codeAssembleur+="\tSTW R0, -(SP)\t//On empile le chiffre\n";
		codeAssembleur+="\tADQ 1, R2\t//On incremente le compteur\n";
		codeAssembleur+="\tAND R1, R4, R1\t//On applique le second masque\n";
		codeAssembleur+="\tCMP R1, R5\t//On test si on a null\n";
		codeAssembleur+="\tBEQ 10\t//Si oui on s'arrete\n";
		codeAssembleur+="\tADQ -48, R1\t//On decode l'ASCII\n";	
		codeAssembleur+="\tSTW R1, -(SP)\t//On empile le chiffre\n";
		codeAssembleur+="\tADQ 1, R2\t//On incremente le compteur\n";
		codeAssembleur+="\tADQ 2, HP\t//On incremente HP\n";
		codeAssembleur+="\tJEA @empilement\n";
		codeAssembleur+="\tLDW R3, #0\t//Compteur depillement\n";
		codeAssembleur+="\tLDW R4, #10\t//Facteur multiplicatif\n";
		codeAssembleur+="\tLDW R0, (SP)+\t//On depile le premier chiffre\n";
		codeAssembleur+="depilement\n";
		codeAssembleur+="\tLDW R5, #0\n";
		codeAssembleur+="\tLDW R6, #1\n";
		codeAssembleur+="\tADQ 1, R3\t//On incremente R3\n";
		codeAssembleur+="\tCMP R3, R2\n";
		codeAssembleur+="\tBGE 16\n";
		codeAssembleur+="\tLDW R1, (SP)+\t//On depile\n";
		codeAssembleur+="\tMUL R6, R4, R6\n";
		codeAssembleur+="\tADQ 1, R5\n";
		codeAssembleur+="\tCMP R5, R3\n";
		codeAssembleur+="\tBLW -8\n";
		codeAssembleur+="\tMUL R1, R6, R1\n";
		codeAssembleur+="\tADC R1, R0, R0\n";
		codeAssembleur+="\tJEA @depilement\n";
		codeAssembleur+="\tLDW HP, R9\t//On restaure le tas\n";
		return codeAssembleur;
	}

}

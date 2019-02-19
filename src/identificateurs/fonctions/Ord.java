package identificateurs.fonctions;

import identificateurs.TypePrimitif;

public class Ord extends Fonction {

	public Ord() {
		super("ord", TypePrimitif.INT, null);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String codeAssembleurFonction() {
		// TODO On récupère le code ASCII du premier caractère si la chaine n'est pas vide, -1 sinon
		return "";
	}
	
	

}

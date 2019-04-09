package identificateurs.fonctions;

import identificateurs.Type;
import tableSymbole.TableSymbolesAbs;

/**
 * Représente une fonction définie dans le code (à distinguer des fonctions de base)
 *
 */
public class FonctionDefinie extends Fonction {

	
	public FonctionDefinie(String name, Type retour, TableSymbolesAbs tds) {
		super(name, retour, tds);
	}

	@Override
	protected String codeAssembleurFonction() {
		// TODO Auto-generated method stub
		return null;
	}

}

package identificateurs.fonctions;

import identificateurs.Type;
import tableSymbole.TableSymbolesAbs;

/**
 * Représente une fonction définie dans le code (à distringuer des fonctions de base)
 *
 */
public class FonctionDefinie extends Fonction {

	
	public FonctionDefinie(String name, Type retour, TableSymbolesAbs tds) {
		super(name, retour, tds);
	}

	@Override
	protected String codeAssembleurFonction() {
		//TODO
		return getTdsFonction().genererCode();
	}

}

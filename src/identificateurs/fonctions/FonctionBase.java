package identificateurs.fonctions;

import identificateurs.Type;
import tableSymbole.TableSymboles;
import tableSymbole.TableSymbolesAbs;

public class FonctionBase extends Fonction {

	public FonctionBase(String name, Type retour) {
		super(name, retour, new TableSymboles());
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String codeAssembleurFonction() {
		// TODO Auto-generated method stub
		return null;
	}

}

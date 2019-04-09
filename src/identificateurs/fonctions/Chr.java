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
		return "";
	}
	
	
	
	
	
	

}

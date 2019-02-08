package identificateurs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Type extends Identificateur{
	
	//private List<Type> composants;

	public Type(String nom) {
		super(nom);
		//composants = new ArrayList();
	}
	
	/*public Type(String nom, List<Type> comp) {
		super(nom);
		composants = new ArrayList(comp);
	}

	@Override
	public Iterator<Type> iterator() {
		// TODO Auto-generated method stub
		return composants.iterator();
	}*/
	
	
}

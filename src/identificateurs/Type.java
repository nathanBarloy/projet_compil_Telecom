package identificateurs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Type extends Identificateur{
	
	private int taille; // taille en octet du type dans la pile

	public Type(String nom) {
		super(nom);
	}
	
	
}

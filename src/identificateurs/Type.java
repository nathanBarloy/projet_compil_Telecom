package identificateurs;


public abstract class Type extends Identificateur{

	public Type(String nom) {
		super(nom);
	}

	@Override
	public String toString() {
		return "Type '"+nom+"' [taille : " + getTaille() + " octets]";
	}

	public abstract int getTaille();
	
	
	
	
}

package identificateurs;


public abstract class Type extends Identificateur{
	
	protected int taille; // taille en octet du type dans la pile

	public Type(String nom) {
		super(nom);
	}

	@Override
	public String toString() {
		return "Type '"+nom+"' [taille : " + taille + " octets]";
	}
	
	
	
	
}

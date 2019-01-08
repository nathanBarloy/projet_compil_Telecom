package identificateurs;

/*
 * Tiger has four kinds of identifiers: types, functions, variables, and fields.
 */
public abstract class Identificateur {
	protected String nom;

	public Identificateur(String nom) {
		this.nom = nom;
	}
	
	
}

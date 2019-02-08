package identificateurs;

public class Variable extends Identificateur{
	private Type type; // type de la variable
	private int deplacement; // déplacement dans la mémoire

	public Variable(String name, Type type) {
		super(name);
		this.type = type;
		//this.deplacement = deplacement; 
		//caluler le déplacement à partir du déplacement de la variable précédente, et de la taille du type
	}

	
	
	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		String res = "";
		res = nom + " : " + type;

		return res;
	}

}

package identificateurs;

public class Variable extends Identificateur{
	private Type type; // type de la variable
	private int deplacement; // déplacement dans la mémoire

	public Variable(String name, Type type, int deplacement) {
		super(name);
		this.type = type;
		this.deplacement = deplacement;
	}

	public Variable(String name, Type type) {
		this(name,type,0);
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


public class Variable {
	private String name; //nom de la variable
	private String type; // type de la variable
	private int deplacement; // déplacement dans la mémoire

	public Variable(String name, String type, int deplacement) {
		super();
		this.name = name;
		this.type = type;
		this.deplacement = deplacement;
	}

	public Variable(String name, String type) {
		this(name,type,0);
	}
	
	@Override
	public String toString() {
		String res = "";
		res = name + " : " + type;

		return res;
	}

}


public class Variable {
	private String name;
	private String type;
	private int deplacement;
	public Variable(String name, String type, int deplacement) {
		super();
		this.name = name;
		this.type = type;
		this.deplacement = deplacement;
	}
	
	public Variable(String name, String type) {
		this(name,type,0);
	}
	
}

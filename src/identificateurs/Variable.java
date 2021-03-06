package identificateurs;

public class Variable extends Identificateur{
	protected Type type; // type de la variable
	protected int deplacement; // déplacement dans la mémoire

	public Variable(String name, Type type,int deplacement) {
		super(name);
		this.type = type;
		this.deplacement = deplacement; 
		//TODO caluler le déplacement à partir du déplacement de la variable précédente, et de la taille du type
	}

	
	
	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Variable '"+nom+"' [type '" + type.getName() + "', déplacement : " + deplacement + "]";
	}



	public int getDeplacement() {
		return deplacement;
	}



	public void setDeplacement(int deplacement) {
		this.deplacement = deplacement;
	}
	
	
	
		

}

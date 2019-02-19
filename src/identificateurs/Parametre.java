package identificateurs;

public class Parametre extends Identificateur{
	private Type type; // type du parametre
	private int deplacement; // déplacement dans la mémoire

	public Parametre(String name, Type type,int deplacement) {
		super(name);
		this.type = type;
		this.deplacement = deplacement; 
		//TODO caluler le déplacement à partir du déplacement negatif du parametre précédent, et de la taille du type
	}



	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Parametre '"+nom+"' [type '" + type.getName() + "', déplacement : " + deplacement + "]";
	}



	public int getDeplacement() {
		return deplacement;
	}



}


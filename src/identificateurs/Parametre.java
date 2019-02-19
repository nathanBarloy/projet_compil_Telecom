package identificateurs;

public class Parametre extends Variable{

	public Parametre(String name, Type type,int deplacement) {
		super(name,type,deplacement);
		
		//TODO caluler le déplacement à partir du déplacement negatif du parametre précédent, et de la taille du type
	}


	@Override
	public String toString() {
		return "Parametre '"+nom+"' [type '" + type.getName() + "', déplacement : " + deplacement + "]";
	}




}


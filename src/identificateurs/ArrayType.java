package identificateurs;

public class ArrayType extends Type {
	private Type sousType;
	private String nomSousType;

	public ArrayType(String nom, Type type) {
		super(nom);
		sousType = type;
		nomSousType = "";
	}
	
	public ArrayType(String nom, Type type, String nomSsType) {
		this(nom, type);
		nomSousType = nomSsType;
	}
	
	public Type getSousType() {
		return sousType;
	}
	
	public void setSousType(Type t) {
		sousType = t;
	}

	public String getNomSousType() {
		return nomSousType;
	}

	public void setNomSousType(String nomSousType) {
		this.nomSousType = nomSousType;
	}

	@Override
	public int getTaille() {
		return sousType.getTaille();
	}
	

}

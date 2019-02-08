package identificateurs;

public class ArrayType extends Type {
	private Type sousType;

	public ArrayType(String nom, Type type) {
		super(nom);
		sousType = type;
	}
	
	public Type getSousType() {
		return sousType;
	}

}

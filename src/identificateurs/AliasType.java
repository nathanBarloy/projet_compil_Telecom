package identificateurs;

public class AliasType extends Type {

	private Type aliasedType;
	
	public AliasType(String nom, Type type) {
		super(nom);
		aliasedType = type;
	}
	
	public Type getType() {
		return aliasedType;
	}

}

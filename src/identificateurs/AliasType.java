package identificateurs;

public class AliasType extends Type {

	private Type aliasedType;
	private String nomAliasedType;
	
	public AliasType(String nom, Type type) {
		super(nom);
		aliasedType = type;
	}
	
	public AliasType(String nom, Type type, String nomAlType) {
		super(nom);
		aliasedType = type;
		nomAliasedType = nomAlType;
	}
	
	public Type getType() {
		return aliasedType;
	}
	
	public void setType(Type type) {
		aliasedType = type;
	}

	public String getNomAliasedType() {
		return nomAliasedType;
	}

	public void setNomAliasedType(String nomAliasedType) {
		this.nomAliasedType = nomAliasedType;
	}

	@Override
	public int getTaille() {
		return aliasedType.getTaille();
	}

}

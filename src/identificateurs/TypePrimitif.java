package identificateurs;

public class TypePrimitif extends Type {
	
	public final static TypePrimitif INT = new TypePrimitif("int",2);// un entier est stocké sur 32 bits
	public final static TypePrimitif STRING = new TypePrimitif("string", 2);//on stocke juste l'adresse du premier caractère
	public final static TypePrimitif VOID = new TypePrimitif("void",0);//
	
	protected int taille; // taille en octet du type dans la pile

	public TypePrimitif(String nom,int taille) {
		super(nom);
		this.taille = taille;
	}

	@Override
	public int getTaille() {
		return taille;
	}

	
}

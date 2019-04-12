package tableSymbole;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Set;

import org.antlr.runtime.tree.Tree;

import identificateurs.AliasType;
import identificateurs.ArrayType;
import identificateurs.Identificateur;
import identificateurs.Parametre;
import identificateurs.Type;
import identificateurs.TypePrimitif;
import identificateurs.Variable;
import identificateurs.fonctions.Fonction;
import identificateurs.RecordType;

public abstract class TableSymbolesAbs {

	protected TableSymbolesAbs parent; // TDS parent
	protected ArrayList<TableSymbolesAbs> fils; //liste des TDS fils
	protected HashMap<String,Identificateur> identificateurs;
	protected int niveau ; //niveau d'imbrication
	private int compteurTDS; // Permet de savoir a quelle TDS fille de la hashmap on est
	
	/**
	 * Nombre de TDS généré jusqu'a présent
	 */
	private static int nbTDS = 0;
	/**
	 * Stocke le numéro de la TDS afin de s'assurer de disposer d'un numéro unique lors de la génération de code
	 */
	private int numeroTDS = nbTDS;

	public TableSymbolesAbs(TableSymbolesAbs parent) {
		this();
		this.parent = parent;
		this.compteurTDS = 0;
		niveau = parent.getNiveau()+1;
	}


	public TableSymbolesAbs() { // table des symboles sans pere
		nbTDS++;
		this.parent = null;
		this.compteurTDS = 0;
		niveau = 0;

		fils = new ArrayList<TableSymbolesAbs>();
		identificateurs=new HashMap<>();
	}

	public void ajouterTypePrimitif(TypePrimitif type)
	{
		if(getType(type.getName())==null)
		{
			ajouterIdentificateur(type);
		}
		else
		{
			System.err.println("Tentative de déclaration d'un type existant : "+type.getName());
		}
	}

	

	public void ajouterIdentificateur(Identificateur identificateur)
	{
			identificateurs.put(identificateur.getName(),identificateur);
	}

	public boolean containsIdentificateur(String identificateur)
	{
		return identificateurs.containsKey(identificateur);
	}
	
	public TableSymbolesAbs getTDSFonction(Fonction f) {
		return f.getTdsFonction();
	}

	/**
	 * Cette méthode retourne le type s'il existe dans cette tds ou dans les parents, null sinon
	 * @param type : identificateur en chaine de caractère du type
	 * @return objet Type déjà défini
	 */
	public Type getType(String type)
	{
		Type res;
		Identificateur resInt = identificateurs.get(type);
		if (!(resInt instanceof Type)) {
			res = null;
		} else {
			res = (Type) resInt;
		}

		if(res == null && parent != null) {
			res = parent.getType(type);
		}
		return res;
	}

	public Type getRecordType(String rec) {
		Type res;
		Identificateur temp = identificateurs.get(rec);
		if(!(temp instanceof RecordType)) {
			res = null;
		}
		else {
			res = (RecordType) temp;
		}

		if (res == null && parent !=null) {
			res = parent.getRecordType(rec);
		}

		return res;
	}

	public Type getArrayType(String rec) {
		Type res;
		Identificateur temp = identificateurs.get(rec);
		if(!(temp instanceof ArrayType)) {
			res = null;
		}
		else {
			res = (ArrayType) temp;
		}

		if (res == null && parent !=null) {
			res = parent.getArrayType(rec);
		}

		return res;
	}


	/**
	 * Cette méthode retourne le type de la variable dont le nom est passé en paramètre
	 * @param variable nom de la variable dont on cherche le type
	 * @return Objet Type qui représente le type de la variable
	 */
	public Type getVariableType(String variable)
	{
		Variable tmp = ((Variable)get(variable));
		if(tmp!=null)
		{
			return tmp.getType();
		}
		else if (parent != null)
		{
			return parent.getVariableType(variable);
		}
		else {
			return null;
		}

	}

	public Type getFunctionType(String function)
	{
		/*Type res = ((Fonction)identificateurs.get(function)).getTypeRetour();
		if(res == null && parent != null) {
			res = parent.getFunctionType(function);
		}
		return res;*/
		Fonction tmp = ((Fonction)get(function));
		if(tmp!=null)
		{
			return tmp.getTypeRetour();
		}
		else
		{
			return null;
		}
	}

	public Identificateur get(String name) { // renvoie l'identificateuérifier que le fils gauche d'IDBEG est une fonctionr de nom name
		Identificateur res = (Identificateur)(identificateurs.get(name));
		if(res == null && parent != null) {
			res = parent.get(name);
		}
		return res;
	}
	
	/**
	 * retourne le niveau d'imbrication de la TDS ou v est déclarée
	 * @param v varible dont on veut récupérer le niveau d'imbrication
	 * @return niveau d'imbrication
	 */
	public int getNiveauDeclaration(Variable v)
	{
		if(this.identificateurs.containsKey(v.getName()))
		{
			return this.niveau;
		}
		else if(parent != null) {
			return parent.getNiveauDeclaration(v);
		}
		else
		{
			return -1;
		}
	}

	public void addFils(TableSymbolesAbs fils){ // ajoute une tds fils
		this.fils.add(fils);
	}

	public TableSymbolesAbs getFils(int i){ // récupère le ième fils tds
		return fils.get(i);
	}

	public ArrayList<TableSymbolesAbs> getFils() {
		return fils;
	}

	public int getNiveau() {
		return niveau;
	}

	public TableSymbolesAbs getParent() {
		return parent;
	}

	@Override
	public String toString() {
		String s = "";
		s+="Table des symboles (Imbrication "+niveau+") { \n";
		for(int j=0;j<niveau+1;j++)
		{
			s+="\t";
		};
		s+="Identificateurs : [";
		Iterator<Identificateur> iterateur = identificateurs.values().iterator();
		if(iterateur.hasNext())//s'il y a au moins un identificateur
		{
			s+='\n';
			while (iterateur.hasNext())
			{
				for(int j=0;j<=niveau+2;j++)
				{
					s+="\t";
				}
				s += iterateur.next().toString();
				if(iterateur.hasNext())
				{
					s += ",\n";
				}
				else
				{
					s += '\n';
				}
			}
			for(int j=0;j<=niveau;j++)
			{
				s+="\t";
			}
		}
		s+="]";
		if(fils.size()>0)
		{
			s+=',';
		}
		s+='\n';
		for (int i=0;i<fils.size();i++)
		{
			for(int j=0;j<=niveau;j++)
			{
				s+="\t";
			}
			s+= "Fils "+(i+1)+ " : "+fils.get(i).toString();
		}
		for(int j=0;j<niveau;j++)
		{
			s+="\t";
		}
		s+="}\n";
		return s;
	}
	/**
	 * Cette fonction permet de savoir si on est dans un bloc dans lequel on peut utiliser break
	 * @return true si on est dans un bloc dans lequel on peut utiliser break, false sinon
	 */
	public abstract boolean isBreakable();
	
	/**
	 * Cette méthode calcule le déplacement nécessaire avant d'ajouter une variable dans la TDS
	 * @return un entier décrivant le déplacement en octet depuis la base 
	 */
	public int calculerDeplacementVariable()
	{
		//TODO
		int deplacement=0;
		for(Identificateur identificateur:identificateurs.values())
		{
			if(identificateur instanceof Variable && !(identificateur instanceof Parametre))//TODO voir pour remédier à l'usage d'instance of
			{
				deplacement+=((Variable) identificateur).getType().getTaille();
			}
		}
		return deplacement;
	}
	
	public int calculerDeplacementParametre(Type t)
	{
		int deplacement=-t.getTaille();
		for(Identificateur identificateur:identificateurs.values())
		{
			if(identificateur instanceof Parametre)
			{
				Parametre p = ((Parametre) identificateur);
				p.setDeplacement(p.getDeplacement()-t.getTaille());//SALE
			}
		}
		return deplacement;
	}
	
	public String debutBloc()
	{
		return nomBloc()+numeroTDS;
	}
	public String finBloc()
	{
		return "fin"+nomBloc()+numeroTDS;
	}
	public void incCompteurTDS()
	{
		this.compteurTDS += 1;
	}
	
	public int getCompteurTDS()
	{
		return this.compteurTDS;
	}
	
	protected abstract String nomBloc();
}

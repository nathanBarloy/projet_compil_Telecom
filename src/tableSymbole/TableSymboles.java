package tableSymbole;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;

import org.antlr.runtime.tree.Tree;

import identificateurs.AliasType;
import identificateurs.ArrayType;
import identificateurs.Fonction;
import identificateurs.Identificateur;
import identificateurs.Type;
import identificateurs.TypePrimitif;
import identificateurs.Variable;

public class TableSymboles {

	private TableSymboles parent; // TDS parent
	private ArrayList<TableSymboles> fils; //liste des TDS fils
	//private HashMap<String,Variable> variableMap; // stocke les entrés dans la table
	//private HashMap<Fonction,TableSymboles> fonctionMap;	// stocke les fonctions et leur tds associee
	private HashMap<String,Identificateur> identificateurs;
	private int niveau ; //niveau d'imbrication

	public TableSymboles(TableSymboles parent) {
		this.parent = parent;
		niveau = parent.getNiveau()+1;

		fils = new ArrayList<TableSymboles>();
		identificateurs=new HashMap<>();
		
		/*variableMap = new HashMap<String, Variable>();
    	fonctionMap = new HashMap<Fonction, TableSymboles>();*/
	}

	public TableSymboles() { // table des symboles sans pere
		this.parent = null;
		niveau = 0;

		fils = new ArrayList<TableSymboles>();
		identificateurs=new HashMap<>();
	}

	public void ajouterTypePrimitif(String name)
	{
		if(getType(name)==null)
		{
			ajouterIdentificateur(name, new TypePrimitif(name));
		}
		else
		{
			System.err.println("Tentative de déclaration d'un type existant : "+name);
		}
	}
	
	public void ajouterTypeAlias(String name, String aliasedType)
	{
		if(getType(name)==null && getType(aliasedType)!=null)
		{
			ajouterIdentificateur(name, new AliasType(name,getType(aliasedType)));
		}
		else
		{
			System.err.println("Tentative de déclaration d'un type existant : "+name);
		}
	}
	
	public void ajouterTypeArray(String name, String sousType)
	{
		if(getType(name)==null && getType(sousType)!=null)
		{
			ajouterIdentificateur(name, new ArrayType(name,getType(sousType)));
		}
		else
		{
			System.err.println("Tentative de déclaration d'un type existant : "+name);
		}
	}
	
	public void ajouterFonction(String name, String retour, TableSymboles tds) {
		//fonctionMap.put(new Fonction(name,retour),tds);
		Type t=getType(retour);
		if(t!=null)
		{
			ajouterIdentificateur(name,new Fonction(name, t,tds));
		}
		else
		{
			System.err.println("Type de retour non défini '"+retour+"' lors de la déclaration de la fonction "+name);
		}
	}

	private void ajouterIdentificateur(String name,Identificateur identificateur)
	{
		if(!identificateurs.containsKey(name))
		{
			System.out.println("Ajout de l'identificateur : "+name);
			identificateurs.put(name,identificateur);
		}
		else
		{
			System.err.println("Identificateur déjà présent : "+name);
		}

	}

	public TableSymboles getTDSFonction(Fonction f) {
		return f.getTdsFonction();
	}

	public void ajouterVariable(String name, String type) { // nouvelle variable
		Type t=getType(type);
		if(t!=null)
		{
			if(!identificateurs.containsKey(name))
			{
				ajouterIdentificateur(name, new Variable(name, t));
			}
			else
			{
				System.err.println("Identificateur déjà utilisé : "+name);
			}
		}
		else
		{
			System.err.println("Type non défini '"+type+"' lors de la déclaration de la variable "+name);
		}
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
	
	/**
	 * Cette méthode retourne le type de la variable dont le nom est passé en paramètre
	 * @param variable nom de la variable dont on cherche le type
	 * @return Objet Type qui représente le type de la variable
	 */
	public Type getVariableType(String variable)
	{
		Type res = ((Variable)identificateurs.get(variable)).getType();
		if(res == null && parent != null) {
			res = parent.getVariableType(variable);
		}
		return res;
	}
	public Identificateur get(String name) { // renvoie l'identificateur de nom name
		Identificateur res = (Identificateur)(identificateurs.get(name));
		if(res == null && parent != null) {
			res = parent.get(name);
		}
		return res;
	}

	public void addFils(TableSymboles fils){ // ajoute une tds fils
		this.fils.add(fils);
	}

	public TableSymboles getFils(int i){ // récupère le ième fils tds
		return fils.get(i);
	}
	
	public ArrayList<TableSymboles> getFils() {
		return fils;
	}
	
	public int getNiveau() {
		return niveau;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("Table des symboles : [");
		for (Identificateur id : identificateurs.values()) {
			s.append("Identificateur : "+id.getName()+",");
		}
		s.append("]");
		return s.toString();
	}

	/*@Override
  public String toString(){
    StringBuilder s =new StringBuilder();
    Set<String> cles = variableMap.keySet();
    for(String string : cles){
      s.append("\n" + string+ ":" +variableMap.get(string));
    }
    return s.toString();
  }*/
}

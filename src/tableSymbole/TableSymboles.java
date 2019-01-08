package tableSymbole;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;

import org.antlr.runtime.tree.Tree;

import identificateurs.Fonction;
import identificateurs.Identificateur;
import identificateurs.Type;
import identificateurs.Variable;

public class TableSymboles {

	private TableSymboles parent; // TDS parent
	private ArrayList<TableSymboles> fils; //liste des TDS fils
	//private HashMap<String,Variable> variableMap; // stocke les entrés dans la table
	//private HashMap<Fonction,TableSymboles> fonctionMap;	// stocke les fonctions et leur tds associee
	private HashMap<String,Identificateur> identificateurs;

	public TableSymboles(TableSymboles parent) {
		this.parent = parent;

		fils = new ArrayList<TableSymboles>();
		identificateurs=new HashMap<>();
		/*variableMap = new HashMap<String, Variable>();
    fonctionMap = new HashMap<Fonction, TableSymboles>();*/
	}

	public TableSymboles() { // table des symboles sans pere
		this(null);
	}

	public void ajouterFonction(String name, String retour, TableSymboles tds) {
		//fonctionMap.put(new Fonction(name,retour),tds);
		//TODO on récupère le type dans la TDS (s'il n'existe pas dans cette tds ou une tds parent, alors il y'a une erreur)
		ajouterIdentificateur(name,new Fonction(name, new Type(retour),tds));
	}

	private void ajouterIdentificateur(String name,Identificateur identificateur)
	{
		if(!identificateurs.containsKey(name))
		{
			identificateurs.put(name,identificateur);
		}
		else
		{
			System.err.println("Identificateur déjà présent");
		}

	}

	public TableSymboles getTDSFonction(Fonction f) {
		return f.getTdsFonction();
	}

	public void ajouterVariable(String name, String type) { // nouvelle variable
		//variableMap.put(name, new Variable(name,type));
		//TODO on récupère le type dans la TDS (s'il n'existe pas dans cette tds ou une tds parent, alors il y'a une erreur)
		ajouterIdentificateur(name, new Variable(name, new Type(type)));
	}

	public Variable regarderNoeudSup(String name) { // renvoie type de name (regarde les pères)
		Variable res = (Variable)(identificateurs.get(name));
		if(res == null && parent != null) {
			res = parent.regarderNoeudSup(name);
		}
		return res;
	}

	public void addFils(TableSymboles fils){ // ajoute une tds fils
		this.fils.add(fils);
	}

	public TableSymboles getFils(int i){ // récupère le ième fils tds
		return fils.get(i);
	}

	@Override
	public String toString() {
		return "TableSymboles [identificateurs=" + identificateurs + "]";
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

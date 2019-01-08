import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;

import org.antlr.runtime.tree.Tree;

public class TableSymboles {

  private TableSymboles parent; // TDS parent
  private ArrayList<TableSymboles> fils; //liste des TDS fils
  private HashMap<String,Variable> variableMap; // stocke les entrés dans la table
  private HashMap<Fonction,TableSymboles> fonctionMap;	// stocke les fonctions et leur tds associee

  public TableSymboles(TableSymboles parent) {
    this.parent = parent;
    variableMap = new HashMap<String, Variable>();
    fils = new ArrayList<TableSymboles>();
    fonctionMap = new HashMap<Fonction, TableSymboles>();
  }

  public TableSymboles() { // table des symboles sans pere
	  this(null);
  }

  public void ajouterFonction(String name, String retour, TableSymboles tds) {
	  fonctionMap.put(new Fonction(name,retour),tds);
  }

  public TableSymboles getTDSFonction(Fonction f) {
	  return fonctionMap.get(f);
  }

  public void ajouterSymbole(String name, String type) { // nouvelle variable
    variableMap.put(name, new Variable(name,type));
  }

  public Variable regarderNoeudSup(String name) { // renvoie type de name (regarde les pères)
    Variable res = variableMap.get(name);
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
  public String toString(){
    StringBuilder s =new StringBuilder();
    Set<String> cles = variableMap.keySet();
    for(String string : cles){
      s.append("\n" + string+ ":" +variableMap.get(string));
    }
    return s.toString();
  }


}

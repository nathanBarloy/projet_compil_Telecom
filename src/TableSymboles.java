import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;

import org.antlr.runtime.tree.Tree;

public class TableSymboles {
	
  private TableSymboles parent; // TDS parent
  private ArrayList<TableSymboles> fils; //liste des TDS fils
  private HashMap<String,String> map; // stocke les entrés dans la table

  public TableSymboles(TableSymboles parent) {
    this.parent = parent;
    map = new HashMap<String, String>();
    fils = new ArrayList<TableSymboles>();
  }
  
  public TableSymboles() { // table des symboles sans pere
	  this(null);
  }

  public void ajouterSymbole(String name, String type) { // nouvelle variable
    map.put(name, type);
  }

  public String regarderNoeudSup(String name) { // renvoie type de name (regarde les pères)
    String res = map.get(name);
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

  public String toString(){
    StringBuilder s =new StringBuilder();
    Set<String> cles = map.keySet();
    for(String string : cles){
      s.append("\n" + string+ ":" +map.get(string));
    }
    return s.toString();
  }
 

}

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;

import org.antlr.runtime.tree.Tree;

public class TableSymboles {
	
  private TableSymboles parent; // TDS parent
  private ArrayList<TableSymboles> fils; //liste des TDS fils
  private HashMap<String,Variable> map; // stocke les entrées dans la table

  public TableSymboles(TableSymboles parent) {
    this.parent = parent;
    map = new HashMap<String, Variable>();
    fils = new ArrayList<TableSymboles>();
  }
  
  public TableSymboles() { // table des symboles sans pere
	  this(null);
  }

  public void ajouterSymbole(String name, String type) { // nouvelle variable
    map.put(name, new Variable(name,type));
  }

  public Variable regarderNoeudSup(String name) { // renvoie type de name (regarde les pères)
    Variable res = map.get(name);
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
    Set<String> cles = map.keySet();
    for(String string : cles){
      s.append("\n" + map.get(string));
    }
    return s.toString();
  }
 

}

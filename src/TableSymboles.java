import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;

public class TableSymboles {
	
  private TableSymboles parent; // TDS parent
  private ArrayList<TableSymboles> fils; //liste des TDS fils
  private HashMap<String,String> map; // stocke les entrés dans la table

  public TableSymboles(TableSymboles parent) {
    this.parent = parent;
    map = new HashMap<String, String>();
    fils = new ArrayList<TableSymboles>();
  }
  
  public TableSymboles() {
	  this(null);
  }

  public void ajouterSymbole(String name, String type) {
    map.put(name, type);
  }

  public String regarderNoeudSup(String name) {
    String res = map.get(name);
    if(res == null && parent != null) {
      res = parent.regarderNoeudSup(name);
    }
    return res;
  }

  public void addFils(TableSymboles fils){
    this.fils.add(fils);
  }

  public TableSymboles getFils(int i){
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

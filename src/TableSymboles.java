import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;

public class TableSymboles {
  private TableSymboles parent; // TDS parent
  private TableSymboles fils;
  private ArrayList<TableSymboles> freres;
  private HashMap<String,String> map; // stocke les entrés dans la table

  public TableSymboles(TableSymboles parent) {
    this.parent = parent;
    map = new HashMap<String, String>();
    freres = new ArrayList<TableSymboles>();
  }

  public void ajouterSymbole(String name, String info) {
    map.put(name, info);
  }

  public String regarderNoeudSup(String name) {
    String res = map.get(name);
    if(res == null && parent != null) {
      res = parent.regarderNoeudSup(name);
    }
    return res;
  }

  public void addFils(TableSymboles fils){
    this.fils = fils;
  }

  public TableSymboles getFils(){
    return this.fils;
  }

  public void addFrere(TableSymboles frere){
    this.freres.add(frere);
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

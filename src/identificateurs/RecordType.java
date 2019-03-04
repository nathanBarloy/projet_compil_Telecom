package identificateurs;

import java.util.ArrayList;
import java.util.List;

public class RecordType extends Type {
	private List<Variable> listeVar;

	public RecordType(String nom) {
		super(nom);
		listeVar = new ArrayList<Variable>();
	}
	
	public void addComponent(String name, Type type) {
		if (this.existe(name)) {
			System.err.println("l'attribut "+name+" existe deja pour le type "+ this.nom);
		} else {
			listeVar.add(new Variable(name, type,deplacementDerniereVariable()));
		}
	}
	
	public Variable getVariable(String name) {
		for (Variable var:listeVar) {
			if (var.getName().equals(name)) {
				return var;
			}
		}
		return null;
	}
	
	public Variable getVariableFromIndex(int index) {
		Variable var = null;
		if(index < listeVar.size()) {
			var = listeVar.get(index);
		}
		return var;
	}
	
	public boolean existe(String name) {
		for (Variable var:listeVar) {
			if (var.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * calcule le deplacement à appliquer à une variable avant son ajout
	 * @return le déplacement à appliquer à la variable que l'on va ajouter
	 */
	private int deplacementDerniereVariable()
	{
		if(listeVar.size()>0)
		{
			Variable lastVar=listeVar.get(listeVar.size()-1);
			return lastVar.getDeplacement()+lastVar.getType().getTaille();
		}
		else
		{
			return 0;
		}
	}

	@Override
	public int getTaille() {
		int somme=0;
		for(Variable v:listeVar)
		{
			somme += v.getType().getTaille();
		}
		return somme;
	}

	
}

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
			listeVar.add(new Variable(name, type));
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
	
	public boolean existe(String name) {
		for (Variable var:listeVar) {
			if (var.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	
}

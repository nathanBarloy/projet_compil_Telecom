package tableSymbole;

public class TableSymbolesLet extends TableSymbolesAbs {
	public TableSymbolesLet(TableSymbolesAbs parent) {
		super(parent);
	}
	

	public TableSymbolesLet() { // table des symboles sans pere
		super();
	}


	@Override
	public boolean isBreakable() {
		return false;
	}

}

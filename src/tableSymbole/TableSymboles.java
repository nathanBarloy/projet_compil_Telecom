package tableSymbole;


public class TableSymboles extends TableSymbolesAbs{

	public TableSymboles(TableSymbolesAbs parent) {
		super(parent);
	}
	
	public TableSymboles() { // table des symboles sans pere
		super();
	}

	@Override
	public boolean isBreakable() {
		return false;
	}

	@Override
	protected String nomBloc() {
		return "";
	}
	
	
	
}

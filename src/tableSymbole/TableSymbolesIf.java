package tableSymbole;

public class TableSymbolesIf extends TableSymbolesAbs{
	public TableSymbolesIf(TableSymbolesAbs parent) {
		super(parent);
	}
	

	public TableSymbolesIf() { // table des symboles sans pere
		super();
	}


	@Override
	public boolean isBreakable() {
		return false;
	}


	@Override
	protected String nomBloc() {
		// TODO Auto-generated method stub
		return "if";
	}
	
	
}

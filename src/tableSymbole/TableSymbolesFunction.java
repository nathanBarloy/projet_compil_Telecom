package tableSymbole;

public class TableSymbolesFunction extends TableSymbolesAbs{
	public TableSymbolesFunction(TableSymbolesAbs parent) {
		super(parent);
	}
	

	public TableSymbolesFunction() { // table des symboles sans pere
		super();
	}


	@Override
	public boolean isBreakable() {
		return false;
	}


	@Override
	protected String nomBloc() {
		// TODO Auto-generated method stub
		return "";
	}

	
}

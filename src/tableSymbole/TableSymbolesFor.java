package tableSymbole;

public class TableSymbolesFor extends TableSymbolesAbs{
	public TableSymbolesFor(TableSymbolesAbs parent) {
		super(parent);
	}
	

	public TableSymbolesFor() { // table des symboles sans pere
		super();
	}


	@Override
	public boolean isBreakable() {
		return true;
	}

	@Override
	protected String nomBloc() {
		return "for";
	}
	
	
	
}

package tableSymbole;

public class TableSymbolesWhile extends TableSymbolesAbs{
	public TableSymbolesWhile(TableSymbolesAbs parent) {
		super(parent);
	}
	

	public TableSymbolesWhile() { // table des symboles sans pere
		super();
	}


	@Override
	public boolean isBreakable() {
		return true;
	}
	
	
}

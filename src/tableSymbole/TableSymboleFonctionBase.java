package tableSymbole;

public class TableSymboleFonctionBase extends TableSymbolesAbs{

	
	public TableSymboleFonctionBase(int numTDS) {
		super(numTDS);
		niveau++;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isBreakable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected String nomBloc() {
		// TODO Auto-generated method stub
		return null;
	}

}

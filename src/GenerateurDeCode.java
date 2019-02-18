import org.antlr.runtime.tree.CommonTree;

import tableSymbole.TableSymbolesAbs;

public class GenerateurDeCode {
	
	private TableSymbolesAbs tds;
	private CommonTree ast;
	
	public GenerateurDeCode(TableSymbolesAbs tds, CommonTree ast) {
		this.tds = tds;
		this.ast = ast;
	}
	
	public String genererCode()
	{
		//TODO
		return "";
	}

	
	
}

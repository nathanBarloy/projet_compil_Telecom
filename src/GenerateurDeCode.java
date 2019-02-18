import org.antlr.runtime.tree.CommonTree;

import tableSymbole.TableSymbolesAbs;

public class GenerateurDeCode {
	
	private TableSymbolesAbs tds;
	private CommonTree ast;
	
	public GenerateurDeCode(TableSymbolesAbs tds, CommonTree ast) {
		this.tds = tds;
		this.ast = ast;
	}
	
	/**
	 * Génère le code assembleur à l'aide de la TDS et de l'AST
	 * @return chaine de caractère contenant le code assembleur du programme
	 */
	public String genererCode()
	{
		//TODO
		return "";
	}

	
	
}

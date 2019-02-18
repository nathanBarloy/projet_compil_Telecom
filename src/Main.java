import java.io.FileInputStream;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;

import tableSymbole.TableSymbolesAbs;

public class Main {

	public static void main(String[] args) {
		String path = "Tests/testsSyntaxiques/testProf/fonctionnels/prog1.txt";
		//Passe 1 : Analyse lexicale et syntaxique
		CommonTree tree=null;
		try {
			ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
			TigerLexer lexer = new TigerLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			TigerParser parser = new TigerParser(tokens);
			tree = (CommonTree)parser.program().getTree();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//On obtient l'AST
		//Passe 2 : Analyse sémantique
		AnalyseurSemantique as=new AnalyseurSemantique(path,tree);
		TableSymbolesAbs tdsRes=as.analyser();
		System.out.println(tdsRes.toString());
		//On obtient la TDS
		//Passe 3 : Génération de code
		GenerateurDeCode gdc = new GenerateurDeCode(tdsRes, tree);
		
	}

	
}

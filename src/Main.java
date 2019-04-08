import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;

import tableSymbole.TableSymbolesAbs;

public class Main {

	public static void main(String[] args) throws RecognitionException, FileNotFoundException, IOException {
		String path = "Tests/simpleIf.tig";
		//Passe 1 : Analyse lexicale et syntaxique
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		TigerLexer lexer = new TigerLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TigerParser parser = new TigerParser(tokens);
		CommonTree tree = (CommonTree)parser.program().getTree();
		//On obtient l'AST
		//Passe 2 : Analyse sémantique
		AnalyseurSemantique as=new AnalyseurSemantique(path,tree);
		TableSymbolesAbs tdsRes=as.analyser();
		System.out.println(tdsRes.toString());
		//On obtient la TDS
		//Passe 3 : Génération de code
		System.out.println("Code généré :");
		GenerateurDeCode gdc = new GenerateurDeCode(tdsRes, tree);
		String codeAssembleur=gdc.genererCode("assembleur/toto.src");
		System.out.println(codeAssembleur);
	}


}


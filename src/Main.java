import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.DOTTreeGenerator;
import org.antlr.runtime.tree.Tree;
import org.antlr.stringtemplate.StringTemplate;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, IOException, RecognitionException {
	    TableSymboles blocOrig = new TableSymboles(null);
	    
	    ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(args[0]));
        TigerLexer lexer = new TigerLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TigerParser parser = new TigerParser(tokens);
        CommonTree tree=(CommonTree)parser.program().getTree();
        parcoursArbre(tree);
        /*DOTTreeGenerator gen = new DOTTreeGenerator();
        StringTemplate st = gen.toDOT(tree);
        System.out.println(st);*/
	}
	
	public static void parcoursArbre(Tree tree)
	{
		System.out.println(tree.getText());
		for(int i=0;i<tree.getChildCount();i++)
		{
			parcoursArbre(tree.getChild(i));
		}
		
	}
}

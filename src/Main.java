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
	    
	    ANTLRInputStream input = new ANTLRInputStream(new FileInputStream("Tests/testProf/fonctionnels/prog1.txt"));
        TigerLexer lexer = new TigerLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TigerParser parser = new TigerParser(tokens);
        CommonTree tree=(CommonTree)parser.program().getTree();
        parcoursArbre(tree,blocOrig);
        /*DOTTreeGenerator gen = new DOTTreeGenerator();
        StringTemplate st = gen.toDOT(tree);
        System.out.println(st);*/
	}
	
	public static void parcoursArbre(Tree tree,TableSymboles tableParent)
	{
		System.out.println(tree.getText());
		for(int i=0;i<tree.getChildCount();i++)
		{
			switch(tree.getText())
			{
			//case "ROOT":
			case "FUNDEC":
			case "LET":
			case "WHILE":
			case "FOR":
				//dans les cas précédent, il faut créer une nouvelle table des symboles qui devient
				TableSymboles nouvelle=new TableSymboles(tableParent);
				parcoursArbre(tree.getChild(i),nouvelle);
				break;
			default:
				parcoursArbre(tree.getChild(i),tableParent);//si on est pas dans les cas précédents,on crée une nouvelle table 
				break;
			}
			
		}
		
	}
}

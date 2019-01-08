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
		TableSymboles nouvelle;
		System.out.println(tree.getText());
		for(int i=0;i<tree.getChildCount();i++)
		{
			switch(tree.getText())
			{
			//case "ROOT":
			//cas creant un nouveau bloc
			case "FUNDEC":
				nouvelle = new TableSymboles(tableParent);
				String nom = tree.getChild(i).getChild(0).getText();
				if (tree.getChild(i).getChild(tree.getChild(i).getChildCount()-2).getText() != "FIELDDEC") { // on test si l'avant dernier fils n'est pas FIELDDEC (donc est le type de retour)
					String retour = tree.getChild(i).getChild(tree.getChild(i).getChildCount()-2).getText();
					tableParent.ajouterFonction(nom, retour, nouvelle);
				}
				else {
					tableParent.ajouterFonction(nom, null, nouvelle);
				}
				parcoursArbre(tree.getChild(i),nouvelle);
				break;
			case "LET":
			case "WHILE":
			case "FOR":
				//dans les cas précédent, il faut créer une nouvelle table des symboles qui devient
				nouvelle = new TableSymboles(tableParent);
				parcoursArbre(tree.getChild(i),nouvelle);
				break;
			// cas ne creant pas de nouveau blocOrig
			case "VARDEC":
				// TODO : verifier que le nom de la variable n'existe pas deja
				// verifier que le type existe
				if (tree.getChildCount()==3) {
					tableParent.ajouterSymbole(tree.getChild(i).getChild(0).getText(),tree.getChild(i).getChild(1).getText());
				}
				else {
					tableParent.ajouterSymbole(tree.getChild(i).getChild(0).getText(), null);
				}
				break;
			case "IDBEG":
				// que des controle semantique dans IDBEGIN ?
				if (tree.getChildCount()==2) {
					switch(tree.getChild(1).getText()) {
					case "EXPBEG":
						break;
					case "FIELDEXP":
						break;
					case "RECCREATE":
						break;
					case "CALLEXP" :
						break;
					case "ASSIGNMENT":
						break;
					}
				// else -> controle semantique
					
				}
				break;
			default:
				parcoursArbre(tree.getChild(i),tableParent);//si on est pas dans les cas précédents,on crée une nouvelle table
				break;
			}

		}

	}
}

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

import tableSymbole.TableSymboles;

public class Main {


	public static void main(String[] args) throws FileNotFoundException, IOException, RecognitionException {
		TableSymboles blocOrig = new TableSymboles(null);
		ajouterTypesBase(blocOrig);
		ajouterFonctionBase(blocOrig);
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

	private static void ajouterTypesBase(TableSymboles tds)
	{
		System.out.println("Ajout des types de bases à la TDS d'origine");
		tds.ajouterType("int");
		tds.ajouterType("string");
	}

	private static void ajouterFonctionBase(TableSymboles tds)
	{
		System.out.println("Ajout des fonctions de bases");
		tds.ajouterFonction("print", "void", null);
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
				if (tree.getChild(i).getChild(tree.getChild(i).getChildCount()-2).getText() != "FIELDDEC") {
					// on test si l'avant dernier fils n'est pas FIELDDEC (donc est le type de retour)
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
				if (tree.getChildCount()==3)//cas où le type est précisé
				{
					tableParent.ajouterVariable(tree.getChild(0).getText(),tree.getChild(1).getText());
					i = i+3;
				}
				else //s'il n'y a que deux fils, alors il faut detecter le type
				{
					String valeur=tree.getChild(1).getText();//valeur
					if(valeur.matches("-?(0|[1-9]\\d*)"))//si c'est un entier
					{
						tableParent.ajouterVariable(tree.getChild(0).getText(), "int");
					}
					else if(valeur.matches("[^\"]*"))//sinon si c'est une chaîne de caractère
					{
						tableParent.ajouterVariable(tree.getChild(0).getText(), "string");
					}
					else
					{
						System.err.println("Impossible de détecter le type");
					}
					i = i +2;

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

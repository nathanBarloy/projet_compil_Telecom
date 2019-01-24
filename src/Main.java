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
		blocOrig = parcoursArbre(tree,blocOrig);
		// Affichage des tables de symboles pour vérification
		afficherTDS(blocOrig);
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
	public static TableSymboles parcoursArbre(Tree tree,TableSymboles tableParent)
	{
		TableSymboles nouvelle;
		afficherTDS(tableParent);
		System.out.println("Nb de fils : "+tree.getChildCount());
		for(int i=0;i<tree.getChildCount();i++)
		{
			System.out.println("tree : "+tree.getText());
			System.out.println("i (boucle): "+i);
			
			Tree newTree = tree.getChild(i);
			System.out.println("newTree : "+newTree.getText());

			switch(newTree.getText())
			{
			/* LE PARCOURS N'EST PAS BON 
			 * TODO : Corriger les appels parcoursArbre(tree,...) -> changer le tree pour que ça marche
			 * 
			 * */
			
			//case "ROOT":
			//cas creant un nouveau bloc
			case "FUNDEC":
				nouvelle = new TableSymboles(tableParent);
				tableParent.addFils(nouvelle);
				System.out.println("Création de table des symboles 1");
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
				nouvelle = new TableSymboles(tableParent);
				tableParent.addFils(nouvelle);
				System.out.println("Création de table des symboles 2");
				parcoursArbre(tree.getChild(i),nouvelle);
				break;
			case "WHILE":
			case "FOR":
				//dans les cas précédent, il faut créer une nouvelle table des symboles qui devient
				nouvelle = new TableSymboles(tableParent);
				tableParent.addFils(nouvelle);
				System.out.println("Création de table des symboles 3");
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
					System.out.println("i dans VARDEC (avant): "+i);
					i = i +2;
					System.out.println("i dans VARDEC (après): "+i);

				}
				System.out.println("break");
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
		return tableParent;

	}
	
	public static void afficherTDS(TableSymboles tds)
	{
		System.out.println(tds.toString());
		for(int i = 0;i<tds.getFils().size();i++)
		{
			afficherTDS(tds.getFils(i));
		}
	}
}

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
import identificateurs.Type;

public class Main {


	public static void main(String[] args) throws FileNotFoundException, IOException, RecognitionException {
		TableSymboles blocOrig = new TableSymboles();
		ajouterTypesBase(blocOrig);
		ajouterFonctionBase(blocOrig);
		System.out.println("///////////////////////////////////////");

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream("Tests/testsSyntaxiques/forExp/fonctionnels/forExp.tig"));
		//ANTLRInputStream input = new ANTLRInputStream(new FileInputStream("Tests/testsSemantiques/testDeclarationIdentificateurDejaExistant/nonFonctionnels/test1.tig"));
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

	/**
	 * Cette fonction ajoute les types de bases du langage à la TDS passée en paramètre
	 * @param tds Table des symboles dans laquelle ajouter les types de bases du langage
	 */
	private static void ajouterTypesBase(TableSymboles tds)
	{
		System.out.println("Ajout des types de bases à la TDS d'origine");
		tds.ajouterType("int");
		tds.ajouterType("string");
		tds.ajouterType("void");
	}

	/**
	 * Cette fonction ajoute les fonctions de base du langage à la TDS passée en paramètre
	 * @param tds Table des symboles dans laquelle ajouter les fonctions de bases du langage
	 */
	private static void ajouterFonctionBase(TableSymboles tds)
	{
		System.out.println("Ajout des fonctions intrinsèques");
		tds.ajouterFonction("print", "void", null);
		tds.ajouterFonction("flush","void", null);
		tds.ajouterFonction("getchar", "string", null);
		tds.ajouterFonction("ord", "int", null);
		tds.ajouterFonction("chr", "string", null);
		tds.ajouterFonction("size", "int", null);
		tds.ajouterFonction("substring", "string", null);
		tds.ajouterFonction("concat", "string", null);
		tds.ajouterFonction("not", "int", null);
		tds.ajouterFonction("exit", "int", null);
	}

	public static TableSymboles parcoursArbre(Tree tree,TableSymboles tableParent)
	{
		TableSymboles nouvelle;
		afficherTDS(tableParent);
		System.out.println("Nb de fils : "+tree.getChildCount());
		for(int i=0;i<tree.getChildCount();i++)
		{
			System.out.println("tree.getChild("+i+").getText() : "+tree.getChild(i).getText());
			switch(tree.getChild(i).getText())
			{

			//case "ROOT":
			//cas creant un nouveau bloc

			case "FUNDEC":
				nouvelle = new TableSymboles(tableParent);
				tableParent.addFils(nouvelle);
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
				parcoursArbre(tree.getChild(i),nouvelle);
				break;

			case "WHILE":
				System.err.println("Not yet implemented");
				break;

			case "FOR":
				//dans les cas précédent, il faut créer une nouvelle table des symboles qui devient
				nouvelle = new TableSymboles(tableParent);
				tableParent.addFils(nouvelle);
				String start=tree.getChild(i).getChild(1).getText();//valeur
				String end=tree.getChild(i).getChild(2).getText();//valeur
				if(start.matches("(\\d*)") && end.matches("(\\d*)")) { 		//si le debut et la fin du for sont des entiers
					nouvelle.ajouterVariable(tree.getChild(i).getChild(0).getText(),"int"); // TODO : gerer le cas d'une addition
				}
				else {
					System.err.println("Le début et la fin de l'index doit être de type : int");
				}
				parcoursArbre(tree.getChild(i),nouvelle);
				break;
				// cas ne creant pas de nouveau blocOrig

			case "VARDEC":
				if (tree.getChildCount()==3)//cas où le type est précisé
				{
					tableParent.ajouterVariable(tree.getChild(0).getText(),tree.getChild(1).getText());
				}
				else //s'il n'y a que deux fils, alors il faut detecter le type
				{
					String valeur=tree.getChild(i).getChild(1).getText();//valeur
					System.out.println("valeur : "+valeur);
					if(valeur.matches("(\\d*)")) //si c'est un entier

					{
						System.out.println("ajoute entier");
						tableParent.ajouterVariable(tree.getChild(i).getChild(0).getText(), "int"); // TODO : gerer le cas d'une addition
					}

					else if(valeur.matches("(^\".*\"$)"))//sinon si c'est une chaîne de caractère commencant et terminant pas "
					{
						System.out.println("ajoute string");
						tableParent.ajouterVariable(tree.getChild(i).getChild(0).getText(), "string");
					}
					else
					{
						System.err.println("Impossible de détecter le type");
					}


				}
				System.out.println("break");
				break;

			case "TYDEC" :
				String nomType = tree.getChild(0).getText();
				if (tableParent.get(nomType)!=null) { // si le nom existe déjà
					System.err.println("Le nom "+nomType+" à déjà été pris, impossible de créer le type");
				} else { // si le nom est valable
					switch(tree.getChild(1).getText()) {
					case "RECTY" : // on défini un ensemble
						//TODO verifier que les types utilisés existent bien
						break;
					case "ARRTY" : // on défini une liste
						//TODO vérifier que le type de la liste existe bien
						break;
					default : // on défini un alias
						String aliased = tree.getChild(1).getText();
						if (tableParent.getType(aliased)==null) { // si le type que l'on veut utiliser n'existe pas ou n'est pas un type
							System.err.println("Le nom "+ aliased+" n'existe pas ou ne représente pas un type");
						} else { // si le nom entré est valable
							tableParent.ajouterType(nomType);
						}
						break;
					}
				}

				//TODO ajouter le nouveau type à la TDS
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

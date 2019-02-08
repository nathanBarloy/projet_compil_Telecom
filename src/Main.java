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
import identificateurs.Variable;

public class Main {


	public static void main(String[] args) throws FileNotFoundException, IOException, RecognitionException {
		TableSymboles blocOrig = new TableSymboles();
		ajouterTypesBase(blocOrig);
		ajouterFonctionBase(blocOrig);
		System.out.println("///////////////////////////////////////");

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream("Tests/testsSemantiques/testDeclarationType/aliasTypeInexistant.tig"));
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
		tds.ajouterTypePrimitif("int");
		tds.ajouterTypePrimitif("string");
		tds.ajouterTypePrimitif("void");
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
	//	afficherTDS(tableParent);
	//	System.out.println("Nb de fils : "+tree.getChildCount());
		for(int i=0;i<tree.getChildCount();i++)
		{
		//	System.out.println("tree.getChild("+i+").getText() : "+tree.getChild(i).getText());
			controleOp(tree.getChild(i), tableParent);
			controleComparateurEgEq(tree.getChild(i),tableParent);
			controleComparateurInfSup(tree.getChild(i), tableParent);
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
				if(start.matches("INT") && end.matches("INT")) { 		//si le debut et la fin du for sont des entiers
					nouvelle.ajouterVariable(tree.getChild(i).getChild(0).getText(),"int"); // TODO : gerer le cas d'une addition
				}
				else {
					System.err.println("Le début et la fin de l'index doit être de type : int");
				}
				parcoursArbre(tree.getChild(i),nouvelle);
				break;
				// cas ne creant pas de nouveau blocOrig

			case "VARDEC":
				if (tree.getChild(i).getChildCount()==3)//cas où le type est précisé
				{
					String typeDeclare = tableParent.getType(tree.getChild(i).getChild(1).getText()).getName();
					String dernierNoeud = tree.getChild(i).getChild(2).getText();
					String typeDetecte = detectionTypeExp(tree.getChild(i).getChild(2),tableParent);
				/*	if(dernierNoeud.compareTo("IDBEG")==0)//il faut récupérer le type de cet identificateur dans la TDS
					{
						//System.out.println("cas IDBEG");
						typeDetecte = tableParent.getVariableType(tree.getChild(i).getChild(2).getChild(0).getText());
					}
					else
					{
						//System.out.println("Cas pas IDBEG");
						typeDetecte = tableParent.getType(detecterType(dernierNoeud));
					}*/

					if (typeDeclare != typeDetecte || typeDetecte == null)
					{
						System.err.println("Le type de la declaration ("+typeDeclare+") est different du type détecté ("+typeDetecte+").");
					}
					else
					{
						tableParent.ajouterVariable(tree.getChild(i).getChild(0).getText(),tree.getChild(i).getChild(1).getText());
					}
				}
				else //s'il n'y a que deux fils, alors il faut detecter le type
				{
					Tree valeur=tree.getChild(i).getChild(1);//valeur
					//System.out.println("valeur : "+valeur);
					String type=detectionTypeExp(valeur,tableParent);
					tableParent.ajouterVariable(tree.getChild(i).getChild(0).getText(), type);
				}
				break;

			case "TYDEC" :
				Tree tydecTree = tree.getChild(i);
				String nomType = tydecTree.getChild(0).getText();
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
						String aliased = tydecTree.getChild(1).getText();
						if (tableParent.getType(aliased)==null) { // si le type que l'on veut utiliser n'existe pas ou n'est pas un type
							System.err.println("Le nom "+ aliased+" n'existe pas ou ne représente pas un type");
						} else { // si le nom entré est valable
							tableParent.ajouterTypeAlias(nomType, aliased);
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

	public static void controleOp(Tree tree, TableSymboles tds) {		// controle semantique sur les operateurs ayant pour operandes des type int	
		String root = tree.getText();
		if(root.equals("+") || root.equals("-") || root.equals("*") || root.equals("/") ||	 root.equals("&") || root.equals("|")){ // si on est dans une operation ou les opérandes sont des int
			// cas ou le fils gauche n'est pas un entier ou seqexp
			String fg = tree.getChild(0).getText();
			String fd = tree.getChild(1).getText();
			if (!fg.matches("INT") && fg != "SEQEXP"){
				String typeFg = detectionTypeExp(tree.getChild(0), tds);
				if(typeFg != null) {
					if(typeFg != "int") {
						System.err.println("La variable '"+tree.getChild(0).getChild(0).getText()+"' n'est pas de type int");
					}
				}
				// cas ou le fils gauche n'est pas une operation
				else if(!(fg.equals("+") || fg.equals("-") || fg.equals("*") || fg.equals("/") || fg.equals("=") || fg.equals("<>") || fg.equals("&") || fg.equals("|"))) {
					System.err.println("L'opérande "+fg+" n'est pas un int");
				}
			}
			// cas ou le fils droit n'est pas un entier ou seqexp
			if (!fd.matches("INT") && fd != "SEQEXP"){
				String typeFd = detectionTypeExp(tree.getChild(1), tds);
				if(typeFd != null) {
					if(typeFd != "int") {
						System.err.println("La variable '"+tree.getChild(1).getChild(0).getText()+"' n'est pas de type int");
					}
				}
				// TODO : rajouter tous les cas ou une exp retourne un int
				
				// cas ou le fils droit n'est pas une operation
				else if(!(fd.equals("+") || fd.equals("-") || fd.equals("*") || fd.equals("/") || fd.equals("=") || fd.equals("<>") || fd.equals("&") || fd.equals("|"))) {
					System.err.println("L'opérande "+fd+" n'est pas de type int");
					// TODO : gerer le cas de variable ou appel de fonction
				}
			}
			if(fg == "SEQEXP") {
				if(tree.getChild(0).getChildCount() == 0) { // cas ou SEQEXP est de type void
					System.err.println("La sequence d'expressions est vide");
				}
			}
			if(fd == "SEQEXP") {
				if(tree.getChild(1).getChildCount() == 0) { // cas ou SEQEXP est de type void
					System.err.println("La sequence d'expressions est vide");
				}
			}
		}
	}
	
	public static void controleComparateurEgEq(Tree tree, TableSymboles tds) { 	// verifie que les deux operandes des comparateurs = et <> sont de meme type
		String root = tree.getText();
		if(root.equals("=") || root.equals("<>")) {	// si le noeud est l'un des deux operateurs
			Tree fg = tree.getChild(0);
			Tree fd = tree.getChild(1);
			String typeDetecteFg = detectionTypeExp(fg, tds);
			String typeDetecteFd = detectionTypeExp(fd, tds);
			if (typeDetecteFd != null && typeDetecteFg != null) {
				if (!typeDetecteFg.equals(typeDetecteFd)) {
					System.err.println("L'identificateur '"+fg.getChild(0)+"' (type '"+typeDetecteFg+"') n'est pas de même type que '"+fd.getChild(0)+"' (type '"+typeDetecteFd+"')");
				}
			}
			else {
				System.err.println("Aucun type détecté");
			}
		}
		
	}
	
	public static void controleComparateurInfSup(Tree tree, TableSymboles tds) { // verifie que les deux operandes des comparateurs < <= > >= sont de même type et de type int ou string
		String root = tree.getText();
		if (root.equals("<") || root.equals("<=") || root.equals(">") || root.equals(">=")) {
			Tree fg = tree.getChild(0);
			Tree fd = tree.getChild(1);
			String typeDetecteFg = detectionTypeExp(fg, tds);
			String typeDetecteFd = detectionTypeExp(fd, tds);
			if (typeDetecteFd != null && typeDetecteFg != null) {
				if(typeDetecteFg == "int" && typeDetecteFd != "int") {
					System.err.println("Le type attendu de l'identificateur '"+fd.getChild(0).getText()+"' est 'int' alors qu'il est de type '"+typeDetecteFd+"'");
				}
				else if(typeDetecteFg == "string" && typeDetecteFd != "string") {	
					System.err.println("Le type attendu de l'identificateur '"+fd.getChild(0).getText()+"' est 'string' alors qu'il est de type '"+typeDetecteFd+"'");
				}
				else if (typeDetecteFg != "int" && typeDetecteFg != "string"){
					System.err.println("L'identificateur '"+fg.getChild(0).getText()+"' (type '"+typeDetecteFd+"') n'est ni de type 'int' ni de type 'string'");
				}
			}
			else {
				System.err.println("Aucun type détecté");
			}
		}
	}
	
	public static String detectionTypeExp(Tree noeud, TableSymboles tds) {  // gestion de tous les types possible d'une exp; retourne le type du noeud entre
		String texteNoeud = noeud.getText();
		String typeRes = null;
		switch(texteNoeud) {
		case "IDBEG":
			// cas d'une variable
			if (noeud.getChildCount() == 1) {
				Variable v = (Variable)tds.get(noeud.getChild(0).getText());
				if(v==null) {
					System.err.println("La variable '"+noeud.getChild(0).getText()+"' n'est pas déclarée");
				}
				else {
					typeRes = tds.getVariableType(noeud.getChild(0).getText()).getName();
				}
			}
			// TODO : faire les autres cas possible du IDBEG
			break;
		case "INT":
			typeRes = "int";
			break;
		case "STRING":
			typeRes = "string";
			break;
			
		// TODO : faire les autre cas possible de exp
		}
		return typeRes;
	}

	public static void afficherTDS(TableSymboles tds)
	{
		System.out.println(tds.toString());
		for(int i = 0;i<tds.getFils().size();i++)
		{
			afficherTDS(tds.getFils(i));
		}
	}

	/*public static String detecterType(String texteNoeud) // a integrer dans detectionTypeExp ?
	{
		if(texteNoeud.matches("INT")) //si c'est un entier

		{
			//System.out.println("ajoute entier");
			return "int";
			// TODO : gerer le cas d'une operation
		}

		else if(texteNoeud.matches("STRING"))//sinon si c'est une chaîne de caractère commencant et terminant pas "
		{
			//System.out.println("ajoute string");
			return "string";
		}
		else
		{
			System.err.println("Impossible de détecter le type");
			return "";
		}
	}
*/
}

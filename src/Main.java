import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.DOTTreeGenerator;
import org.antlr.runtime.tree.Tree;
import org.antlr.stringtemplate.StringTemplate;

import identificateurs.AliasType;
import identificateurs.ArrayType;
import identificateurs.RecordType;
import identificateurs.Type;
import identificateurs.Variable;
import tableSymbole.*;


public class Main {

	private static ArrayList<String> listeNomsType;

	public static void main(String[] args) throws FileNotFoundException, IOException, RecognitionException {
		TableSymbolesAbs blocOrig = new TableSymboles();
		ajouterTypesBase(blocOrig);
		ajouterFonctionBase(blocOrig);
		System.out.println("///////////////////////////////////////");
		
		String path = "Tests/testsSemantiques/testNegation/nonFonctionnel/test1.tig";
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));

		TigerLexer lexer = new TigerLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TigerParser parser = new TigerParser(tokens);
		CommonTree tree=(CommonTree)parser.program().getTree();
		blocOrig = parcoursArbre(tree,blocOrig,path);
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
	private static void ajouterTypesBase(TableSymbolesAbs tds)
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
	private static void ajouterFonctionBase(TableSymbolesAbs tds)
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

	/**
	 * Parcours l'AST et réalise l'analyse et la construction de la TDS
	 * @param tree AST à parcourir
	 * @param tableParent table des symbole du bloc parent
	 * @param path chemin du fichier sur lequel l'AST à été construit
	 * @return
	 */
	public static TableSymbolesAbs parcoursArbre(Tree tree,TableSymbolesAbs tableParent,String path)
	{
		TableSymbolesAbs nouvelle;
	//	afficherTDS(tableParent);
	//	System.out.println("Nb de fils : "+tree.getChildCount());
		for(int i=0;i<tree.getChildCount();i++)
		{
			//System.out.println("tree.getChild("+i+").getText() : "+tree.getChild(i).getText());
			controleOp(tree.getChild(i), tableParent,path);
			controleComparateurEgEq(tree.getChild(i),tableParent,path);
			controleComparateurInfSup(tree.getChild(i), tableParent,path);
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
				parcoursArbre(tree.getChild(i),nouvelle,path);
				break;

			case "LET":
				nouvelle = new TableSymboles(tableParent);
				tableParent.addFils(nouvelle);
				parcoursArbre(tree.getChild(i),nouvelle,path);
				break;

			case "WHILE":
				nouvelle = new TableSymbolesWhile(tableParent);
				tableParent.addFils(nouvelle);
				String testParam = tree.getChild(i).getChild(0).getText();
				String typeDetecteParam = detectionTypeExp(tree.getChild(i).getChild(0), tableParent,path);
				if( typeDetecteParam != "int") {
					//System.err.println("Le type de "+testParam+" doit être un INT. Type detecte : "+typeDetecteParam);
					afficherErreurSemantique(tree.getChild(i).getChild(0),"Le type de "+testParam+" doit être un INT. Type detecte : "+typeDetecteParam,path);
				}
				String testReturn = tree.getChild(i).getChild(1).getText();
				String typeDetecteReturn = detectionTypeExp(tree.getChild(i).getChild(1), tableParent,path);
				if ( typeDetecteReturn != "void") {
					//System.err.println("Le type de "+testReturn+" doit etre void. Type detecte : "+typeDetecteReturn);
					afficherErreurSemantique(tree.getChild(i).getChild(1), "Le type de "+testReturn+" doit etre void. Type detecte : "+typeDetecteReturn,path);
				}
				parcoursArbre(tree.getChild(i),nouvelle,path);
				break;

			case "FOR":
				//dans les cas précédent, il faut créer une nouvelle table des symboles qui devient
				nouvelle = new TableSymbolesFor(tableParent);
				tableParent.addFils(nouvelle);
				String start=tree.getChild(i).getChild(1).getText();//valeur
				String end=tree.getChild(i).getChild(2).getText();//valeur
				if(start.matches("INT") && end.matches("INT")) { 		//si le debut et la fin du for sont des entiers
					nouvelle.ajouterVariable(tree.getChild(i).getChild(0).getText(),"int");
				}
				else {
					//System.err.println("Le début et la fin de l'index doit être de type : int");
					afficherErreurSemantique(tree.getChild(i).getChild(0), "Le début et la fin de l'index doit être de type : int",path);
				}
				String typeCorps = detectionTypeExp(tree.getChild(i).getChild(3), tableParent,path);
				if(typeCorps != "void") {
					//System.err.println("Le corps du FOR doit être de type 'void'");
					afficherErreurSemantique(tree.getChild(i).getChild(3), "Le corps du FOR doit être de type 'void'",path);
				}
				parcoursArbre(tree.getChild(i),nouvelle,path);
				break;

			// cas ne creant pas de nouveau blocOrig

			case "VARDEC":
				if (tree.getChild(i).getChildCount()==3)//cas où le type est précisé
				{
					String typeDeclare = tableParent.getType(tree.getChild(i).getChild(1).getText()).getName();
					String dernierNoeud = tree.getChild(i).getChild(2).getText();
					String typeDetecte = detectionTypeExp(tree.getChild(i).getChild(2),tableParent,path);
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
						//System.err.println("Le type de la declaration ("+typeDeclare+") est different du type détecté ("+typeDetecte+").");
						afficherErreurSemantique(tree.getChild(i).getChild(1), "Le type de la declaration ("+typeDeclare+") est different du type détecté ("+typeDetecte+").",path);
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
					String type=detectionTypeExp(valeur,tableParent,path);
					tableParent.ajouterVariable(tree.getChild(i).getChild(0).getText(), type);
				}
				break;

			case "TYDEC" :
				Tree tydecTree = tree.getChild(i);
				String nomType = tydecTree.getChild(0).getText();
				if (i==0 || !tree.getChild(i-1).getText().equals("TYDEC")) { // si le premier element du bloc de declaration
					int j=0;
					listeNomsType = new ArrayList<String>();
					while (i+j<tree.getChildCount() && tree.getChild(i+j).getText().equals("TYDEC")) { //on parcours les noeuds suivant pour connaitre la taille du bloc de déclaration
						listeNomsType.add(tree.getChild(i+j).getChild(0).getText());
						j++;
					}
					// listeNomsType contient la liste des noms de type qu'on veut déclarer dans ce bloc
				}

				if (tableParent.get(nomType)!=null) { // si le nom existe déjà
					//System.err.println("Le nom '"+nomType+"' à déjà été pris, impossible de créer le type");
					afficherErreurSemantique(tydecTree.getChild(0), "Le nom '"+nomType+"' à déjà été pris, impossible de créer le type",path);
				} else { // si le nom est valable
					switch(tydecTree.getChild(1).getText()) {
					case "RECTY" : // on défini un ensemble
						RecordType newType = new RecordType(nomType);
						for (int j=0; j<tydecTree.getChildCount(); j++) {
							Tree decTree = tydecTree.getChild(1).getChild(j);
							String nomComponent = decTree.getChild(0).getText();
							String nomSousType = decTree.getChild(1).getText();

							Type sousType = tableParent.getType(nomSousType);
							if (sousType==null && !listeNomsType.contains(nomSousType)) {
								//System.err.println("Le nom '"+ nomSousType+"' n'existe pas ou ne représente pas un type");
								afficherErreurSemantique(decTree.getChild(1), "Le nom '"+ nomSousType+"' n'existe pas ou ne représente pas un type",path);
							} else {
								newType.addComponent(nomComponent, sousType);
							}
						}
						tableParent.ajouterTypeRecord(nomType, newType);
						break;
						
					case "ARRTY" : // on défini une liste
						String sousType = tydecTree.getChild(1).getChild(0).getText();
						if (tableParent.getType(sousType)==null && !listeNomsType.contains(sousType)) { // si le type que l'on veut utiliser n'existe pas ou n'est pas un type
							//System.err.println("Le nom '"+ sousType+"' n'existe pas ou ne représente pas un type");
							afficherErreurSemantique(tydecTree.getChild(1).getChild(0), "Le nom '"+ sousType+"' n'existe pas ou ne représente pas un type",path);
						} else { // si le nom entré est valable
							tableParent.ajouterTypeArray(nomType, sousType);
						}
						break;
					default : // on défini un alias
						String aliased = tydecTree.getChild(1).getText();
						if (tableParent.getType(aliased)==null && !listeNomsType.contains(aliased)) { // si le type que l'on veut utiliser n'existe pas ou n'est pas un type
							//System.err.println("Le nom '"+ aliased+"' n'existe pas ou ne représente pas un type");
							afficherErreurSemantique(tydecTree.getChild(1), "Le nom '"+ aliased+"' n'existe pas ou ne représente pas un type",path);
						} else { // si le nom entré est valable
							tableParent.ajouterTypeAlias(nomType, aliased);
						}
						break;
					}
				}
				
				//en fin de bloc de déclaration
				if (i+1<tree.getChildCount() && !tree.getChild(i+1).getText().equals("TYDEC")) {		
					for (String nomSsType:listeNomsType) {
						Type ssType = tableParent.getType(nomSsType);
						if (ssType instanceof ArrayType) {
							ArrayType ssArrayType = (ArrayType) ssType;
							if ( ssArrayType.getSousType()==null) {
								ssArrayType.setSousType(tableParent.getType(ssArrayType.getNomSousType()));
							}
						}
						if (ssType instanceof RecordType) {
							RecordType ssRecordType = (RecordType) ssType;
							
						}
						if (ssType instanceof AliasType) {
							AliasType ssAliasType = (AliasType) ssType;
							if ( ssAliasType.getType()==null) {
								ssAliasType.setType(tableParent.getType(ssAliasType.getNomAliasedType()));
							}
						}
					}
					//TODO vérifier les boucles dans les references de types
				}
				
				break;

			case "IDBEG":
				// que des controle semantique dans IDBEGIN ?
				System.out.println("Cas idbeg : "+tree.getChild(i).getChildCount());
				if (tree.getChild(i).getChildCount()==2)
				{
					switch(tree.getChild(i).getChild(1).getText())
					{
						case "EXPBEG":
							break;
						case "FIELDEXP":
							break;
						case "RECCREATE":
							break;
						case "CALLEXP" :
							break;
						case "ASSIGNMENT":
							// TODO : verifier que si on est dans un for on n'assigne pas de valeur a l'index du for
							break;
					}
				}
				else if(tree.getChild(i).getChildCount()==1)//s'il n'y a qu'un fils, on vérifie que la variable existe
				{
					String texte = tree.getChild(i).getChild(0).getText();
					System.out.println(texte);
					if(tableParent.get(texte) == null)
					{
						//System.err.println("Tentative d'affectation avec une variable non déclarée : '"+texte+"'.");
						afficherErreurSemantique(tree.getChild(i).getChild(0), "Tentative d'affectation avec une variable non déclarée : '"+texte+"'.",path);
					}

				}
				break;
			case "NEGATION" :
				String typeDetecte = detectionTypeExp(tree.getChild(i).getChild(0),tableParent,path);
				if (typeDetecte != "int") {
					//System.err.println("Le type attendu de '"+tree.getChild(i).getChild(0).getChild(0).getText()+"' est 'int' (actuellement de type '"+typeDetecte+"')");
					afficherErreurSemantique(tree.getChild(i).getChild(0), "Le type attendu de '"+tree.getChild(i).getChild(0).getChild(0).getText()+"' est 'int' (actuellement de type '"+typeDetecte+"')",path);
				}
				break;
			case "IFTHEN" :
				String typeCondition = detectionTypeExp(tree.getChild(i).getChild(0),tableParent,path);
				String typeThen = detectionTypeExp(tree.getChild(i).getChild(1), tableParent,path);
				int nbFils = tree.getChild(i).getChildCount();
				if (typeCondition !="int") {		// controle semantique sur la condtion du if
					//System.err.println("La condition du IF doit être de type 'int' (actuellement : '"+typeCondition+"')");
					afficherErreurSemantique(tree.getChild(i).getChild(0), "La condition du IF doit être de type 'int' (actuellement : '"+typeCondition+"')",path);
				}
				if(nbFils == 2) {		// si pas de ELSE le type de THEN doit être void
					if(typeThen != "void") {
						//System.err.println("La clause THEN doit être de type 'void' (actuellement :'"+typeThen+"')");
						afficherErreurSemantique(tree.getChild(i).getChild(0), "La clause THEN doit être de type 'void' (actuellement :'"+typeThen+"')",path);
					}
				}
				else if (nbFils == 3) {		// si ELSE les types doivent correspondre
					String typeElse = detectionTypeExp(tree.getChild(i).getChild(2),tableParent,path);
					if (typeThen != typeElse) {
						//System.err.println("Les clauses THEN et ELSE doivent être de même type");
						afficherErreurSemantique(tree.getChild(i).getChild(2), "Les clauses THEN et ELSE doivent être de même type",path);
					}
				}
				nouvelle = new TableSymboles(tableParent);
				tableParent.addFils(nouvelle);
				parcoursArbre(tree.getChild(i),nouvelle,path);
				break;
			case "break" :
				if(!tableParent.isBreakable()) {
					//System.err.println("Le mot-clé 'break' ne peut être utilisé que dans un bloc 'while' ou 'for'");
					afficherErreurSemantique(tree.getChild(i), "Le mot-clé 'break' ne peut être utilisé que dans un bloc 'while' ou 'for'",path);
				}
				break;

			default:
				parcoursArbre(tree.getChild(i),tableParent,path);//si on est pas dans les cas précédents,on crée une nouvelle table
				break;
			}

		}
		return tableParent;

	}

	public static void controleOp(Tree tree, TableSymbolesAbs tds,String path) {		// controle semantique sur les operateurs ayant pour operandes des type int
		String root = tree.getText();
		if(root.equals("+") || root.equals("-") || root.equals("*") || root.equals("/") ||	 root.equals("&") || root.equals("|")){ // si on est dans une operation ou les opérandes sont des int
			// cas ou le fils gauche n'est pas un entier ou seqexp
			String fg = tree.getChild(0).getText();
			String fd = tree.getChild(1).getText();
			if (!fg.matches("INT") && fg != "SEQEXP"){
				String typeFg = detectionTypeExp(tree.getChild(0), tds,path);
				if(typeFg != null) {
					if(typeFg != "int") {
						//System.err.println("La variable '"+tree.getChild(0).getChild(0).getText()+"' n'est pas de type int");
						afficherErreurSemantique(tree.getChild(0), "La variable '"+tree.getChild(0).getChild(0).getText()+"' n'est pas de type int",path);
					}
				}
				// cas ou le fils gauche n'est pas une operation
				else if(!(fg.equals("+") || fg.equals("-") || fg.equals("*") || fg.equals("/") || fg.equals("=") || fg.equals("<>") || fg.equals("&") || fg.equals("|"))) {
					//System.err.println("L'opérande "+fg+" n'est pas un int");
					afficherErreurSemantique(tree.getChild(0), "L'opérande "+fg+" n'est pas un int",path);
				}
			}
			// cas ou le fils droit n'est pas un entier ou seqexp
			if (!fd.matches("INT") && fd != "SEQEXP"){
				String typeFd = detectionTypeExp(tree.getChild(1), tds,path);
				if(typeFd != null) {
					if(typeFd != "int") {
						//System.err.println("La variable '"+tree.getChild(1).getChild(0).getText()+"' n'est pas de type int");
						afficherErreurSemantique(tree.getChild(1), "La variable '"+tree.getChild(1).getChild(0).getText()+"' n'est pas de type int",path);
					}
				}

				// cas ou le fils droit n'est pas une operation
				else if(!(fd.equals("+") || fd.equals("-") || fd.equals("*") || fd.equals("/") || fd.equals("=") || fd.equals("<>") || fd.equals("&") || fd.equals("|"))) {
					//System.err.println("L'opérande "+fd+" n'est pas de type int");
					afficherErreurSemantique(tree.getChild(1), "L'opérande "+fd+" n'est pas de type int",path);
				}
			}
			if(fg == "SEQEXP") {
				if(tree.getChild(0).getChildCount() == 0) { // cas ou SEQEXP est de type void
					//System.err.println("La sequence d'expressions est vide");
					afficherErreurSemantique(tree.getChild(0), "La sequence d'expressions est vide",path);
				}
			}
			if(fd == "SEQEXP") {
				if(tree.getChild(1).getChildCount() == 0) { // cas ou SEQEXP est de type void
					//System.err.println("La sequence d'expressions est vide");
					afficherErreurSemantique(tree.getChild(1), "La sequence d'expressions est vide",path);
				}
			}
		}
	}

	public static void controleComparateurEgEq(Tree tree, TableSymbolesAbs tds,String path) { 	// verifie que les deux operandes des comparateurs = et <> sont de meme type
		String root = tree.getText();
		if(root.equals("=") || root.equals("<>")) {	// si le noeud est l'un des deux operateurs
			Tree fg = tree.getChild(0);
			Tree fd = tree.getChild(1);
			String typeDetecteFg = detectionTypeExp(fg, tds,path);
			String typeDetecteFd = detectionTypeExp(fd, tds,path);
			if (typeDetecteFd != null && typeDetecteFg != null) {
				if (!typeDetecteFg.equals(typeDetecteFd)) {
					//System.err.println("L'identificateur '"+fg.getChild(0)+"' (type '"+typeDetecteFg+"') n'est pas de même type que '"+fd.getChild(0)+"' (type '"+typeDetecteFd+"')");
					afficherErreurSemantique(fd.getChild(0), "L'identificateur '"+fg.getChild(0)+"' (type '"+typeDetecteFg+"') n'est pas de même type que '"+fd.getChild(0)+"' (type '"+typeDetecteFd+"')",path);
				}
			}
			else {
				//System.err.println("Aucun type détecté");
				afficherErreurSemantique(fd.getChild(0), "Aucun type détecté",path);
			}
		}

	}

	public static void controleComparateurInfSup(Tree tree, TableSymbolesAbs tds,String path) { // verifie que les deux operandes des comparateurs < <= > >= sont de même type et de type int ou string
		String root = tree.getText();
		if (root.equals("<") || root.equals("<=") || root.equals(">") || root.equals(">=")) {
			Tree fg = tree.getChild(0);
			Tree fd = tree.getChild(1);
			String typeDetecteFg = detectionTypeExp(fg, tds,path);
			String typeDetecteFd = detectionTypeExp(fd, tds,path);
			if (typeDetecteFd != null && typeDetecteFg != null) {
				if(typeDetecteFg == "int" && typeDetecteFd != "int") {
					//System.err.println("Le type attendu de l'identificateur '"+fd.getChild(0).getText()+"' est 'int' alors qu'il est de type '"+typeDetecteFd+"'");
					afficherErreurSemantique(fd.getChild(0), "Le type attendu de l'identificateur '"+fd.getChild(0).getText()+"' est 'int' alors qu'il est de type '"+typeDetecteFd+"'",path);
				}
				else if(typeDetecteFg == "string" && typeDetecteFd != "string") {
					//System.err.println("Le type attendu de l'identificateur '"+fd.getChild(0).getText()+"' est 'string' alors qu'il est de type '"+typeDetecteFd+"'");
					afficherErreurSemantique(fd.getChild(0), "Le type attendu de l'identificateur '"+fd.getChild(0).getText()+"' est 'string' alors qu'il est de type '"+typeDetecteFd+"'",path);
				}
				else if (typeDetecteFg != "int" && typeDetecteFg != "string"){
					//System.err.println("L'identificateur '"+fg.getChild(0).getText()+"' (type '"+typeDetecteFd+"') n'est ni de type 'int' ni de type 'string'");
					afficherErreurSemantique(fd.getChild(0), "L'identificateur '"+fg.getChild(0).getText()+"' (type '"+typeDetecteFd+"') n'est ni de type 'int' ni de type 'string'",path);
				}
			}
			else {
				//System.err.println("Aucun type détecté");
				afficherErreurSemantique(fg,"Aucun type détecté",path);
			}
		}
	}

	public static String detectionTypeExp(Tree noeud, TableSymbolesAbs tds,String path) {  // gestion de tous les types possible d'une exp; retourne le type du noeud entre
		String texteNoeud = noeud.getText();
		String typeRes = null;
		switch(texteNoeud) {
		case "IDBEG":
			// cas d'une variable
			if (noeud.getChildCount() == 1)
			{
				Variable v = (Variable)tds.get(noeud.getChild(0).getText());
				if(v==null) {
					//System.err.println("La variable '"+noeud.getChild(0).getText()+"' n'est pas déclarée");
					afficherErreurSemantique(noeud.getChild(0), "La variable '"+noeud.getChild(0).getText()+"' n'est pas déclarée",path);
				}
				else {
					typeRes = tds.getVariableType(noeud.getChild(0).getText()).getName();
				}
			}
			// cas avec 2 fils
			else if (noeud.getChildCount() == 2) {
				System.out.println(noeud.getChild(1).getText());
				//typeRes = tds.getVariableType(noeud.getChild(0).getText()).getName();
				String filsDroit = noeud.getChild(1).getText();
				switch(filsDroit) {

				case "EXPBEG":
					String filsGauche = tds.getArrayType(noeud.getChild(0).getText()).getName();
					String filsGaucheExpbeg = tds.getVariableType(noeud.getChild(1).getChild(0).getText()).getName();
					String filsDroitExpbeg = tds.getVariableType(noeud.getChild(1).getChild(1).getText()).getName();
					if (filsGaucheExpbeg == "int" && filsGauche != null) {
						// TODO : Gerer tous les cas des fils de EXPBEG
						switch(filsDroitExpbeg) {
						case "ASSIGNMENT":
							typeRes = "void";
							break;
						case "BRACBEG":
							typeRes = tds.getArrayType(noeud.getChild(0).getText()).getName();
							break;
						case "IDSTOR":
							typeRes = tds.getVariableType(noeud.getChild(1).getChild(1).getChild(0).getText()).getName();
							break;
						case "EXPSTOR":
							if (tds.getVariableType(noeud.getChild(1).getChild(1).getChild(0).getText()).getName() == "int") {
								typeRes = "int";
							}
							break;
						}
					}
					break;
				case "FIELDEXP":
					//TODO : faire les autres cas 
					//typeRes = tds.getVariableType(noeud.getChild(1).getChild(0).getText()).getName();
					System.err.println("Not yet implemented");
					String fieldExp = noeud.getChild(1).getChild(0).getText();
					switch(fieldExp) {
					case "EXPSTOR":
						break;
					case "IDSTOR":
						break;
					}
					
					break;
				case "RECCREATE":
					typeRes = tds.getRecordType(noeud.getChild(1).getChild(0).getText()).getName();
					break;
				case "ASSIGNMENT":
					typeRes = "void";
					break;
				case "CALLEXP":
					String typeRetour = tds.getFunctionType(noeud.getChild(0).getText()).getName();
					if(typeRetour != null) { // fils gauche est une fonction
						typeRes =  typeRetour;
					}
					break;
				}
			}
			break;

		case "INT":
			typeRes = "int";
			break;

		case "STRING":
			typeRes = "string";
			break;

		case "SEQEXP":
			//Si vide alors typeRes = void
			int nbChild = noeud.getChildCount();
			if(nbChild == 0) {
				typeRes = "void";
			}
			//Sinon typeRes = typeDerniereExp
			else {
				typeRes = detectionTypeExp(noeud.getChild(nbChild-1), tds,path);
			}
			break;

		case "WHILE":
			typeRes = "void";
			break;
		case "NEGATION" :
			typeRes = "int";
			break;
		case "IFTHEN":
			if(noeud.getChildCount() == 2) {	// si pas de else le type de retour est void
				typeRes = "void";
			}
			else {		// si else, le type de retour est le même que celui de les clauses then et else
				typeRes = detectionTypeExp(noeud.getChild(1), tds,path);
			}
			break;
		case "FOR" :
			typeRes = "void";
			break;
		case "LET" :
			typeRes = detectionTypeExp(noeud.getChild(noeud.getChildCount()-1), tds,path);		// let est de meme type que la derniere expression du corps
			if (typeRes == null) {	// si typeRes est null alors le corps de let est vide
				typeRes = "void";	// le type de let est donc void
			}
			break;
		case "break":
			typeRes = "void";
			break;
		case "ASSIGNMENT":
			typeRes = "void";
			break;
		// TODO : faire les autre cas possible de exp
		// TODO : 'nil' ?
		}
		if(texteNoeud.equals("+") || texteNoeud.equals("-") || texteNoeud.equals("*") || texteNoeud.equals("/") || texteNoeud.equals("=")
				|| texteNoeud.equals("<>") || texteNoeud.equals(">") || texteNoeud.equals(">=") || texteNoeud.equals("<")
				|| texteNoeud.equals("<=") || texteNoeud.equals("&") || texteNoeud.equals("|")) {
			typeRes = "int";
		}
		return typeRes;
	}


	public static void afficherTDS(TableSymbolesAbs tds)
	{
		System.out.println(tds.toString());
	}
	
	public static void afficherErreurSemantique(Tree noeudErreur,String texteErreur,String path)
	{
		CommonTree ct=(CommonTree)noeudErreur;
		//on coupe le path
		String[] resSplit=path.split("/");
		
		System.err.println(resSplit[resSplit.length-1]+":("+ct.getLine()+","+ct.getCharPositionInLine()+") : "+texteErreur);
		String line="";
		//On charge la ligne dans le fichier
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			int i=0;
			for(i=0;i<ct.getLine()-1;i++)
			{
				reader.readLine();
			}
			line = reader.readLine();
			System.err.println(line);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//On ajoute une ligne avec un accent circonflexe à ct.getCharPositionInLine()
		String s="";
		for(int j=0;j<ct.getCharPositionInLine();j++)
		{
			if(line.charAt(j)=='\t')
			{
				s+="\t";
			}
			else
			{
				s+=" ";
			}
		}
		s+="^";
		System.err.println(s);
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

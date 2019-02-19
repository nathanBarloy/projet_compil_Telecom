import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

import identificateurs.AliasType;
import identificateurs.ArrayType;
import identificateurs.Identificateur;
import identificateurs.Parametre;
import identificateurs.RecordType;
import identificateurs.Type;
import identificateurs.TypePrimitif;
import identificateurs.Variable;
import identificateurs.fonctions.*;
import tableSymbole.TableSymboles;
import tableSymbole.TableSymbolesAbs;
import tableSymbole.TableSymbolesFor;
import tableSymbole.TableSymbolesFunction;
import tableSymbole.TableSymbolesIf;
import tableSymbole.TableSymbolesLet;
import tableSymbole.TableSymbolesWhile;

public class AnalyseurSemantique {
	
	private static ArrayList<String> listeNomsType;
	
	/**
	 * Chemin du fichier analysé, permet de récupérer la ligne 
	 */
	private String fichierAnalyse;
	
	/**
	 * Arbre abstrait sur lequel on réalise l'analyse sémantique
	 */
	private CommonTree ast;
	
	public AnalyseurSemantique(String path,CommonTree ast) {
		this.fichierAnalyse=path;
		this.ast=ast;
	}
	
	/**
	 * Réalise l'analyse sémantique du programme se trouvant dans le fichier dont le chemin a été passé à la construction
	 * @return Table des symboles du programme contenu dans le fichier fichierAnalyse
	 */
	public TableSymbolesAbs analyser()
	{
		try {
			TableSymbolesAbs blocOrig = new TableSymboles();
			ajouterTypesBase(blocOrig);
			ajouterFonctionBase(blocOrig);
			//System.out.println("///////////////////////////////////////");
			return parcoursArbre(ast, blocOrig);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Cette fonction ajoute les types de bases du langage à la TDS passée en paramètre
	 * @param tds Table des symboles dans laquelle ajouter les types de bases du langage
	 */
	private void ajouterTypesBase(TableSymbolesAbs tds)
	{
		//System.out.println("Ajout des types de bases à la TDS d'origine");
		tds.ajouterTypePrimitif(TypePrimitif.INT);
		tds.ajouterTypePrimitif(TypePrimitif.STRING);
		tds.ajouterTypePrimitif(TypePrimitif.VOID);
	}

	/**
	 * Cette fonction ajoute les fonctions de base du langage à la TDS passée en paramètre
	 * @param tds Table des symboles dans laquelle ajouter les fonctions de bases du langage
	 */
	private void ajouterFonctionBase(TableSymbolesAbs tds)
	{
		//System.out.println("Ajout des fonctions intrinsèques");
		tds.ajouterIdentificateur(new PrintI());
		tds.ajouterIdentificateur(new Print());
		tds.ajouterIdentificateur(new Flush());
		tds.ajouterIdentificateur(new GetChar());
		tds.ajouterIdentificateur(new Ord());
		tds.ajouterIdentificateur(new Chr());
		tds.ajouterIdentificateur(new Size());
		tds.ajouterIdentificateur(new Substring());
		tds.ajouterIdentificateur(new Concat());
		tds.ajouterIdentificateur(new Not());
		tds.ajouterIdentificateur(new Exit());
	}
	
	public void ajouterTypeAlias(TableSymbolesAbs tds,Tree name, Tree aliasedType)
	{
		if(tds.getType(name.getText())==null && tds.getType(aliasedType.getText())!=null)
		{
			ajouterIdentificateur(tds,name, new AliasType(name.getText(),tds.getType(aliasedType.getText()), aliasedType.getText()));
		}
		else
		{
			System.err.println("Tentative de déclaration d'un type existant : "+name);
		}
	}
	
	public void ajouterTypeRecord(TableSymbolesAbs tds, Tree name, Type newType)
	{
		if(tds.getType(name.getText())==null && newType!=null)
		{
			ajouterIdentificateur(tds,name, newType);
		}
		else
		{
			afficherErreurSemantique(name, "Tentative de déclaration d'un type existant : "+name);
		}
	}
	
	public void ajouterTypeArray(TableSymbolesAbs tds,Tree name, Tree sousType)
	{
		if(tds.getType(name.getText())==null)
		{
			ajouterIdentificateur(tds,name, new ArrayType(name.getText(),tds.getType(sousType.getText()),sousType.getText()));
		}
		else
		{
			afficherErreurSemantique(name, "Tentative de déclaration d'un type existant : "+name.getText());
		}
	}
	/**
	 * Cette méthode réalise les controles sémantiques avant l'ajout d'une fonction dans la TDS
	 * @param tds table des symbole dans laquelle on veut ajouter la fonction
	 * @param name noeud contenant le nom de la fonction que l'on veut ajouter
	 * @param retour noeud contenant le nom du type de retour de la fonction
	 * @param tdsFonction table des symbole de la fonction
	 */
	private void ajouterFonctionAvecRetour(TableSymbolesAbs tds, Tree name, Tree retour, TableSymbolesAbs tdsFonction)
	{
		Type t=tds.getType(retour.getText());
		if(t!=null)
		{
			ajouterIdentificateur(tds, name, new FonctionDefinie(name.getText(), t, tdsFonction));
		}
		else
		{
			afficherErreurSemantique(retour, "Type de retour non défini '"+retour.getText()+"' lors de la déclaration de la fonction "+name.getText());
		}
	}
	
	private void ajouterFonctionSansRetour(TableSymbolesAbs tds, Tree name, Tree retour, TableSymbolesAbs tdsFonction)
	{
		Type t=tds.getType("void");
		ajouterIdentificateur(tds, name, new FonctionDefinie(name.getText(), t, tdsFonction));
	}
	
	/**
	 * Cette méthode réalise les controles sémantique avant l'ajout d'un identificateur dans la tds
	 * @param tds table des symboles dans laquelle on veut ajouter l'identificateur
	 * @param name noeud contenant le nom de l'identificateur
	 * @param identificateur identificateur à controler et eventuellement ajouter dans la tds
	 */
	private void ajouterIdentificateur(TableSymbolesAbs tds, Tree name,Identificateur identificateur)
	{
		if(!tds.containsIdentificateur(identificateur.getName()))
		{
			tds.ajouterIdentificateur(identificateur);
		}
		else
		{
			afficherErreurSemantique(name, "Identificateur déjà utilisé : "+name.getText());
		}
	}
	
	/**
	 * Cette méthode réalise les controles sémantiques avant l'ajout d'une variable dans la tds
	 * @param tds table des symboles dans laquelle on veut ajouter la variable
	 * @param name noeud contenant le nom de la variable
	 * @param type noeud contenant le nom du type de la variable
	 */
	private void ajouterVariable(TableSymbolesAbs tds,Tree name,Tree type)
	{
		Type t=tds.getType(type.getText());
		if(t != null)
		{
			ajouterIdentificateur(tds, name, new Variable(name.getText(),t,tds.calculerDeplacement()));
		}
		else
		{
			afficherErreurSemantique(type, "Type non défini '"+type.getText()+"' lors de la déclaration de la variable "+name.getText());
		}
	}
	
	/**
	 * Cette méthode ajoute les parametre d'une fonction dans la tds associe
	 * @param tds table des symboles dans laquelle on veut ajouter les parametres
	 * @param name noeud contenant le nom du parametre
	 * @param type noeud contenant le nom du type du paramtre
	 */
	private void ajouterParametre(TableSymbolesAbs tds,Tree name,Tree type)
	{
		Type t=tds.getType(type.getText());
		if(t != null)
		{
			ajouterIdentificateur(tds, name, new Parametre(name.getText(),t,tds.calculerDeplacement()));
		}
		else
		{
			afficherErreurSemantique(type, "Type non défini '"+type.getText()+"' lors de la déclaration de la variable "+name.getText());
		}
	}
	
	/**
	 * Cetet méthode réalise les controles sémantiques avant l'ajout d'une variable dans la tds lorsque l'on fait de l'inférence de type 
	 * @param tds
	 * @param name
	 * @param nomType
	 */
	private void ajouterVariable(TableSymbolesAbs tds,Tree name,String nomType)
	{
		ajouterIdentificateur(tds, name, new Variable(name.getText(),tds.getType(nomType),tds.calculerDeplacement()));
	}
	/**
	 * Parcours l'AST et réalise l'analyse et la construction de la TDS
	 * @param tree AST à parcourir
	 * @param tableParent table des symbole du bloc parent
	 * @param path chemin du fichier sur lequel l'AST à été construit
	 * @return
	 */
	public TableSymbolesAbs parcoursArbre(Tree tree,TableSymbolesAbs tableParent)
	{
		TableSymbolesAbs nouvelle;
	//	afficherTDS(tableParent);
	//	System.out.println("Nb de fils : "+tree.getChildCount());
		for(int i=0;i<tree.getChildCount();i++)
		{
			//System.out.println("tree.getChild("+i+").getText() : "+tree.getChild(i).getText());
			controleOp(tree.getChild(i), tableParent);
			controleComparateurEgEq(tree.getChild(i),tableParent);
			controleComparateurInfSup(tree.getChild(i), tableParent);
			switch(tree.getChild(i).getText())
			{
				//case "ROOT":
				//cas creant un nouveau bloc
				case "FUNDEC":
					nouvelle = new TableSymbolesFunction(tableParent);
					tableParent.addFils(nouvelle);
					Tree nom = tree.getChild(i).getChild(0);
					if (tree.getChild(i).getChild(tree.getChild(i).getChildCount()-3).getText() == "RETOUR") {
						System.out.println("Nom de la fonction : ");
						// on test si l'avant dernier fils est RETOUR -> donne le type de retour
						for(int j = 1; j < tree.getChild(i).getChildCount()-3; j++) {
							// on recupere tous les parametres de la fonction et on les ajoute a la TDS de la fonction
							ajouterParametre(nouvelle, tree.getChild(i).getChild(j).getChild(0),tree.getChild(i).getChild(j).getChild(1));
							
						}
						Tree retour = tree.getChild(i).getChild(tree.getChild(i).getChildCount()-3).getChild(0);
						ajouterFonctionAvecRetour(tableParent, nom, retour, nouvelle);
					}
					else {	
						for(int j = 1; j < tree.getChild(i).getChildCount()-2; j++) {
							System.out.println("j : "+j+"; noeud : "+tree.getChild(i).getChild(j).getText());
							// on recupere tous les parametres de la fonction et on les ajoute a la TDS de la fonction
							ajouterParametre(nouvelle, tree.getChild(i).getChild(j).getChild(0),tree.getChild(i).getChild(j).getChild(1));
							
						}
						ajouterFonctionSansRetour(tableParent, nom, null, nouvelle);
					}
					parcoursArbre(tree.getChild(i),nouvelle);
					break;
	
				case "LET":
					nouvelle = new TableSymbolesLet(tableParent);
					tableParent.addFils(nouvelle);
					parcoursArbre(tree.getChild(i),nouvelle);
					break;
	
				case "WHILE":
					nouvelle = new TableSymbolesWhile(tableParent);
					tableParent.addFils(nouvelle);
					String testParam = tree.getChild(i).getChild(0).getText();
					String typeDetecteParam = detectionTypeExp(tree.getChild(i).getChild(0), tableParent);
					if( typeDetecteParam != "int") {
						//System.err.println("Le type de "+testParam+" doit être un INT. Type detecte : "+typeDetecteParam);
						afficherErreurSemantique(tree.getChild(i).getChild(0),"Le type de "+testParam+" doit être un INT. Type detecte : "+typeDetecteParam);
					}
					String testReturn = tree.getChild(i).getChild(1).getText();
					String typeDetecteReturn = detectionTypeExp(tree.getChild(i).getChild(1), tableParent);
					if ( typeDetecteReturn != "void") {
						//System.err.println("Le type de "+testReturn+" doit etre void. Type detecte : "+typeDetecteReturn);
						afficherErreurSemantique(tree.getChild(i).getChild(1), "Le type de "+testReturn+" doit etre void. Type detecte : "+typeDetecteReturn);
					}
					parcoursArbre(tree.getChild(i),nouvelle);
					break;
	
				case "FOR":
					//dans les cas précédent, il faut créer une nouvelle table des symboles qui devient
					nouvelle = new TableSymbolesFor(tableParent);
					tableParent.addFils(nouvelle);
					String start=tree.getChild(i).getChild(1).getText();//valeur
					String end=tree.getChild(i).getChild(2).getText();//valeur
					if(start.matches("INT") && end.matches("INT"))
					{ 		//si le debut et la fin du for sont des entiers
						ajouterVariable(nouvelle,tree.getChild(i).getChild(0),"int");
					}
					else {
						afficherErreurSemantique(tree.getChild(i).getChild(0), "Le début et la fin de l'index doit être de type : int");
					}
					String typeCorps = detectionTypeExp(tree.getChild(i).getChild(3), tableParent);
					if(typeCorps != "void") {
						afficherErreurSemantique(tree.getChild(i).getChild(3), "Le corps du FOR doit être de type 'void'");
					}
					parcoursArbre(tree.getChild(i),nouvelle);
					break;
	
				// cas ne creant pas de nouveau blocOrig
	
				case "VARDEC":
					if (tree.getChild(i).getChildCount()==3)//cas où le type est précisé
					{
						//System.out.println(tree.getChild(i).getChild(1).getText());
						Type typeDeclare = tableParent.getType(tree.getChild(i).getChild(1).getText());

						if(typeDeclare == null) {
							afficherErreurSemantique(tree.getChild(i).getChild(1),"Le type ("+tree.getChild(i).getChild(1).getText()+") n'existe pas");
						}
						else {
							String typeDeclareStr = typeDeclare.getName();
						
					//		String dernierNoeud = tree.getChild(i).getChild(2).getText();
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
		
							if (typeDeclareStr != typeDetecte || typeDetecte == null)
							{
								afficherErreurSemantique(tree.getChild(i).getChild(1), "Le type de la declaration ("+typeDeclareStr+") est different du type détecté ("+typeDetecte+").");
							}
							else
							{
								ajouterVariable(tableParent,tree.getChild(i).getChild(0),tree.getChild(i).getChild(1));
							}
						}
					}
					else //s'il n'y a que deux fils, alors il faut detecter le type
					{
						Tree valeur=tree.getChild(i).getChild(1);//valeur
						//System.out.println("valeur : "+valeur);
						String type=detectionTypeExp(valeur,tableParent);
						ajouterVariable(tableParent,tree.getChild(i).getChild(0), type);
					}
					break;
	
				case "TYDEC" :
					Tree tydecTree = tree.getChild(i);
					Tree nomType = tydecTree.getChild(0);
					if (i==0 || !tree.getChild(i-1).getText().equals("TYDEC")) { // si le premier element du bloc de declaration
						int j=0;
						listeNomsType = new ArrayList<String>();
						while (i+j<tree.getChildCount() && tree.getChild(i+j).getText().equals("TYDEC")) { //on parcours les noeuds suivant pour connaitre la taille du bloc de déclaration
							listeNomsType.add(tree.getChild(i+j).getChild(0).getText());
							j++;
						}
						// listeNomsType contient la liste des noms de type qu'on veut déclarer dans ce bloc
					}
	
					if (tableParent.get(nomType.getText())!=null) { // si le nom existe déjà
						afficherErreurSemantique(tydecTree.getChild(0), "Le nom '"+nomType+"' à déjà été pris, impossible de créer le type");
					} else { // si le nom est valable
						switch(tydecTree.getChild(1).getText()) {
						case "RECTY" : // on défini un ensemble
							RecordType newType = new RecordType(nomType.getText());
							for (int j=0; j<tydecTree.getChildCount(); j++) {
								Tree decTree = tydecTree.getChild(1).getChild(j);
								String nomComponent = decTree.getChild(0).getText();
								String nomSousType = decTree.getChild(1).getText();
	
								Type sousType = tableParent.getType(nomSousType);
								if (sousType==null && !listeNomsType.contains(nomSousType)) {
									afficherErreurSemantique(decTree.getChild(1), "Le nom '"+ nomSousType+"' n'existe pas ou ne représente pas un type");
								} else {
									newType.addComponent(nomComponent, sousType);
								}
							}
							ajouterTypeRecord(tableParent,nomType, newType);
							break;
							
						case "ARRTY" : // on défini une liste
							Tree sousType = tydecTree.getChild(1).getChild(0);
							if (tableParent.getType(sousType.getText())==null && !listeNomsType.contains(sousType.getText())) { // si le type que l'on veut utiliser n'existe pas ou n'est pas un type
								//System.err.println("Le nom '"+ sousType+"' n'existe pas ou ne représente pas un type");
								afficherErreurSemantique(sousType, "Le nom '"+ sousType.getText()+"' n'existe pas ou ne représente pas un type");
							} else { // si le nom entré est valable
								ajouterTypeArray(tableParent,nomType, sousType);
							}
							break;
						default : // on défini un alias
							Tree aliased = tydecTree.getChild(1);
							if (tableParent.getType(aliased.getText())==null && !listeNomsType.contains(aliased.getText())) { // si le type que l'on veut utiliser n'existe pas ou n'est pas un type
								afficherErreurSemantique(tydecTree.getChild(1), "Le nom '"+ aliased+"' n'existe pas ou ne représente pas un type");
							} else { // si le nom entré est valable
								ajouterTypeAlias(tableParent,nomType, aliased);
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
					//System.out.println("Cas idbeg : "+tree.getChild(i).getChildCount());
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
						if(tableParent.get(texte) == null)
						{
							afficherErreurSemantique(tree.getChild(i).getChild(0), "Tentative d'affectation avec une variable non déclarée : '"+texte+"'.");
						}
	
					}
					break;
				case "NEGATION" :
					String typeDetecte = detectionTypeExp(tree.getChild(i).getChild(0),tableParent);
					if (typeDetecte != "int") {
						afficherErreurSemantique(tree.getChild(i).getChild(0), "Le type attendu de '"+tree.getChild(i).getChild(0).getChild(0).getText()+"' est 'int' (actuellement de type '"+typeDetecte+"')");
					}
					break;
				case "IFTHEN" :
					String typeCondition = detectionTypeExp(tree.getChild(i).getChild(0),tableParent);
					String typeThen = detectionTypeExp(tree.getChild(i).getChild(1), tableParent);
					int nbFils = tree.getChild(i).getChildCount();
					if (typeCondition !="int") {		// controle semantique sur la condtion du if
						afficherErreurSemantique(tree.getChild(i).getChild(0), "La condition du IF doit être de type 'int' (actuellement : '"+typeCondition+"')");
					}
					if(nbFils == 2) {		// si pas de ELSE le type de THEN doit être void
						if(typeThen != "void") {
							afficherErreurSemantique(tree.getChild(i).getChild(0), "La clause THEN doit être de type 'void' (actuellement :'"+typeThen+"')");
						}
					}
					else if (nbFils == 3) {		// si ELSE les types doivent correspondre
						String typeElse = detectionTypeExp(tree.getChild(i).getChild(2),tableParent);
						if (typeThen != typeElse) {
							afficherErreurSemantique(tree.getChild(i).getChild(2), "Les clauses THEN et ELSE doivent être de même type");
						}
					}
					nouvelle = new TableSymbolesIf(tableParent);
					tableParent.addFils(nouvelle);
					parcoursArbre(tree.getChild(i),nouvelle);
					break;
				case "break" :
					if(!tableParent.isBreakable()) {
						afficherErreurSemantique(tree.getChild(i), "Le mot-clé 'break' ne peut être utilisé que dans un bloc 'while' ou 'for'");
					}
					break;
				default:
					parcoursArbre(tree.getChild(i),tableParent);//si on est pas dans les cas précédents,on crée une nouvelle table
					break;
			}

		}
		return tableParent;

	}
	
	/**
	 * Affiche une erreur bien formatée sur la sortie d'erreur
	 * @param noeudErreur noeud de l'AST provoquant l'erreur sémantique
	 * @param texteErreur texte décrivant l'erreur sémantique rencontrée
	 */
	public void afficherErreurSemantique(Tree noeudErreur,String texteErreur)
	{
		CommonTree ct=(CommonTree)noeudErreur;
		//on coupe le path
		String[] resSplit=fichierAnalyse.split("/");
		System.err.println(resSplit[resSplit.length-1]+":("+ct.getLine()+","+ct.getCharPositionInLine()+") : "+texteErreur);
		String line="";
		//On charge la ligne dans le fichier
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fichierAnalyse));
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
		//On ajoute une ligne avec un accent circonflexe à ct.getCharPositionInLine() pour pointer l'erreur
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
	
	public String detectionTypeExp(Tree noeud, TableSymbolesAbs tds) {  // gestion de tous les types possible d'une exp; retourne le type du noeud d'entree
		String texteNoeud = noeud.getText();
		String typeRes = null;
		switch(texteNoeud) {
		case "IDBEG":
			// cas d'une variable
			if (noeud.getChildCount() == 1)
			{
				Variable v = (Variable)tds.get(noeud.getChild(0).getText());
				if(v==null) {
					afficherErreurSemantique(noeud.getChild(0), "La variable '"+noeud.getChild(0).getText()+"' n'est pas déclarée");
				}
				else {
					typeRes = tds.getVariableType(noeud.getChild(0).getText()).getName();
				}
			}
			// cas avec 2 fils
			else if (noeud.getChildCount() == 2) {
				//System.out.println(noeud.getChild(1).getText());
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
				typeRes = detectionTypeExp(noeud.getChild(nbChild-1), tds);
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
				typeRes = detectionTypeExp(noeud.getChild(1), tds);
			}
			break;
		case "FOR" :
			typeRes = "void";
			break;
		case "LET" :
			typeRes = detectionTypeExp(noeud.getChild(noeud.getChildCount()-1), tds);		// let est de meme type que la derniere expression du corps
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
	
	public void controleComparateurInfSup(Tree tree, TableSymbolesAbs tds) { // verifie que les deux operandes des comparateurs < <= > >= sont de même type et de type int ou string
		String root = tree.getText();
		if (root.equals("<") || root.equals("<=") || root.equals(">") || root.equals(">=")) {
			Tree fg = tree.getChild(0);
			Tree fd = tree.getChild(1);
			String typeDetecteFg = detectionTypeExp(fg, tds);
			String typeDetecteFd = detectionTypeExp(fd, tds);
			if (typeDetecteFd != null && typeDetecteFg != null) {
				if(typeDetecteFg == "int" && typeDetecteFd != "int") {
					//System.err.println("Le type attendu de l'identificateur '"+fd.getChild(0).getText()+"' est 'int' alors qu'il est de type '"+typeDetecteFd+"'");
					afficherErreurSemantique(fd.getChild(0), "Le type attendu de l'identificateur '"+fd.getChild(0).getText()+"' est 'int' alors qu'il est de type '"+typeDetecteFd+"'");
				}
				else if(typeDetecteFg == "string" && typeDetecteFd != "string") {
					//System.err.println("Le type attendu de l'identificateur '"+fd.getChild(0).getText()+"' est 'string' alors qu'il est de type '"+typeDetecteFd+"'");
					afficherErreurSemantique(fd.getChild(0), "Le type attendu de l'identificateur '"+fd.getChild(0).getText()+"' est 'string' alors qu'il est de type '"+typeDetecteFd+"'");
				}
				else if (typeDetecteFg != "int" && typeDetecteFg != "string"){
					//System.err.println("L'identificateur '"+fg.getChild(0).getText()+"' (type '"+typeDetecteFd+"') n'est ni de type 'int' ni de type 'string'");
					afficherErreurSemantique(fd.getChild(0), "L'identificateur '"+fg.getChild(0).getText()+"' (type '"+typeDetecteFd+"') n'est ni de type 'int' ni de type 'string'");
				}
			}
			else {
				//System.err.println("Aucun type détecté");
				afficherErreurSemantique(fg,"Aucun type détecté");
			}
		}
	}
	
	public void controleComparateurEgEq(Tree tree, TableSymbolesAbs tds) { 	// verifie que les deux operandes des comparateurs = et <> sont de meme type
		String root = tree.getText();
		if(root.equals("=") || root.equals("<>")) {	// si le noeud est l'un des deux operateurs
			Tree fg = tree.getChild(0);
			Tree fd = tree.getChild(1);
			String typeDetecteFg = detectionTypeExp(fg, tds);
			String typeDetecteFd = detectionTypeExp(fd, tds);
			if (typeDetecteFd != null && typeDetecteFg != null) {
				if (!typeDetecteFg.equals(typeDetecteFd)) {
					//System.err.println("L'identificateur '"+fg.getChild(0)+"' (type '"+typeDetecteFg+"') n'est pas de même type que '"+fd.getChild(0)+"' (type '"+typeDetecteFd+"')");
					afficherErreurSemantique(fd.getChild(0), "L'identificateur '"+fg.getChild(0)+"' (type '"+typeDetecteFg+"') n'est pas de même type que '"+fd.getChild(0)+"' (type '"+typeDetecteFd+"')");
				}
			}
			else {
				//System.err.println("Aucun type détecté");
				afficherErreurSemantique(fd.getChild(0), "Aucun type détecté");
			}
		}

	}
	
	public void controleOp(Tree tree, TableSymbolesAbs tds) {		// controle semantique sur les operateurs ayant pour operandes des type int
		String root = tree.getText();
		if(root.equals("+") || root.equals("-") || root.equals("*") || root.equals("/") ||	 root.equals("&") || root.equals("|")){ // si on est dans une operation ou les opérandes sont des int
			// cas ou le fils gauche n'est pas un entier ou seqexp
			String fg = tree.getChild(0).getText();
			String fd = tree.getChild(1).getText();
			if (!fg.matches("INT") && fg != "SEQEXP"){
				String typeFg = detectionTypeExp(tree.getChild(0), tds);
				if(typeFg != null) {
					if(typeFg != "int") {
						//System.err.println("La variable '"+tree.getChild(0).getChild(0).getText()+"' n'est pas de type int");
						afficherErreurSemantique(tree.getChild(0), "La variable '"+tree.getChild(0).getChild(0).getText()+"' n'est pas de type int");
					}
				}
				// cas ou le fils gauche n'est pas une operation
				else if(!(fg.equals("+") || fg.equals("-") || fg.equals("*") || fg.equals("/") || fg.equals("=") || fg.equals("<>") || fg.equals("&") || fg.equals("|"))) {
					//System.err.println("L'opérande "+fg+" n'est pas un int");
					afficherErreurSemantique(tree.getChild(0), "L'opérande "+fg+" n'est pas un int");
				}
			}
			// cas ou le fils droit n'est pas un entier ou seqexp
			if (!fd.matches("INT") && fd != "SEQEXP"){
				String typeFd = detectionTypeExp(tree.getChild(1), tds);
				if(typeFd != null) {
					if(typeFd != "int") {
						//System.err.println("La variable '"+tree.getChild(1).getChild(0).getText()+"' n'est pas de type int");
						afficherErreurSemantique(tree.getChild(1), "La variable '"+tree.getChild(1).getChild(0).getText()+"' n'est pas de type int");
					}
				}

				// cas ou le fils droit n'est pas une operation
				else if(!(fd.equals("+") || fd.equals("-") || fd.equals("*") || fd.equals("/") || fd.equals("=") || fd.equals("<>") || fd.equals("&") || fd.equals("|"))) {
					//System.err.println("L'opérande "+fd+" n'est pas de type int");
					afficherErreurSemantique(tree.getChild(1), "L'opérande "+fd+" n'est pas de type int");
				}
			}
			if(fg == "SEQEXP") {
				if(tree.getChild(0).getChildCount() == 0) { // cas ou SEQEXP est de type void
					//System.err.println("La sequence d'expressions est vide");
					afficherErreurSemantique(tree.getChild(0), "La sequence d'expressions est vide");
				}
			}
			if(fd == "SEQEXP") {
				if(tree.getChild(1).getChildCount() == 0) { // cas ou SEQEXP est de type void
					//System.err.println("La sequence d'expressions est vide");
					afficherErreurSemantique(tree.getChild(1), "La sequence d'expressions est vide");
				}
			}
		}
	}
}

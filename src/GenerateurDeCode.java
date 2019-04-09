import java.io.FileWriter;
import java.io.Writer;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import identificateurs.Variable;
import identificateurs.fonctions.Exit;
import identificateurs.fonctions.Fonction;
import identificateurs.fonctions.Print;
import tableSymbole.TableSymbolesAbs;

public class GenerateurDeCode {
	
	private final static String COMMENTAIRE_CHAR = "//";
	
	private final static String REGISTREBOUCLEFOR = "R7";
	private final static String REGISTRERETOUREXPRESSION = "R1";
	private TableSymbolesAbs tds;
	private CommonTree ast;
	/**
	 * indique la TDS dans laquelle le generateur se trouve acutellement
	 */
	private TableSymbolesAbs courante;
	private int numString;
	/**
	 * Ce compteur permet de personnaliser les étiquettes de boucle de remontée de chaînage
	 */
	private int nbRemontees;
	private StringBuilder codeAssembleur;
	private StringBuilder codeFonctions;
	private StringBuilder builderActuel;
	private boolean appelFonction;
	private boolean decFonction;
	
	public GenerateurDeCode(TableSymbolesAbs tds, CommonTree ast) {
		this.tds = tds;
		this.courante = this.tds;
		this.ast = ast;
		this.numString=0;
		this.nbRemontees=0;
		this.codeAssembleur=new StringBuilder();
		this.codeFonctions=new StringBuilder();
		builderActuel=codeAssembleur;
		this.appelFonction = false;
		this.decFonction = false;
	}
	
	/**
	 * Génère le code assembleur à l'aide de la TDS et de l'AST
	 * @return chaine de caractère contenant le code assembleur du programme
	 */
	public String genererCode(String nomFichier)
	{

		codeAssembleur.append("LOADA\tEQU\t0xF010\n"); // adresse mémoire ou le code est chargé
		codeAssembleur.append("EXIT_EXC\tEQU\t64\n"); // n° d'exception de EXIT
		codeAssembleur.append("READ_EXC\tEQU\t65\n"); 		// n° d'exception de READ (lit 1 ligne)
		codeAssembleur.append("WRITE_EXC\tEQU\t66\n"); // n° d'exception de WRITE (affiche 1 ligne)
		codeAssembleur.append("STACK_ADRS\tEQU\t0x1000\n"); // base de pile en 1000h (par exemple)
		codeAssembleur.append("LOAD_ADRS\tEQU\t0xF000\n");// adresse de chargement de l'exécutable
		codeAssembleur.append("NIL\tEQU\t0\n"); // fin de liste: contenu initial de BP
		codeAssembleur.append("NUL\tEQU\t0\n"); // pointeur nul
		codeAssembleur.append("NULL\tEQU\t0\n"); // caractere null, fin de chaine de caracteres
		// ces alias permettront de changer les réels registres utilisés
		builderActuel.append("SP\tEQU R15\n"); // alias pour R15, pointeur de pile
		builderActuel.append("WR\tEQU R14\n"); // Work Register (registre de travail)
		builderActuel.append("BP\tEQU R13\n"); // frame Base Pointer (pointage environnement)
		builderActuel.append("ORG\tLOADA\n"); // charge le code
		builderActuel.append("START\tLOADA\n"); // lance le code
		 // R12, R11 réservés
		// R0 pour résultat de fonction
		// R1 ... R10 disponibles
		builderActuel.append("LDW SP, #STACK_ADRS\n"); // charge SP avec STACK_ADRS
		builderActuel.append("\n");//On saute une ligne après avoir défini les alias
		
		builderActuel.append("main_\n");
		builderActuel.append("\tLDW SP, #STACK_ADRS\n"); // charge SP avec STACK_ADRS
		builderActuel.append("\tLDQ NIL, WR\n"); // charge BP avec NIL=0
		builderActuel.append("\tSTW WR, -(SP) //On empile le dynamique\n"); // empile le contenu du registre BP
		builderActuel.append("\tLDW BP, SP\n"); // charge contenu SP ds BP
		builderActuel.append("\tSTW WR, -(SP) //On empile le statique\n"); // empile le contenu du registre BP
		
		
		parcourirArbre(ast);
		
		//TODO ce code termine le main, il doit être ajouté avant le code des fonctions
		builderActuel.append("\tLDW SP, BP\n"); // abandon infos locales
		builderActuel.append("\tLDW BP, (SP)+\n"); // charge BP avec ancien BP
		builderActuel.append("\tTRP #EXIT_EXC\n"); // EXIT: arrête le programme*/
		
		//TODO on ajoute le code des fonctions de base
		codeFonctions.append(new Print().genererCode());
		codeFonctions.append(new Exit().genererCode());
		
		try {
			Writer writer=new FileWriter(nomFichier);
			writer.write(codeAssembleur.toString()+codeFonctions.toString());
			writer.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return codeAssembleur.toString()+codeFonctions.toString();
	}
	
	private void parcourirArbre(Tree tree)
	{
		for(int i=0;i<tree.getChildCount();i++)
		{
			//System.out.println("tree.getChild("+i+").getText() : "+tree.getChild(i).getText());
			if(decFonction && (i == tree.getChildCount()-1))
			{
				traiterExpression(tree.getChild(i));
			}
			else {
			
				switchNoeud(tree.getChild(i));
			}
		}
	}
	
	private void switchNoeud(Tree tree)
	{
		System.err.println(tree.getText());
		switch(tree.getText())
		{
		// gérer tous les cas (token) existant dans l'AST 
		
		// /!\ Attention il faut voir ou le code se rajoute par rapport au parcours de l'arbre 
		
		case "FUNDEC":
			this.decFonction = true;
			Fonction f = (Fonction)courante.get(tree.getChild(0).getText());
			courante = f.getTdsFonction();
			builderActuel=codeFonctions;
			builderActuel.append( f.debutFonction());
			if(isLetOrSeqexp(tree.getChild(tree.getChildCount()-1)))
			{
				System.err.println("parcours arbre "+tree.getChild(tree.getChildCount()-1));
				parcourirArbre(tree.getChild(tree.getChildCount()-1));
			}
			else
			{
				System.err.println("switch noeud "+tree.getChild(tree.getChildCount()-1));

				switchNoeud(tree.getChild(tree.getChildCount()-1));
			}
			//TODO generer le code du corps de la fonction
			builderActuel.append( f.finFonction());
			builderActuel=codeAssembleur;
			courante=courante.getParent();
			this.decFonction = false;
			break;
		case "LET":
			this.courante.incCompteurTDS();
			this.courante = this.courante.getFils(this.courante.getCompteurTDS()-1);
			parcourirArbre(tree);
			// TODO
			break;
		case "WHILE":
			this.courante.incCompteurTDS();
			this.courante = this.courante.getFils(this.courante.getCompteurTDS()-1);
			builderActuel.append(courante.debutBloc()+"\n");
			builderActuel.append("\tCMP ");
		//	builderActuel.append("\t");	
			traiterCondition(tree.getChild(0));
			builderActuel.append(" "+courante.debutBloc());
			builderActuel.append("\n");
			//debut while
			builderActuel.append(courante.debutBloc()+"\n");
			parcourirArbre(tree.getChild(1));
			builderActuel.append(courante.finBloc()+"\n");
			//fin du while
			this.courante=courante.getParent();
			// TODO
			break;
		case "FOR":
			this.courante.incCompteurTDS();
			this.courante = this.courante.getFils(this.courante.getCompteurTDS()-1);
			//debut for
			//on déclare la variable
			tree.getChild(0).getText();
			//on stocke la valeur 
			
			//on met la valeur de debut de boucle dedans
			
			//on empile registre de boucle avant de l'utiliser 
			builderActuel.append("\tADQ -2,SP "+COMMENTAIRE_CHAR+"On décale le sommet de pile de la taille du registre de boucle\n");
			builderActuel .append( "\tSTW "+REGISTREBOUCLEFOR+", (SP)"+COMMENTAIRE_CHAR+"On empile le contenu du registre de boucle\n");
			//On met la valeur de fin de boucle dans R7
			switchNoeud(tree.getChild(2));//va mettre la valeur de fin de boucle dans REGISTRERETOUR
			builderActuel.append("\tLDW "+REGISTREBOUCLEFOR+",R1\n");
			builderActuel.append(courante.debutBloc()+"\n");
			switchNoeud(tree.getChild(tree.getChildCount()-1));
			//on incrémente l'indice de boucle
			builderActuel.append("\tADQ 1,"+REGISTREBOUCLEFOR+"\n");
			//on met l'indice de boucle dans un registre
			
			//on compare l'indice de boucle avec la valeur max de boucle
			builderActuel.append("\tCMP R1,"+REGISTREBOUCLEFOR+"//On compare le registre de boucle et l'indice de boucle\n");//R1 contient l'indice de boucle
			builderActuel.append("\tBNE "+courante.debutBloc()+"-$-2\n");
			
			
			//fin for
			//on restaure le registre de la boucle
			builderActuel.append("\tLDW "+REGISTREBOUCLEFOR+", (SP)\n//On restaure le registre de boucle");
			builderActuel.append("\tADQ 2,SP\n");
			this.courante=courante.getParent();
			// TODO
			break;
		case "VARDEC":

			//TODO
			Variable var = (Variable)courante.get(tree.getChild(0).getText());
			builderActuel.append( "\t"+COMMENTAIRE_CHAR+"On déclare "+var.getName()+"\n");
			//On évalue l'expression à assigner
			traiterExpression(tree.getChild(1));
			//On range le résulat en sommet de pile
			builderActuel.append("\tADQ -"+var.getType().getTaille()+",SP "+COMMENTAIRE_CHAR+"On décale le sommet de pile de la taille du type de "+var.getName()+"("+var.getType().getName()+")\n");
			builderActuel .append( "\tSTW R1, (SP)"+COMMENTAIRE_CHAR+"On empile le contenu de R1\n");
			break;
		case "TYDEC" :
			//TODO
			// pas de parcours normalement
			break;
		case "IDBEG":
			// pas de parcours normalement
			if (tree.getChildCount()==2)
			{
				//on évalue l'expression (fils droit)
				switch(tree.getChild(1).getText())
				{
					case "EXPBEG":
						//TODO
						break;
					case "FIELDEXP":
						// TODO
						break;
					case "RECCREATE":
						//TODO
						break;
					case "CALLEXP" :
						//TODO
						this.appelFonction = true;
						Tree noeudCallExp = tree.getChild(1);
						//System.err.println(noeudCallExp.getText());
						//on empile les paramètres
						for(int param=0;param<noeudCallExp.getChildCount();param++)
						{
							builderActuel.append("\t"+COMMENTAIRE_CHAR+"On empile la valeur de "+noeudCallExp.getChild(param).getChild(0).getText()+"\n");
							traiterExpression(noeudCallExp.getChild(param));
							//On empile le contenu de R1
							//On range le résulat en sommet de pile
							builderActuel.append("\tADQ -2,SP "+COMMENTAIRE_CHAR+"On décale le sommet de pile\n");
							builderActuel .append( "\tSTW R1, (SP)"+COMMENTAIRE_CHAR+"On empile le contenu de R1\n");
						}
						//calculer chaînage STAT
						Fonction fonc = (Fonction)courante.get(tree.getChild(0).getText());
						int nx = courante.getNiveau();
						int ny = fonc.getTdsFonction().getNiveau();
						int chainageARemonter=nx-ny+1;
						builderActuel.append("\t//On calcule le chainage statique de l'appelé\n");
						builderActuel.append("\tLDW WR,BP\n");
						if(chainageARemonter>0)
						{
							builderActuel.append("\tLDW R10,#"+chainageARemonter+"\n");
							builderActuel.append("BOU"+nbRemontees+"\tADQ -2,WR\n");
							builderActuel.append("\tLDW WR,(WR)\n");
							builderActuel.append("\tADQ -1,R10\n");
							builderActuel.append("\tBNE BOU"+nbRemontees+"-$-2\n");
						}
						
						nbRemontees++;
						
						builderActuel.append("\tJSR @"+fonc.nomCodeFonction());
						int nbParam=noeudCallExp.getChildCount();
						//on dépile les paramètres
						builderActuel.append("\tADQ "+(nbParam*2)+",SP "+COMMENTAIRE_CHAR+"On dépile les paramètres\n");
						this.appelFonction = false;
						break;
					case "ASSIGNMENT":	
						// TODO
						
						Tree noeudAssignment = tree.getChild(1);
						//System.err.println(noeudAssignment.getText());
						traiterExpression(noeudAssignment.getChild(0));
						parcourirArbre(noeudAssignment);
						//On récupère enfin l'adresse de la variable dans laquelle on veut ranger la valeur
						Variable v = (Variable)courante.get(tree.getChild(0).getText());
						recupererAdresseVariable(v);
						//On range le résulat à l'adresse que l'on vient de récupérer
						builderActuel.append( "\tSTW R1, (R2) "+COMMENTAIRE_CHAR+"On stocke le contenu de R1 à l'adresse contenue dans R2\n");
						break;
				}
			}
			break;
		case "NEGATION" :
			//TODO
			// pas de parcours normalement

			break;
		case "IFTHEN" :
			this.courante.incCompteurTDS();
			builderActuel.append(courante.getFils(this.courante.getCompteurTDS()-1).debutBloc()+"\n");
			comparaison(tree.getChild(0),false,true);
			builderActuel.append("\tCMP R1, R3\n");
			builderActuel.append("\t");	
			traiterConditionInverse(tree.getChild(0));
			this.courante = this.courante.getFils(this.courante.getCompteurTDS()-1);
			builderActuel.append(" else"+courante.debutBloc()+"-$-2\n");
			boolean elsePresent = tree.getChildCount()==3;
			builderActuel.append("then"+courante.debutBloc()+"\n");
			// modifier la ligne suivante : ne foncitonne pas
			if(isLetOrSeqexp(tree.getChild(1)))
			{
				parcourirArbre(tree.getChild(1));
			}
			else
			{
				traiterExpression(tree.getChild(1));
			}
			builderActuel.append("\tJEA @"+courante.finBloc()+"\n");
			if(elsePresent) {
				// gerer les sauts conditionnel
				builderActuel.append("else"+courante.debutBloc()+"\n");
				if(isLetOrSeqexp(tree.getChild(2)))
				{
					parcourirArbre(tree.getChild(2));
				}
				else
				{
					traiterExpression(tree.getChild(2));
				}
			}
			builderActuel.append(courante.finBloc()+"\n");
			courante=courante.getParent();
			break;
		case "break" :
			// TODO
			// pas de parcours normalement
			break;
		default:
			parcourirArbre(tree);//si on est pas dans les cas précédents,on crée une nouvelle table
			break;
		}
	}
	
	private void recupererAdresseVariable(Variable v)
	{
		/*Rappels:
			Nx:n° d’imbrication du bloc courant
			Ny:n° d'imbrication du bloc de déclaration
			Nz:n° d’imbrication de la variable
		« remonter » (Nx-Ny) chainage statiques
			MOVE #(Nx-Ny),D0
			MOVE A0,A2
		BOU	MOVE (depl_stat,A2),A2
			SUB #1,D0
			BNE BOU //branch if not equal
			LEA (depl,A2),A1*/
		int chainageARemonter=nombreDeChainageARemonter(v);
		builderActuel.append( "\t"+COMMENTAIRE_CHAR+"On recherche l'adresse de "+v.getName()+"\n");
		//on a pas de remontée à faire, on est dans le bloc local
		builderActuel.append("\tLDW WR, BP\n"); // WR = BP
		if(chainageARemonter>0)
		{
			builderActuel.append( "\tLDW R10,#("+chainageARemonter+")\n");//on met le nombre de chainage à remonter dans R10
			builderActuel.append( "BOU"+nbRemontees+"\tADQ -2,WR\n");//-2 correspond toujours à la taille d'une adresse
			builderActuel.append("\tLDW WR,(WR)\n");
			builderActuel.append( "\tADQ -1,R10\n");//on retire 1 à la valeur dans R10
			builderActuel.append( "\tBNE BOU"+nbRemontees+"-$-2\n");//si R10 n'est pas égal à 0, on retourne à BOU
			nbRemontees++;
		}
		else
		{
			
		}
		if(v.getDeplacement()>=0)
		{
			builderActuel.append("\tADQ -"+(v.getDeplacement()+4)+", WR\n"); // WR pointe sur la variable locale (+4 pour passer DYN et STAT)
		}
		else
		{
			builderActuel.append("\tADQ "+(-v.getDeplacement()+2)+", WR\n"); // WR pointe sur le paramètre (
		}
		
		builderActuel.append("\tLDW R2,WR\n");//on met le contenu de WR dans R2
	}
	
	/**
	 * Cette fonction retourne le nombre de chainage à remonter pour retrouver la variable passée en paramètre 
	 * @param v
	 * @return
	 */
	private int nombreDeChainageARemonter(Variable v)
	{
		if(appelFonction || decFonction) {
			int nx = courante.getNiveau();
			int ny = courante.getNiveauDeclaration(v);
			return nx-ny;
		}
		return 0;
		
	}
	
	/* Charge dans les registre R1 et R3 avec les condition (ou 0) avant un CMP. Le boolean permet d'indiquer si on doit charger dans R3, unique indique si on doit mettre 0 dans R3 */
	private void comparaison(Tree noeud, boolean deuxieme, boolean unique)
	{
		if(noeud==null)
		{
			builderActuel.append("\tLDW R3, #0\t"+COMMENTAIRE_CHAR+"On charge 0 dans R3\n");
		}
		else
		{
			switch(noeud.getText())
			{
				case "INT" :
					if(!deuxieme)
					{
						builderActuel.append("\tLDW R1, #"+noeud.getChild(0)+"\t"+COMMENTAIRE_CHAR+" On charge la valeur dans R1\n");
						if(unique)
						{
							comparaison(null,false,false);
						}
					}
					else
					{
						builderActuel.append("\tLDW R3, #"+noeud.getChild(0)+"\t"+COMMENTAIRE_CHAR+" On charge la valeur dans R1\n");
					}
					break;
				case "IDBEG" :
					if(noeud.getChildCount()==1)
					{
						//on récupère l'adresse de la variable du noeud fils
						Variable v = (Variable)courante.get(noeud.getChild(0).getText());
						//on récupère l'adresse de la variable
						recupererAdresseVariable(v);
						//on copie le contenu de R2 dans R1
						if(!deuxieme) {
							builderActuel.append("\tLDW R1, (R2)\n");
							if(unique)
							{
								comparaison(null,false,false);
							}
						}
						else
						{
							builderActuel.append("\tLDW R3, (R2)\n");
						}
					}
					break;
				case "=":
				case "<>":
				case  ">":
				case  "<":
				case  ">=":
				case  "<=":
					comparaison(noeud.getChild(0),false,false);
					comparaison(noeud.getChild(1),true,false);
					break;
				
			}
		}
		
	}
	
	private void traiterCondition(Tree noeud)
	{
		switch(noeud.getText())
		{
		case "=":
		case "<>":
		case  ">":
		case  "<":
		case  ">=":
		case  "<=":
			//on récupère l'opérande gauche et l'operande droite
			/*Tree fg=noeud.getChild(0);
			traiterCondition(fg);
			builderActuel.append(", ");
			Tree fd=noeud.getChild(1);
			traiterCondition(fd);*/
			switch(noeud.getText())
			{
			case "=":
				builderActuel.append("BEQ");
				break;
			case "<>":
				builderActuel.append("BNE");
				break;
			case  ">":
				builderActuel.append("BGT");
				break;
			case  "<":
				builderActuel.append("BLW");
				break;
			case  ">=":
				builderActuel.append("BGE");
				break;
			case  "<=":
				builderActuel.append("BLE");
				break;
			}
			break;
			case  "&":
				
			case  "|":
				
			break;
			
			case "NEGATION":
				// TODO 
				/* Ne fonctionne pas
				builderActuel.append("NOT ");
				traiterCondition(noeud.getChild(0)); */ 
				break;
			case "INT":
			case "IDBEG":
				builderActuel.append("BNE");
				break;
		}

		
	}
	
	
	private void traiterConditionInverse(Tree noeud)
	{
		switch(noeud.getText())
		{
		case "=":
		case "<>":
		case  ">":
		case  "<":
		case  ">=":
		case  "<=":
			//on récupère l'opérande gauche et l'operande droite
		/*	Tree fg=noeud.getChild(0);
			traiterCondition(fg);
			builderActuel.append(", ");
			Tree fd=noeud.getChild(1);
			traiterCondition(fd);
			builderActuel.append("\n\t");*/
			switch(noeud.getText())
			{
			case "=":
				builderActuel.append("BNE");
				break;
			case "<>":
				builderActuel.append("BEQ");
				break;
			case  ">":
				builderActuel.append("BLE");
				break;
			case  "<":
				builderActuel.append("BGE");
				break;
			case  ">=":
				builderActuel.append("BLW");
				break;
			case  "<=":
				builderActuel.append("BGT");
				break;
			}
		break;
		case  "&":
				
		case  "|":
				
			break;
			
		case "NEGATION":
				// TODO 
				/* Ne fonctionne pas
				builderActuel.append("NOT ");
				traiterCondition(noeud.getChild(0)); */ 
				break;
		case "INT":
		case "IDBEG":
				builderActuel.append("BEQ");
				break;
		}
	}
	
	
	
	
	/**
	 * Permet de générer le code qui évalue l'expression à droite de := lors de ASSIGNMENT ou VARDEC
	 * @param noeud noeud à partir du quel on évalue l'expression
	 * @return code assembleur correspondant
	 */
	private void traiterExpression(Tree noeud)
	{
		//TODO
		switch(noeud.getText())
		{
		case "+":
		case "-":
		case "*":
		case "/":
			//on traite la partie gauche puis la partie droite
			traiterExpression(noeud.getChild(0));
			//on empile R1
			builderActuel.append("\tADQ -2,SP\n");
			builderActuel .append( "\tSTW R1, (SP)"+COMMENTAIRE_CHAR+"On empile le contenu de R1\n");
			traiterExpression(noeud.getChild(1));
			//on empile R1
			builderActuel.append("\tADQ -2,SP\n");
			builderActuel .append( "\tSTW R1, (SP)"+COMMENTAIRE_CHAR+"On empile le contenu de R1\n");
			//on fait l'opération sur les deux elements en sommet de pile
			//On dépile dans R1 et R2
			builderActuel.append("\tLDW R1,(SP)\n"); // charge le registre R avec le sommet de pile
			builderActuel.append("\tADQ 2, SP\n"); // incrémente le pointeur de pile SP
			builderActuel.append("\tLDW R2,(SP)\n"); // charge le registre R avec le sommet de pile
			builderActuel.append("\tADQ 2, SP\n"); // incrémente le pointeur de pile SP
			//on fait l'operation
			switch(noeud.getText())
			{
			case "+":
				builderActuel.append("\tADD R1,R2,R1 "+COMMENTAIRE_CHAR+"Somme de R1 et R2, résultat dans R1\n");
				break;
			case "-":
				builderActuel.append("\tSUB R1,R2,R1"+COMMENTAIRE_CHAR+"Différence de R1 et R2, résultat dans R1\n");
				break;
			case "*":
				builderActuel.append("\tMUL R1,R2,R1"+COMMENTAIRE_CHAR+"Multiplication de R1 et R2, résultat dans R1\n");
				break;
			case "/":
				builderActuel.append("\tDIV R1,R2,R1"+COMMENTAIRE_CHAR+"Division de R1 et R2, résultat dans R1\n");
				break;
			}
			break;
		case "IDBEG":
			
			//System.err.println(noeud.getChild(0).getText());
			if(noeud.getChildCount()==1)
			{
				//on récupère l'adresse de la variable du noeud fils
				Variable v = (Variable)courante.get(noeud.getChild(0).getText());
				//on récupère l'adresse de la variable
				recupererAdresseVariable(v);
				//on copie le contenu de R2 dans R1
				builderActuel.append("\tLDW R1,(R2)\n");
			}
			if (noeud.getChildCount()==2)
			{
				//on évalue l'expression (fils droit)
				switch(noeud.getChild(1).getText())
				{	
					// il y a peut etre d'autre cas
				
					case "ASSIGNMENT":	
						// TODO	
						Tree noeudAssignment = noeud.getChild(1);
						//System.err.println(noeudAssignment.getText());
						traiterExpression(noeudAssignment.getChild(0));
						parcourirArbre(noeudAssignment);
						//On récupère enfin l'adresse de la variable dans laquelle on veut ranger la valeur
						Variable v = (Variable)courante.get(noeud.getChild(0).getText());
						recupererAdresseVariable(v);
						//On range le résulat à l'adresse que l'on vient de récupérer
						builderActuel.append( "\tSTW R1, (R2) "+COMMENTAIRE_CHAR+"On stocke le contenu de R1 à l'adresse contenue dans R2\n");
						break;
				}
			}
			
			
			break;
		case "INT":
			builderActuel.append("\tLDW R1, #"+noeud.getChild(0).getText()+COMMENTAIRE_CHAR+"On stocke la valeur de l'entier dans R1\n");
			break;
		case "STRING":
			//TODO
			ajouterString(noeud.getChild(0).getText());
			builderActuel.append("\tLDW R1, #STRING"+numString+COMMENTAIRE_CHAR+"On charge l'adresse de la chaîne dans R1\n");
			numString++;
			break;
		case "CALLEXP":

			break;
		}
	}
	
	private void debutBloc()
	{
		builderActuel.append("\tSTW BP, -(SP) //empile le contenu du registre BP(dynamique)\n");
		builderActuel.append("\tSTW BP, -(SP) //empile le contenu du registre BP(statique)\n"); // empile le contenu du registre BP
		builderActuel.append("\tLDW BP, SP //charge contenu SP ds BP\n"); // charge contenu SP ds BP
		builderActuel.append("\tSTW WR, -(SP) //On empile le chainage statique contenu dans WR\n");//on empile le statique
	}
	private void finBloc()
	{
		builderActuel.append("\tADQ 2,SP\n//On retire le statique");
		builderActuel.append("\tLDW SP, BP //abandon infos locales\n"); // abandon infos locales
		builderActuel.append("\tLDW BP, (SP)+ //charge BP avec ancien BP\n"); // charge BP avec ancien BP
	}
	
	private void calculerStatiqueAppele()
	{
		
	}
	private void ajouterString(String texte)
	{
		codeAssembleur.insert(codeAssembleur.lastIndexOf("main_"), "STRING"+numString+"\tstring\t"+texte+"\n");
	}
	
	private boolean isLetOrSeqexp(Tree noeud)
	{
		if(noeud.getText().equals("LET") || noeud.getText().equals("SEQEXP"))
		{
			return true;
		}
		return false;
	}
	
}

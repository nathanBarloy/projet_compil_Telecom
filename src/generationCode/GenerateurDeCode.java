package generationCode;
import java.io.FileWriter;
import java.io.Writer;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

import identificateurs.RecordType;
import identificateurs.Variable;
import identificateurs.fonctions.Chr;
import identificateurs.fonctions.Exit;
import identificateurs.fonctions.Fonction;
import identificateurs.fonctions.GetChar;
import identificateurs.fonctions.Not;
import identificateurs.fonctions.Print;
import identificateurs.fonctions.PrintI;
import identificateurs.fonctions.Read;
import tableSymbole.TableSymbolesAbs;

public class GenerateurDeCode {
	
	private final static String COMMENTAIRE_CHAR = "//";
	
	private final static String REGISTREMAXBOUCLEFOR = "R8";
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
	 * Ce compteur permet de personnaliser les Ã©tiquettes de boucle de remontÃ©e de chaÃ®nage
	 */
	private int nbRemontees;
	private StringBuilder codeAssembleur;
	private StringBuilder codeFonctions;
	private int compteurEntreeFonctions;
	private StringBuilder builderActuel;
	//private ArrayList<StringBuilder> arrayBuilderFonction
	//private boolean appelFonction;
	//private boolean decFonction;
	
	public GenerateurDeCode(TableSymbolesAbs tds, CommonTree ast) {
		this.tds = tds;
		this.courante = this.tds;
		this.ast = ast;
		this.numString=0;
		this.nbRemontees=0;
		this.codeAssembleur=new StringBuilder();
		this.codeFonctions=new StringBuilder();
		compteurEntreeFonctions = 0;
		builderActuel=codeAssembleur;
	//	this.appelFonction = false;
	//	this.decFonction = false;
	}
	
	/**
	 * GÃ©nÃ¨re le code assembleur Ã  l'aide de la TDS et de l'AST
	 * @return chaine de caractÃ¨re contenant le code assembleur du programme
	 */
	public String genererCode(String nomFichier)
	{

		codeAssembleur.append("LOADA\tEQU\t0xF010\n"); // adresse mÃ©moire ou le code est chargÃ©
		codeAssembleur.append("EXIT_EXC\tEQU\t64\n"); // nÂ° d'exception de EXIT
		codeAssembleur.append("READ_EXC\tEQU\t65\n"); 		// nÂ° d'exception de READ (lit 1 ligne)
		codeAssembleur.append("WRITE_EXC\tEQU\t66\n"); // nÂ° d'exception de WRITE (affiche 1 ligne)
		codeAssembleur.append("STACK_ADRS\tEQU\t0x1000\n"); // base de pile en 1000h (par exemple)
		codeAssembleur.append("LOAD_ADRS\tEQU\t0xF000\n");// adresse de chargement de l'exÃ©cutable
		codeAssembleur.append("NIL\tEQU\t0\n"); // fin de liste: contenu initial de BP
		codeAssembleur.append("NUL\tEQU\t0\n"); // pointeur nul
		codeAssembleur.append("NULL\tEQU\t0\n"); // caractere null, fin de chaine de caracteres
		// ces alias permettront de changer les reÌ�els registres utiliseÌ�s
		builderActuel.append("SP\tEQU R15\n"); // alias pour R15, pointeur de pile
		builderActuel.append("WR\tEQU R14\n"); // Work Register (registre de travail)
		builderActuel.append("BP\tEQU R13\n"); // frame Base Pointer (pointage environnement)
		builderActuel.append("HP\tEQU R12\n"); // Heap pointer (pointeur du tas)
		builderActuel.append("ORG\tLOADA\n"); // charge le code
		builderActuel.append("START\tLOADA\n"); // lance le code
		 // R12, R11 reÌ�serveÌ�s
		// R0 pour reÌ�sultat de fonction
		// R1 ... R10 disponibles
		builderActuel.append("LDW SP, #STACK_ADRS\n"); // charge SP avec STACK_ADRS
		builderActuel.append("\n");//On saute une ligne aprÃ¨s avoir dÃ©fini les alias
		
		builderActuel.append("main_\n");
		builderActuel.append("\tLDW SP, #STACK_ADRS\n"); // charge SP avec STACK_ADRS
		builderActuel.append("\tLDQ NIL, WR\n"); // charge BP avec NIL=0
		builderActuel.append("\tSTW WR, -(SP) //On empile le dynamique\n"); // empile le contenu du registre BP
		builderActuel.append("\tLDW BP, SP\n"); // charge contenu SP ds BP
		builderActuel.append("\tLDW HP, #0\t//Initialisation du tas a 0\n");
		//builderActuel.append("\tLDW WR, SP\n"); // charge contenu SP ds WR
		builderActuel.append("\tSTW WR, -(SP) //On empile le statique\n"); // empile le contenu du registre BP

		parcourirArbre(ast);
		
		// ce code termine le main, il doit Ãªtre ajoutÃ© avant le code des fonctions
		builderActuel.append("\tLDW SP, BP\n"); // abandon infos locales
		builderActuel.append("\tLDW BP, (SP)+\n"); // charge BP avec ancien BP
		builderActuel.append("\tTRP #EXIT_EXC\n"); // EXIT: arrÃªte le programme*/
		
		//TODO on ajoute le code des fonctions de base
		codeFonctions.append(new Print().genererCode());
		codeFonctions.append(new Exit().genererCode());
		codeFonctions.append(new PrintI().genererCode());
		codeFonctions.append(new Not().genererCode());
		codeFonctions.append(new GetChar().genererCode());
		codeFonctions.append(new Chr().genererCode());
		codeFonctions.append(new Read().genererCode());

		
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
		//System.err.println(tree.getText());
		switch(tree.getText())
		{
		// gÃ©rer tous les cas (token) existant dans l'AST 
		
		// /!\ Attention il faut voir ou le code se rajoute par rapport au parcours de l'arbre 
		
		case "FUNDEC":
			//this.decFonction = true;
			Fonction f = (Fonction)courante.get(tree.getChild(0).getText());
			courante = f.getTdsFonction();
			//builderActuel=codeFonctions;
			StringBuilder oldBuilder = builderActuel; 
			builderActuel = new StringBuilder();
			compteurEntreeFonctions++;
			builderActuel.append( f.debutFonction());
			parcourirArbre(tree.getChild(tree.getChildCount()-1));
			//}
			builderActuel.append( f.finFonction());
			compteurEntreeFonctions--;
			codeFonctions.append(builderActuel);
			builderActuel = oldBuilder;
			courante=courante.getParent();
			//this.decFonction = false;
			break;
		case "LET":
			this.courante.incCompteurTDS();
			TableSymbolesAbs tableBlocLet = this.courante.getFils(this.courante.getCompteurTDS()-1);
			debutBloc(tableBlocLet);
			this.courante = tableBlocLet;
			for(int i = 0; i < tree.getChildCount(); i++)
			{
				if(i == tree.getChildCount()-1)
				{
				//	traiterExpression(tree.getChild(i));
					parcourirArbre(tree.getChild(i));
					builderActuel.append("\tLDW R0, R1 \t"+COMMENTAIRE_CHAR+"Copie de la valeur de retour dans R0\n");
				}
				else {
					parcourirArbre(tree.getChild(i));
				}
				
			}
			finBloc();
			this.courante=courante.getParent();
			break;
		case "WHILE":
			
			this.courante.incCompteurTDS();
			TableSymbolesAbs tableBlocWhile = this.courante.getFils(this.courante.getCompteurTDS()-1);
			debutBloc(tableBlocWhile);
			this.courante = tableBlocWhile;
			builderActuel.append(courante.debutBloc()+"\n");
			
			comparaison(tree.getChild(0),false,true);
			builderActuel.append("\tCMP R1, R3\n");
			builderActuel.append("\t");	
			traiterCondition(tree.getChild(0));
			//this.courante = this.courante.getFils(this.courante.getCompteurTDS()-1);

			builderActuel.append(" 4\n");
			builderActuel.append("\tJEA@"+courante.finBloc()+"\n");

			builderActuel.append("do"+courante.debutBloc()+"\n");
			// modifier la ligne suivante : ne foncitonne pas
			if(isLetOrSeqexp(tree.getChild(1)))
			{
				parcourirArbre(tree.getChild(1));
			}
			else
			{
				parcourirArbre(tree.getChild(1));
				builderActuel.append("\tLDW R0, R1 \t"+COMMENTAIRE_CHAR+"Copie de la valeur de retour dans R0\n");
			}

			
			
			builderActuel.append("\tJEA @"+courante.debutBloc()+"\n");
			builderActuel.append(courante.finBloc()+"\n");
			finBloc();
			courante=courante.getParent();
			break;
			
		case "FOR":
			
			this.courante.incCompteurTDS();
			TableSymbolesAbs tableBlocFor = this.courante.getFils(this.courante.getCompteurTDS()-1);
			debutBloc(tableBlocFor);
			this.courante = tableBlocFor;
			//debut for
			//on dÃ©clare la variable de boucle
			builderActuel.append("\tADQ -2,SP "+COMMENTAIRE_CHAR+"On dÃ©cale le sommet de pile de la taille de variable qui porte la boucle\n");
			//on met la valeur de debut de boucle dans le registre de boucle
			parcourirArbre(tree.getChild(1));
			builderActuel .append( "\tSTW "+REGISTRERETOUREXPRESSION+","+REGISTREBOUCLEFOR+COMMENTAIRE_CHAR+"On met dans le registre de boucle la valeur de dÃ©part\n");
			//On met la valeur de fin de boucle dans R8
			parcourirArbre(tree.getChild(2));
			builderActuel .append( "\tSTW "+REGISTRERETOUREXPRESSION+","+REGISTREMAXBOUCLEFOR+COMMENTAIRE_CHAR+"On met l'indice de fin de boucle dans un registre\n");
			builderActuel.append("\tADQ 1,"+REGISTREMAXBOUCLEFOR+"\n");
			builderActuel.append(courante.debutBloc()+"\n");
			//on met Ã  jour l'indice de boucle avec le registre de boucle
			builderActuel.append("\tSTW "+REGISTREBOUCLEFOR+",(BP)-4\n");//on met le contenu du registre de boucle dans l'indice de boucle
			//on gÃ©nÃ¨re le code "normal" de l'intÃ©rieur du for
			parcourirArbre(tree.getChild(tree.getChildCount()-1));
			//on incrÃ©mente l'indice de boucle
			builderActuel.append("\tADQ 1,"+REGISTREBOUCLEFOR+"\n");
			//on compare l'indice de boucle avec la valeur max de boucle
			builderActuel.append("\tCMP "+REGISTREMAXBOUCLEFOR+","+REGISTREBOUCLEFOR+"\n");
			builderActuel.append("\tBEQ 4\n");
			builderActuel.append("\tJEA @"+courante.debutBloc()+"\n");
			builderActuel.append("\tADQ 2,SP//On dÃ©pile la variable qui porte la boucle\n");
			
			builderActuel.append(courante.finBloc()+"\n");
			//fin for
			finBloc();
			this.courante=courante.getParent();
			break;
		case "VARDEC":
			Variable var = (Variable)courante.get(tree.getChild(0).getText());
			builderActuel.append( "\t"+COMMENTAIRE_CHAR+"On dÃ©clare "+var.getName()+"\n");
			//On Ã©value l'expression Ã  assigner
			if(tree.getChildCount() == 2)
			{
				parcourirArbre(tree.getChild(1));
			}
			else
			{
				parcourirArbre(tree.getChild(2));
			}
			//On range le rÃ©sulat en sommet de pile
			builderActuel.append("\tADQ -"+var.getType().getTaille()+",SP "+COMMENTAIRE_CHAR+"On dÃ©cale le sommet de pile de la taille du type de "+var.getName()+"("+var.getType().getName()+")\n");
			builderActuel .append( "\tSTW R1, (SP)"+COMMENTAIRE_CHAR+"On empile le contenu de R1\n");
			break;
		case "TYDEC" :
			// Il y a rien a faire normalement
			// pas de parcours normalement
			break;
		case "IDBEG":
			// pas de parcours normalement
			if(tree.getChildCount()==1)
			{
				//on rÃ©cupÃ¨re l'adresse de la variable du noeud fils
				Variable v = (Variable)courante.get(tree.getChild(0).getText());
				//on rÃ©cupÃ¨re l'adresse de la variable
				recupererAdresseVariable(v);
				//on copie le contenu de R2 dans R1
				builderActuel.append("\tLDW R1,(R2)\n");
			}
			else if (tree.getChildCount()==2)
			{
				//on Ã©value l'expression (fils droit)
				switch(tree.getChild(1).getText())
				{
					case "EXPBEG":
						int nbFils = tree.getChild(1).getChildCount();
						if(nbFils == 2)
						{
							switch(tree.getChild(1).getChild(1).getText())
							{
								case "BRACBEG" :
									builderActuel.append("\tLDW R1, HP\t//On met l'adresse du tas dans R1\n");
									int tailleTab = Integer.parseInt(tree.getChild(1).getChild(0).getChild(0).getText()) * 2;
									builderActuel.append("\tADQ "+tailleTab+", HP\t//On augmente HP de la taille du tableau\n");
									break;
								case "ASSIGNMENT" :
									Variable v = (Variable)courante.get(tree.getChild(0).getText());
									recupererAdresseVariable(v);
									builderActuel.append("\tLDW R2, (R2)\t//On recupere l'adresse du tableau dans le tas\n");
									parcourirArbre(tree.getChild(1).getChild(0));
									builderActuel.append("\tLDW R3, R1\t//On recuperer l'index\n");
									builderActuel.append("\tLDW R4, #2\n");
									builderActuel.append("\tMUL R3, R4, R3\t//On calcule le deplacement dans le tas\n");
									builderActuel.append("\tADC R2, R3, R3\t//On recupere l'adresse dans R3\n");
									parcourirArbre(tree.getChild(1).getChild(1).getChild(0));
									builderActuel.append( "\tSTW R1, (R3)\t"+COMMENTAIRE_CHAR+"On stocke le contenu de R1 a l'adresse contenue dans R3\n");
									break;
								// TODO autres cas possibles
							}
						}
						else if(nbFils == 1)
						{
							Variable v = (Variable)courante.get(tree.getChild(0).getText());
							recupererAdresseVariable(v);
							builderActuel.append("\tLDW R2, (R2)\t//On recupere l'adresse du tableau dans le tas\n");
							parcourirArbre(tree.getChild(1).getChild(0));
							builderActuel.append("\tLDW R3, R1\t//On recuperer l'index\n");
							builderActuel.append("\tLDW R4, #2\n");
							builderActuel.append("\tMUL R3, R4, R3\t//On calcule le deplacement dans le tas\n");
							builderActuel.append("\tADC R2, R3, R3\t//On recupere l'adresse dans R3\n");
							builderActuel.append("\tLDW R1, (R3)\t//On met la valeur dans R1\n");
						}
						break;
					case "FIELDEXP":
						int nbChild = tree.getChild(1).getChildCount();
						if(nbChild == 1)
						{
							Variable v = (Variable)courante.get(tree.getChild(0).getText());
							recupererAdresseVariable(v);
							builderActuel.append("\tLDW R2, (R2)\t//On recupere l'adresse du record dans le tas\n");
							int deplacement = ((RecordType) v.getType()).getIndexFromField(tree.getChild(1).getChild(0).getText()) * 2;
							builderActuel.append("\tADQ "+deplacement+", R2\t//On ajoute le deplacement\n");
							builderActuel.append("\tLDW R1, (R2)\t//On met la valeur du champ dans R1\n");
						}
						else if (nbChild == 2)
						{
							switch(tree.getChild(1).getChild(1).getText())
							{
								case "ASSIGNMENT":
									parcourirArbre(tree.getChild(1).getChild(1).getChild(0));
									Variable v = (Variable)courante.get(tree.getChild(0).getText());
									recupererAdresseVariable(v);
									builderActuel.append("\tLDW R2, (R2)\t//On recupere l'adresse du record dans le tas\n");
									int deplacement = ((RecordType) v.getType()).getIndexFromField(tree.getChild(1).getChild(0).getText()) * 2;
									builderActuel.append("\tADQ "+deplacement+", R2\t//On ajoute le deplacement\n");
									builderActuel.append("\tSTW R1, (R2)\n");
									break;
							}
						}
						break;
					case "RECCREATE":
						RecordType rec =(RecordType) this.courante.get(tree.getChild(0).getText());
						int taille = rec.getDeplacement();
						for(int i = 0; i < tree.getChild(1).getChildCount(); i ++)
						{
							parcourirArbre(tree.getChild(1).getChild(i).getChild(1));
							builderActuel.append("\tSTW R1, (HP)+\t//On initialise la valeur du champ\n");
						}
						builderActuel.append("\tLDW R1, HP\n");
						builderActuel.append("\tADQ -"+taille+", R1\n");
						break;
					case "CALLEXP" :
					//	this.appelFonction = true;
						Tree noeudCallExp = tree.getChild(1);
						//System.err.println(noeudCallExp.getText());
						//on empile les paramÃ¨tres
						for(int param=0;param<noeudCallExp.getChildCount();param++)
						{
							builderActuel.append("\t"+COMMENTAIRE_CHAR+"On empile la valeur de "+noeudCallExp.getChild(param).getChild(0).getText()+"\n");
							//traiterExpression(noeudCallExp.getChild(param));
							parcourirArbre(noeudCallExp.getChild(param));
							//On empile le contenu de R1
							//On range le rÃ©sulat en sommet de pile
							builderActuel.append("\tADQ -2,SP "+COMMENTAIRE_CHAR+"On dÃ©cale le sommet de pile\n");
							builderActuel .append( "\tSTW R1, (SP)"+COMMENTAIRE_CHAR+"On empile le contenu de R1\n");
						}
						//calculer chaÃ®nage STAT
						Fonction fonc = (Fonction)courante.get(tree.getChild(0).getText());
						int nx = courante.getNiveau();
						int ny = fonc.getTdsFonction().getNiveau();
						int chainageARemonter=nx-ny+1;
						calculerChainageStatique(chainageARemonter);
						
						builderActuel.append("\tJSR @"+fonc.nomCodeFonction());
						int nbParam=noeudCallExp.getChildCount();
						//on dÃ©pile les paramÃ¨tres
						builderActuel.append("\tADQ "+(nbParam*2)+",SP "+COMMENTAIRE_CHAR+"On dÃ©pile les paramÃ¨tres\n");
						builderActuel.append("\tLDW R1, R0\t"+COMMENTAIRE_CHAR+"On met le retour dans R1\n");
						break;
					case "ASSIGNMENT":	
						Tree noeudAssignment = tree.getChild(1);
						parcourirArbre(noeudAssignment.getChild(0));
						//On rÃ©cupÃ¨re enfin l'adresse de la variable dans laquelle on veut ranger la valeur
						Variable v = (Variable)courante.get(tree.getChild(0).getText());
						recupererAdresseVariable(v);
						//On range le rÃ©sulat Ã  l'adresse que l'on vient de rÃ©cupÃ©rer
						builderActuel.append( "\tSTW R1, (R2) "+COMMENTAIRE_CHAR+"On stocke le contenu de R1 Ã  l'adresse contenue dans R2\n");
						break;
				}
			}
			break;
		case "NEGATION" :
			// pas de parcours normalement
			parcourirArbre(tree.getChild(0));
			builderActuel.append("\tLDW R2, #0\n");
			builderActuel.append("\tSUB R2, R1, R1\n");
			break;
		case "IFTHEN" :
			this.courante.incCompteurTDS();
			TableSymbolesAbs tableBlocIf = this.courante.getFils(this.courante.getCompteurTDS()-1);
			debutBloc(tableBlocIf);
			this.courante = tableBlocIf;
			builderActuel.append(courante.debutBloc()+"\n");
			
			comparaison(tree.getChild(0),false,true);
			builderActuel.append("\tCMP R1, R3\n");
			builderActuel.append("\t");	
			traiterCondition(tree.getChild(0));
			boolean elsePresent = tree.getChildCount()==3;
			if(elsePresent)
			{
				builderActuel.append(" 4\n");
				builderActuel.append("\tJEA @else"+courante.debutBloc()+"\n");
			}
			else
			{
				builderActuel.append(" 4\n");
				builderActuel.append("\tJEA @"+courante.finBloc()+"\n");
			}
			builderActuel.append("then"+courante.debutBloc()+"\n");
			// modifier la ligne suivante : ne foncitonne pas
			if(isLetOrSeqexp(tree.getChild(1)))
			{
				parcourirArbre(tree.getChild(1));
			}
			else
			{
				parcourirArbre(tree.getChild(1));
				builderActuel.append("\tLDW R0, R1 \t"+COMMENTAIRE_CHAR+"Copie de la valeur de retour dans R0\n");
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
					parcourirArbre(tree.getChild(2));
					builderActuel.append("\tLDW R0, R1 \t"+COMMENTAIRE_CHAR+"Copie de la valeur de retour dans R0\n");

				}
			}
			builderActuel.append(courante.finBloc()+"\n");
			finBloc();
			courante=courante.getParent();
			break;
		case "break" :
			TableSymbolesAbs TDStemp= courante;
			int cpt = 0;
			while(!TDStemp.isBreakable())
			{
				TDStemp = TDStemp.getParent();
				cpt++;
			}
			for (int i = 0; i < cpt; i++)
			{
				finBloc();
			}
			builderActuel.append("\tJEA @"+TDStemp.finBloc()+"\n");
			// pas de parcours normalement
			break;
		case "SEQEXP":
			for(int i = 0; i < tree.getChildCount(); i++)
			{
				if(i == tree.getChildCount()-1)
				{
					parcourirArbre(tree.getChild(i));
					builderActuel.append("\tLDW R0, R1 \t"+COMMENTAIRE_CHAR+"Copie de la valeur de retour dans R0\n");
				}
				else {
					parcourirArbre(tree.getChild(i));
				}
				
			}
			break;
		case "ROOT":
			parcourirArbre(tree.getChild(0));
			break;
			
		case "+":
		case "-":
		case "*":
		case "/":
			//on traite la partie gauche puis la partie droite
			parcourirArbre(tree.getChild(0));
			//on empile R1
			builderActuel.append("\tADQ -2,SP\n");
			builderActuel .append( "\tSTW R1, (SP)"+COMMENTAIRE_CHAR+"On empile le contenu de R1\n");
			parcourirArbre(tree.getChild(1));
			//on empile R1
			builderActuel.append("\tADQ -2,SP\n");
			builderActuel.append( "\tSTW R1, (SP)"+COMMENTAIRE_CHAR+"On empile le contenu de R1\n");
			//on fait l'opÃ©ration sur les deux elements en sommet de pile
			//On dÃ©pile dans R1 et R2
			builderActuel.append("\tLDW R2,(SP)\n"); // charge le registre R avec le sommet de pile
			builderActuel.append("\tADQ 2, SP\n"); // incrÃ©mente le pointeur de pile SP
			builderActuel.append("\tLDW R1,(SP)\n"); // charge le registre R avec le sommet de pile
			builderActuel.append("\tADQ 2, SP\n"); // incrÃ©mente le pointeur de pile SP
			//on fait l'operation
			switch(tree.getText())
			{
			case "+":
				builderActuel.append("\tADD R1,R2,R1 "+COMMENTAIRE_CHAR+"Somme de R1 et R2, rÃ©sultat dans R1\n");
				break;
			case "-":
				builderActuel.append("\tSUB R1,R2,R1"+COMMENTAIRE_CHAR+"DiffÃ©rence de R1 et R2, rÃ©sultat dans R1\n");
				break;
			case "*":
				builderActuel.append("\tMUL R1,R2,R1"+COMMENTAIRE_CHAR+"Multiplication de R1 et R2, rÃ©sultat dans R1\n");
				break;
			case "/":
				builderActuel.append("\tDIV R1,R2,R1"+COMMENTAIRE_CHAR+"Division de R1 et R2, rÃ©sultat dans R1\n");
				break;
			}
			break;
		case "INT":
			builderActuel.append("\tLDW R1, #"+tree.getChild(0).getText()+COMMENTAIRE_CHAR+"On stocke la valeur de l'entier dans R1\n");
			break;
		case "STRING":
			ajouterString(tree.getChild(0).getText());
			builderActuel.append("\tLDW R1, #STRING"+numString+COMMENTAIRE_CHAR+"On charge l'adresse de la chaÃ®ne dans R1\n");
			numString++;
			break;
			
		case "=":
		case "<>":
		case  ">":
		case  "<":
		case  ">=":
		case  "<=":
			parcourirArbre(tree.getChild(1));
			builderActuel.append("\tLDW R3, R1\n");
			parcourirArbre(tree.getChild(0));
			builderActuel.append("\tCMP R1, R3\n\t");
			traiterCondition(tree);
			builderActuel.append(" 6\n");
			builderActuel.append("\tLDW R1, #0\n");
			builderActuel.append("\tBMP 2\n");
			builderActuel.append("\tLDW R1, #1\n");
			break;
		default:
			//parcourirArbre(tree);//si on est pas dans les cas prÃ©cÃ©dents,on crÃ©e une nouvelle table
			break;
		}
	}
	
	private void recupererAdresseVariable(Variable v)
	{
		int chainageARemonter=nombreDeChainageARemonter(v);
		builderActuel.append( "\t"+COMMENTAIRE_CHAR+"On recherche l'adresse de "+v.getName()+"\n");
		calculerChainageStatique(chainageARemonter);
		if(v.getDeplacement()>=0)
		{
			builderActuel.append("\tADQ -"+(v.getDeplacement()+4)+", WR\n"); // WR pointe sur la variable locale (+4 pour passer DYN et STAT)
		}
		else
		{
			builderActuel.append("\tADQ "+(-v.getDeplacement()+2)+", WR\n"); // WR pointe sur le paramÃ¨tre (
		}
		
		builderActuel.append("\tLDW R2,WR\n");//on met le contenu de WR dans R2
	}
	
	/**
	 * Cette fonction retourne le nombre de chainage Ã  remonter pour retrouver la variable passÃ©e en paramÃ¨tre 
	 * @param v
	 * @return
	 */
	private int nombreDeChainageARemonter(Variable v)
	{
		int nx = courante.getNiveau();
		int ny = courante.getNiveauDeclaration(v);
		return nx-ny;
	}
	
	private void calculerChainageStatique(int chainageARemonter)
	{
		builderActuel.append("\tLDW WR,BP //On calcule le chainage statique de l'appelÃ©\n");
		if(chainageARemonter>0)
		{
			builderActuel.append("\tLDW R10,#"+chainageARemonter+"\n");
			builderActuel.append("BOU"+nbRemontees+"\tADQ -2,WR\n");
			builderActuel.append("\tLDW WR,(WR)\n");
			builderActuel.append("\tADQ -1,R10\n");
			builderActuel.append("\tBNE BOU"+nbRemontees+"-$-2\n");
		}
		
		nbRemontees++;
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
						//on rÃ©cupÃ¨re l'adresse de la variable du noeud fils
						Variable v = (Variable)courante.get(noeud.getChild(0).getText());
						//on rÃ©cupÃ¨re l'adresse de la variable
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
					else if (noeud.getChildCount()==2)
					{
						//on Ã©value l'expression (fils droit)
						switch(noeud.getChild(1).getText())
						{
							case "CALLEXP" :
							//	this.appelFonction = true;
								Tree noeudCallExp = noeud.getChild(1);
								//System.err.println(noeudCallExp.getText());
								//on empile les paramÃ¨tres
								for(int param=0;param<noeudCallExp.getChildCount();param++)
								{
									builderActuel.append("\t"+COMMENTAIRE_CHAR+"On empile la valeur de "+noeudCallExp.getChild(param).getChild(0).getText()+"\n");
									//traiterExpression(noeudCallExp.getChild(param));
									parcourirArbre(noeudCallExp.getChild(param));
									//On empile le contenu de R1
									//On range le rÃ©sulat en sommet de pile
									builderActuel.append("\tADQ -2,SP "+COMMENTAIRE_CHAR+"On dÃ©cale le sommet de pile\n");
									builderActuel .append( "\tSTW R1, (SP)"+COMMENTAIRE_CHAR+"On empile le contenu de R1\n");
								}
								//calculer chaÃ®nage STAT
								Fonction fonc = (Fonction)courante.get(noeud.getChild(0).getText());
								int nx = courante.getNiveau();
								int ny = fonc.getTdsFonction().getNiveau();
								int chainageARemonter=nx-ny+1;
								calculerChainageStatique(chainageARemonter);
								
								builderActuel.append("\tJSR @"+fonc.nomCodeFonction());
								int nbParam=noeudCallExp.getChildCount();
								//on dÃ©pile les paramÃ¨tres
								builderActuel.append("\tADQ "+(nbParam*2)+",SP "+COMMENTAIRE_CHAR+"On dÃ©pile les paramÃ¨tres\n");
								if(!deuxieme)
								{
									builderActuel.append("\tLDW R1, R0\t"+COMMENTAIRE_CHAR+" On charge la valeur de retour dans R1\n");
									if(unique)
									{
										comparaison(null,false,false);
									}
								}	
								else
								{
									builderActuel.append("\tLDW R3, R0\t"+COMMENTAIRE_CHAR+" On charge la valeur de retour dans R3\n");
								}
								break;
						
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
				case "|" :
					comparaison(noeud.getChild(0),false,true);
					builderActuel.append("\tCMP R1, R3\n");
					builderActuel.append("\t");	
					traiterCondition(noeud.getChild(0));
					builderActuel.append(" 8\n");
					builderActuel.append("\tLDW R1, #0\n");
					builderActuel.append("\tSTW R1, -(SP)\t//On met 0 dans la pile\n");
					builderActuel.append("\tBMP 6\n");
					builderActuel.append("\tLDW R1, #1\n");
					builderActuel.append("\tSTW R1, -(SP)\t//On met 1 dans la pile\n");
					comparaison(noeud.getChild(1),false,true);
					builderActuel.append("\tCMP R1, R3\n");
					builderActuel.append("\t");	
					traiterCondition(noeud.getChild(1));
					builderActuel.append(" 8\n");
					builderActuel.append("\tLDW R1, #0\n");
					builderActuel.append("\tSTW R1, -(SP)\t//On met 0 dans la pile\n");
					builderActuel.append("\tBMP 6\n");
					builderActuel.append("\tLDW R1, #1\n");
					builderActuel.append("\tSTW R1, -(SP)\t//On met 1 dans la pile\n");
					builderActuel.append("\tLDW R1, (SP)+\t//On depile dans R1\n");
					builderActuel.append("\tLDW R2, (SP)+\t//On depile dans R2\n");
					builderActuel.append("\tOR R1, R2, R1\t//On realise le OU, resultat dans R1\n");
					builderActuel.append("\tLDW R3, #0\t//On met R3 a 0 pour la comparaison\n");
					break;
				case "&" :
					comparaison(noeud.getChild(0),false,true);
					builderActuel.append("\tCMP R1, R3\n");
					builderActuel.append("\t");	
					traiterCondition(noeud.getChild(0));
					builderActuel.append(" 8\n");
					builderActuel.append("\tLDW R1, #0\n");
					builderActuel.append("\tSTW R1, -(SP)\t//On met 0 dans la pile\n");
					builderActuel.append("\tBMP 6\n");
					builderActuel.append("\tLDW R1, #1\n");
					builderActuel.append("\tSTW R1, -(SP)\t//On met 1 dans la pile\n");
					comparaison(noeud.getChild(1),false,true);
					builderActuel.append("\tCMP R1, R3\n");
					builderActuel.append("\t");	
					traiterCondition(noeud.getChild(1));
					builderActuel.append(" 8\n");
					builderActuel.append("\tLDW R1, #0\n");
					builderActuel.append("\tSTW R1, -(SP)\t//On met 0 dans la pile\n");
					builderActuel.append("\tBMP 6\n");
					builderActuel.append("\tLDW R1, #1\n");
					builderActuel.append("\tSTW R1, -(SP)\t//On met 1 dans la pile\n");
					builderActuel.append("\tLDW R1, (SP)+\t//On depile dans R1\n");
					builderActuel.append("\tLDW R2, (SP)+\t//On depile dans R2\n");
					builderActuel.append("\tAND R1, R2, R1\t//On realise le ET, resultat dans R1\n");
					builderActuel.append("\tLDW R3, #0\t//On met R3 a 0 pour la comparaison\n");
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
				builderActuel.append("BGT");
				break;
			case  "|":
				builderActuel.append("BGT");
				
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

	private void debutBloc(TableSymbolesAbs tdsBloc)
	{
		int nx = courante.getNiveau();
		int ny = tdsBloc.getNiveau();
		int chainageARemonter=nx-ny+1;
		calculerChainageStatique(chainageARemonter);
		builderActuel.append(sauvegarderRegistres());
		builderActuel.append("\tSTW BP, -(SP) //empile le contenu du registre BP(dynamique)\n");
		builderActuel.append("\tLDW R1,SP\n");
		builderActuel.append("\tSTW WR, -(SP) //empile le contenu du registre BP(statique)\n"); // empile le contenu du registre BP
		builderActuel.append("\tLDW BP, R1 //charge contenu SP ds BP\n"); // charge contenu SP ds BP
	}
	
	public static String sauvegarderRegistres()
	{
		String res = "";
		for(int i=2;i<=10;i++)
		{
			res+="\tSTW R"+i+",-(SP)\n";
		}
		res+="\tSTW R12, -(SP)\n";
		return res;
	}
	
	public static String restaurerRegistres()
	{
		String res = "";
		res+="\tLDW R12, (SP)+\n";
		for(int i=10;i>1;i--)
		{
			res +="\tLDW R"+i+",(SP)+\n";
		}
		return res;
		
	}
	private void finBloc()
	{
		
		builderActuel.append("\tADQ 2,SP//On retire le statique\n");
		builderActuel.append("\tLDW SP, BP //abandon infos locales\n"); // abandon infos locales
		builderActuel.append("\tLDW BP, (SP)+ //charge BP avec ancien BP\n"); // charge BP avec ancien BP
		builderActuel.append(restaurerRegistres());
		
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

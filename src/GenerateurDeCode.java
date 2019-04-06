import java.io.FileWriter;
import java.io.Writer;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import identificateurs.Variable;
import identificateurs.fonctions.Fonction;
import tableSymbole.TableSymbolesAbs;

public class GenerateurDeCode {
	
	private final static String COMMENTAIRE_CHAR = "//";
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
	
	public GenerateurDeCode(TableSymbolesAbs tds, CommonTree ast) {
		this.tds = tds;
		this.courante = this.tds;
		this.ast = ast;
		this.numString=0;
		this.nbRemontees=0;
		this.codeAssembleur=new StringBuilder();
	}
	
	/**
	 * Génère le code assembleur à l'aide de la TDS et de l'AST
	 * @return chaine de caractère contenant le code assembleur du programme
	 */
	public String genererCode(String nomFichier)
	{
		codeAssembleur.append("LOADA\tEQU\t0xFF10\n"); // adresse mémoire ou le code est chargé
		codeAssembleur.append("EXIT_EXC\tEQU\t64\n"); // n° d'exception de EXIT
		codeAssembleur.append("READ_EXC\tEQU\t65\n"); 		// n° d'exception de READ (lit 1 ligne)
		codeAssembleur.append("WRITE_EXC\tEQU\t66\n"); // n° d'exception de WRITE (affiche 1 ligne)
		codeAssembleur.append("STACK_ADRS\tEQU\t0x1000\n"); // base de pile en 1000h (par exemple)
		codeAssembleur.append("LOAD_ADRS\tEQU\t0xF000\n");// adresse de chargement de l'exécutable
		codeAssembleur.append("NIL\tEQU\t0\n"); // fin de liste: contenu initial de BP
		// ces alias permettront de changer les réels registres utilisés
		codeAssembleur.append("SP\tEQU R15\n"); // alias pour R15, pointeur de pile
		codeAssembleur.append("WR\tEQU R14\n"); // Work Register (registre de travail)
		codeAssembleur.append("BP\tEQU R13\n"); // frame Base Pointer (pointage environnement)
		codeAssembleur.append("ORG\tLOADA\n"); // charge le code
		codeAssembleur.append("START\tLOADA\n"); // lance le code
		 // R12, R11 réservés
		// R0 pour résultat de fonction
		// R1 ... R10 disponibles
		codeAssembleur.append("LDW SP, #STACK_ADRS\n"); // charge SP avec STACK_ADRS
		codeAssembleur.append("\n");//On saute une ligne après avoir défini les alias
		
		codeAssembleur.append("main_\n");
		codeAssembleur.append("\tLDW SP, #STACK_ADRS\n"); // charge SP avec STACK_ADRS
		codeAssembleur.append("\tLDQ NIL, BP\n"); // charge BP avec NIL=0
		codeAssembleur.append("\tSTW BP, -(SP)\n"); // empile le contenu du registre BP
		codeAssembleur.append("\tLDW BP, SP\n"); // charge contenu SP ds BP
		
		parcourirArbre(ast);
		
		//TODO ce code termine le main, il doit être ajouté avant le code des fonctions
		codeAssembleur.append("\tLDW SP, BP\n"); // abandon infos locales
		codeAssembleur.append("\tLDW BP, (SP)+\n"); // charge BP avec ancien BP
		codeAssembleur.append("\tTRP #EXIT_EXC\n"); // EXIT: arrête le programme*/
		
		//TODO on ajoute le code des fonctions de base
		
		
		
		try {
			Writer writer=new FileWriter(nomFichier);
			writer.write(codeAssembleur.toString());
			writer.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return codeAssembleur.toString();
	}
	
	private void parcourirArbre(Tree tree)
	{
		for(int i=0;i<tree.getChildCount();i++)
		{
			//System.out.println("tree.getChild("+i+").getText() : "+tree.getChild(i).getText());
			switch(tree.getChild(i).getText())
			{
			// gérer tous les cas (token) existant dans l'AST 
			
			// /!\ Attention il faut voir ou le code se rajoute par rapport au parcours de l'arbre 
			
			case "FUNDEC":
				Fonction f = (Fonction)courante.get(tree.getChild(i).getChild(0).getText());
				courante = f.getTdsFonction();
				codeAssembleur .append( f.debutFonction());
				parcourirArbre(tree.getChild(i).getChild(tree.getChild(i).getChildCount()-1));
				codeAssembleur .append( f.finFonction());
				break;
			case "LET":
				this.courante.incCompteurTDS();
				this.courante = this.courante.getFils(this.courante.getCompteurTDS()-1);
				parcourirArbre(tree.getChild(i));
				// TODO
				break;
			case "WHILE":
				this.courante.incCompteurTDS();
				this.courante = this.courante.getFils(this.courante.getCompteurTDS()-1);
				parcourirArbre(tree.getChild(i).getChild(1));
				// TODO
				break;
			case "FOR":
				this.courante.incCompteurTDS();
				this.courante = this.courante.getFils(this.courante.getCompteurTDS()-1);
				parcourirArbre(tree.getChild(i).getChild(3));
				// TODO
				break;
			case "VARDEC":
				//TODO
				Variable var = (Variable)courante.get(tree.getChild(i).getChild(0).getText());
				codeAssembleur .append( "\t"+COMMENTAIRE_CHAR+"On déclare "+var.getName()+"\n");
				//On évalue l'expression à assigner
				traiterExpression(tree.getChild(i).getChild(1));
				//On range le résulat en sommet de pile
				codeAssembleur.append("\tADQ -"+var.getType().getTaille()+",SP "+COMMENTAIRE_CHAR+"On décale le sommet de pile de la taille du type de "+var.getName()+"("+var.getType().getName()+")\n");
				codeAssembleur .append( "\tSTW R1, (SP)"+COMMENTAIRE_CHAR+"On empile le contenu de R1\n");
				break;
			case "TYDEC" :
				//TODO
				// pas de parcours normalement
				break;
			case "IDBEG":
				// pas de parcours normalement
				if (tree.getChild(i).getChildCount()==2)
				{
					//on évalue l'expression (fils droit)
					switch(tree.getChild(i).getChild(1).getText())
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
							break;
						case "ASSIGNMENT":	
							// TODO
							Tree noeudAssignment = tree.getChild(i).getChild(1);
							traiterExpression(noeudAssignment.getChild(0));
							break;
					}
					//On récupère enfin l'adresse de la variable dans laquelle on veut ranger la valeur
					Variable v = (Variable)courante.get(tree.getChild(i).getChild(0).getText());
					codeAssembleur .append( "\t"+COMMENTAIRE_CHAR+"On recherche l'adresse de "+v.getName()+"\n");
					recupererAdresseVariable(v);
					//On range le résulat à l'adresse que l'on vient de récupérer
					codeAssembleur .append( "\tSTW R1, (R2) "+COMMENTAIRE_CHAR+"On stocke le contenu de R1 à l'adresse contenue dans R2\n");

				}
				else if(tree.getChild(i).getChildCount()==1)
				{
					//TODO Est-ce que c'est pas géré dans traiterExpression()?
					
				}
				break;
			case "NEGATION" :
				//TODO
				// pas de parcours normalement

				break;
			case "IFTHEN" :
				this.courante.incCompteurTDS();
				this.courante = this.courante.getFils(this.courante.getCompteurTDS()-1);
				int nbFils = tree.getChild(i).getChildCount();
				if(nbFils == 2) {
					parcourirArbre(tree.getChild(i).getChild(1));
				}
				if(nbFils == 3) {
					// gerer les sauts conditionnel 
					parcourirArbre(tree.getChild(i).getChild(1));
					parcourirArbre(tree.getChild(i).getChild(2));
				}
				// TODO
				break;
			case "break" :
				// TODO
				// pas de parcours normalement
				break;
			default:
				parcourirArbre(tree.getChild(i));//si on est pas dans les cas précédents,on crée une nouvelle table
				break;
			}

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
		if(chainageARemonter>0)
		{
			codeAssembleur.append( "\tLDW R10,#("+chainageARemonter+")\n");//on met le nombre de chainage à remonter dans R10
			codeAssembleur.append( "\tLDW WR,BP\n");//on met le contenu du BasePointer dans le WorkRegister
			codeAssembleur.append( "BOU"+nbRemontees+"\tLDW WR,(WR)-4\n");//-4 correspond toujours à la taille d'une adresse
			codeAssembleur.append( "\tSUB #1,R10\n");//on retire 1 à la valeur dans R10
			codeAssembleur.append( "\tBNE BOU"+nbRemontees+"\n");//si R10 n'est pas égal à 0, on retourne à BOUnbRemontee
			nbRemontees++;
		}
		else
		{
			//on a pas de remontée à faire, on est dans le bloc local
			// stocker BP-v.getDeplacement() dans A1
			codeAssembleur.append("\tLDW WR, BP\n"); // WR = BP
		}
		codeAssembleur.append("\tADQ -"+(v.getDeplacement()+2)+", WR\n"); // WR pointe sur le paramètre
		codeAssembleur.append("\tLDW R2,WR\n");//on met le contenu de WR dans R2
	}
	
	/**
	 * Cette fonction retourne le nombre de chainage à remonter pour retrouver la variable passée en paramètre 
	 * @param v
	 * @return
	 */
	private int nombreDeChainageARemonter(Variable v)
	{
		int nx = courante.getNiveau();
		int ny = courante.getNiveauDeclaration(v);
		return nx-ny;
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
			//on traite la partie gauche, la partie droite
			traiterExpression(noeud.getChild(0));
			//on empile R1
			codeAssembleur.append("\tADQ -2,SP\n");
			codeAssembleur .append( "\tSTW R1, (SP)"+COMMENTAIRE_CHAR+"On empile le contenu de R1\n");
			traiterExpression(noeud.getChild(1));
			//on empile R1
			codeAssembleur.append("\tADQ -2,SP\n");
			codeAssembleur .append( "\tSTW R1, (SP)"+COMMENTAIRE_CHAR+"On empile le contenu de R1\n");
			//on fait l'opération sur les deux elements en sommet de pile
			//On dépile dans R1 et R2
			codeAssembleur.append("\tLDW R1,(SP)\n"); // charge le registre R avec le sommet de pile
			codeAssembleur.append("\tADQ 2, SP\n"); // incrémente le pointeur de pile SP
			codeAssembleur.append("\tLDW R2,(SP)\n"); // charge le registre R avec le sommet de pile
			codeAssembleur.append("\tADQ 2, SP\n"); // incrémente le pointeur de pile SP
			//on fait l'operation
			switch(noeud.getText())
			{
			case "+":
				codeAssembleur.append("\tADD R1,R2,R1 "+COMMENTAIRE_CHAR+"Somme de R1 et R2, résultat dans R1\n");
				break;
			case "-":
				codeAssembleur.append("\tSUB R1,R2,R1"+COMMENTAIRE_CHAR+"Différence de R1 et R2, résultat dans R1\n");
				break;
			case "*":
				codeAssembleur.append("\tMULT R1,R2,R1"+COMMENTAIRE_CHAR+"Multiplication de R1 et R2, résultat dans R1\n");
				break;
			case "/":
				codeAssembleur.append("\tDIV R1,R2,R1"+COMMENTAIRE_CHAR+"Division de R1 et R2, résultat dans R1\n");
				break;
			}
			break;
		case "IDBEG":
			//on récupère l'adresse de la variable du noeud fils
			//System.err.println(noeud.getChild(0).getText());
			Variable v = (Variable)courante.get(noeud.getChild(0).getText());
			//on récupère l'adresse de la variable
			recupererAdresseVariable(v);
			//on copie le contenu de R2 dans R1
			codeAssembleur.append("\tLDW R1,(R2)\n");
			break;
		case "INT":
			codeAssembleur.append("\tLDW R1, #"+noeud.getChild(0).getText()+COMMENTAIRE_CHAR+"On stocke la valeur de l'entier dans R1\n");
			break;
		case "STRING":
			//TODO
			codeAssembleur.insert(codeAssembleur.lastIndexOf("main_"), "STRING"+numString+"\tstring\t"+noeud.getChild(0).getText()+"\n");
			codeAssembleur.append("\tLDW R1, #STRING"+numString+COMMENTAIRE_CHAR+"On charge l'adresse de la chaîne dans R1\n");
			numString++;
			break;
		}
	}
	

	
	
}

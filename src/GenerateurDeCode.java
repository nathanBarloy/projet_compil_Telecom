import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;

import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

import identificateurs.AliasType;
import identificateurs.ArrayType;
import identificateurs.RecordType;
import identificateurs.Type;
import identificateurs.Variable;
import identificateurs.fonctions.Fonction;
import tableSymbole.TableSymbolesAbs;
import tableSymbole.TableSymbolesFor;
import tableSymbole.TableSymbolesFunction;
import tableSymbole.TableSymbolesIf;
import tableSymbole.TableSymbolesLet;
import tableSymbole.TableSymbolesWhile;

public class GenerateurDeCode {
	
	private final static String COMMENTAIRE_CHAR = "//";
	private TableSymbolesAbs tds;
	private CommonTree ast;
	/**
	 * indique la TDS dans laquelle le generateur se trouve acutellement
	 */
	private TableSymbolesAbs courante;
	
	public GenerateurDeCode(TableSymbolesAbs tds, CommonTree ast) {
		this.tds = tds;
		this.courante = this.tds;
		this.ast = ast;
	}
	
	/**
	 * Génère le code assembleur à l'aide de la TDS et de l'AST
	 * @return chaine de caractère contenant le code assembleur du programme
	 */
	public String genererCode(String nomFichier)
	{
		String codeAssembleur="";
		codeAssembleur+="LOADA\tEQU\t0xFF10\n"; // adresse mémoire ou le code est chargé
		codeAssembleur+="EXIT_EXC\tEQU\t64\n"; // n° d'exception de EXIT
		codeAssembleur+="READ_EXC\tEQU\t65\n"; 		// n° d'exception de READ (lit 1 ligne)
		codeAssembleur+="WRITE_EXC\tEQU\t66\n"; // n° d'exception de WRITE (affiche 1 ligne)
		codeAssembleur+="STACK_ADRS\tEQU\t0x1000\n"; // base de pile en 1000h (par exemple)
		// ces alias permettront de changer les réels registres utilisés
		codeAssembleur+="SP\tEQU R15\n"; // alias pour R15, pointeur de pile
		codeAssembleur+="WR\tEQU R14\n"; // Work Register (registre de travail)
		codeAssembleur+="BP\tEQU R13\n"; // frame Base Pointer (pointage environnement)
		codeAssembleur+="ORG\tLOADA\n"; // charge le code
		codeAssembleur+="START\tLOADA\n"; // lance le code
		 // R12, R11 réservés
		// R0 pour résultat de fonction
		// R1 ... R10 disponibles
		codeAssembleur+="LDW SP, #STACK_ADRS\n"; // charge SP avec STACK_ADRS
		codeAssembleur+="\n";//On saute une ligne après avoir défini les alias
		//TODO parcourir l'AST et utiliser la TDS pour générer le code
		codeAssembleur+="main_\n";
		codeAssembleur+="\tLDW SP, #STACK_ADRS\n"; // charge SP avec STACK_ADRS
		codeAssembleur+="\tLDQ NIL, BP\n"; // charge BP avec NIL=0
		codeAssembleur+="\tSTW BP, -(SP)\n"; // empile le contenu du registre BP
		codeAssembleur+="\tLDW BP, SP\n"; // charge contenu SP ds BP
		
		//codeAssembleur+=tds.genererCode();//on génère tout le code
		
		codeAssembleur += parcourirArbre(ast);
		
		//TODO ce code termine le main, il doit être ajouté avant le code des fonctions
		/*codeAssembleur+="\tLDW SP, BP\n"; // abandon infos locales
		codeAssembleur+="\tLDW BP, (SP)+\n"; // charge BP avec ancien BP
		codeAssembleur+="\tTRP #EXIT_EXC\n"; // EXIT: arrête le programme*/
		
		//TODO on ajoute le code des fonctions de base
		
		
		try {
			Writer writer=new FileWriter(nomFichier);
			writer.write(codeAssembleur);
			writer.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return codeAssembleur;
	}
	
	private String parcourirArbre(Tree tree)
	{
		String codeAssembleur ="";
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
				codeAssembleur += f.debutFonction();
				codeAssembleur += parcourirArbre(tree.getChild(i).getChild(tree.getChild(i).getChildCount()-1));
				codeAssembleur += f.finFonction();
				break;
			case "LET":
				this.courante.incCompteurTDS();
				this.courante = this.courante.getFils(this.courante.getCompteurTDS()-1);
				codeAssembleur += parcourirArbre(tree.getChild(i));
				// TODO
				break;
			case "WHILE":
				this.courante.incCompteurTDS();
				this.courante = this.courante.getFils(this.courante.getCompteurTDS()-1);
				codeAssembleur += parcourirArbre(tree.getChild(i).getChild(1));
				// TODO
				break;
			case "FOR":
				this.courante.incCompteurTDS();
				this.courante = this.courante.getFils(this.courante.getCompteurTDS()-1);
				codeAssembleur += parcourirArbre(tree.getChild(i).getChild(3));
				// TODO
				break;
			case "VARDEC":
				//TODO
				Variable var = (Variable)courante.get(tree.getChild(i).getChild(0).getText());
				codeAssembleur += "\t"+COMMENTAIRE_CHAR+"On déclare "+var.getName()+"\n";
				//On évalue l'expression à assigner
				codeAssembleur += traiterExpression(tree.getChild(i).getChild(1));
				//On range le résulat en sommet de pile
				codeAssembleur += "\tSTW R0, (SP)-"+var.getType().getTaille()+COMMENTAIRE_CHAR+"On empile le contenu de RO en décalant le sommet de pile de la taille du type de "+var.getName()+"("+var.getType().getName()+")\n";
				break;
			case "TYDEC" :
				//TODO
				// pas de parcours normalement
				break;
			case "IDBEG":
				// pas de parcours normalement
				if (tree.getChild(i).getChildCount()==2)
				{
					//on évalue l'expression
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
							codeAssembleur += traiterExpression(noeudAssignment.getChild(0));
							break;
					}
					//On récupère enfin l'adresse de la variable dans laquelle on veut ranger la valeur
					Variable v = (Variable)courante.get(tree.getChild(i).getChild(0).getText());
					codeAssembleur += "\t"+COMMENTAIRE_CHAR+"On recherche l'adresse de "+v.getName()+"\n";
					codeAssembleur += recupererAdresseVariable(v);
					//On range le résulat à l'adresse que l'on vient de récupérer
					codeAssembleur += "\tSTW R0, A2\n";

				}
				else if(tree.getChild(i).getChildCount()==1)
				{
					// cas d'une variable TODO
					Variable v = (Variable)courante.get(tree.getChild(i).getChild(0).getText());
					//on récupère l'adresse de la variable
					codeAssembleur += recupererAdresseVariable(v);
					//on 
					
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
				if(nbFils == 2) {		// si pas de ELSE le type de THEN doit être void
					codeAssembleur += parcourirArbre(tree.getChild(i).getChild(1));
				}
				if(nbFils == 3) {		// si pas de ELSE le type de THEN doit être void
					// gerer les sauts conditionnel 
					codeAssembleur += parcourirArbre(tree.getChild(i).getChild(1));
					codeAssembleur += parcourirArbre(tree.getChild(i).getChild(2));
				}
				// TODO
				break;
			case "break" :
				// TODO
				// pas de parcours normalement
				break;
			default:
				codeAssembleur += parcourirArbre(tree.getChild(i));//si on est pas dans les cas précédents,on crée une nouvelle table
				break;
			}

		}
		return codeAssembleur;
	}
	
	private String recupererAdresseVariable(Variable v)
	{
		
		/*Rappels:
			Nx:n° d’imbrication du bloc courant
			Ny:n° d'imbrication du bloc de déclaration
			Nz:n° d’imbrication de la variable
		« remonter » (Nx-Ny) chainage statiques
			MOVE #(Nx,Ny),D0
			MOVE A0,A2
		BOU	MOVE (depl_stat,A2),A2
			SUB #1,D0
			BNE BOU //branch if not equal
			LEA (depl,A2),A1*/
		String codeAssembleur="";
		int chainageARemonter=nombreDeChainageARemonter(v);
		codeAssembleur += "\tMOVE #("+chainageARemonter+"),D0\n";
		codeAssembleur += "\tMOVE A0,A2\n";
		codeAssembleur += "BOU\tMOVE (-4,A2),A2\n";//-4 correspond toujours à la taille d'une adresse
		codeAssembleur += "\tSUB #1,D0\n";//on retire 1 à la valeur dans D0
		codeAssembleur += "\tBNE BOU\n";//si D0 n'est pas égal à 0, on retourne à BOU
		codeAssembleur += "\tMOVE ("+v.getDeplacement()+",A2),A1\n";//on met dans les registre d'adresse A1 l'adresse pointée par A2 moins le déplacement de la variable
		return codeAssembleur;
	}
	
	/**
	 * Cette fonction retourne le nombre de chainage à remonter pour retrouver la variable passée en paramètre 
	 * @param v
	 * @return
	 */
	private int nombreDeChainageARemonter(Variable v)
	{
		int nx = courante.getNiveau();
		int ny = 0;
		return nx-ny;
	}
	
	/**
	 * Permet de générer le code qui évalue l'expression à droite de := lors de ASSIGNMENT ou VARDEC
	 * @param noeud noeud à partir du quel on évalue l'expression
	 * @return code assembleur correspondant
	 */
	private String traiterExpression(Tree noeud)
	{
		String codeAssembleur="";
		//TODO
		switch(noeud.getText())
		{
		case "+":
		case "-":
		case "*":
		case "/":
			
			break;
		case "INT":
			codeAssembleur+="\tLDW R0, #"+noeud.getChild(0).getText()+COMMENTAIRE_CHAR+"On stocke la valeur de l'entier dans R0\n";
			break;
		case "STRING":
			//TODO on alloue la chaine dans le tas
			break;
		}
		return codeAssembleur;
	}
	

	
	
}

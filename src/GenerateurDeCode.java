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
		codeAssembleur+="EXIT_EXC\tEQU\t64\n"; // n° d'exception de EXIT
		codeAssembleur+="READ_EXC\tEQU\t65\n"; 		// n° d'exception de READ (lit 1 ligne)
		codeAssembleur+="WRITE_EXC\tEQU\t66\n"; // n° d'exception de WRITE (affiche 1 ligne)
		codeAssembleur+="STACK_ADRS\tEQU\t0x1000\n"; // base de pile en 1000h (par exemple)
		// ces alias permettront de changer les réels registres utilisés
		codeAssembleur+="SP\tEQU R15\n"; // alias pour R15, pointeur de pile
		codeAssembleur+="WR\tEQU R14\n"; // Work Register (registre de travail)
		codeAssembleur+="BP\tEQU R13\n"; // frame Base Pointer (pointage environnement)
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
		codeAssembleur+="\tLDW SP, BP\n"; // abandon infos locales
		codeAssembleur+="\tLDW BP, (SP)+\n"; // charge BP avec ancien BP
		codeAssembleur+="\tTRP #EXIT_EXC\n"; // EXIT: arrête le programme*/
		
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
			case "FUNDEC":
				this.courante.incCompteurTDS();
				this.courante = this.courante.getFils(this.courante.getCompteurTDS()-1);
				Fonction f = (Fonction)courante.get(tree.getChild(i).getChild(0).getText());
				System.out.println(f.getName());
				courante = f.getTdsFonction();
				codeAssembleur += f.debutFonction();
				codeAssembleur += parcourirArbre(tree.getChild(i).getChild(tree.getChildCount()-1));
				codeAssembleur += f.finFonction();
				break;
			case "LET":
				this.courante.incCompteurTDS();
				this.courante = this.courante.getFils(this.courante.getCompteurTDS()-1);
				// TODO
				break;
			case "WHILE":
				this.courante.incCompteurTDS();
				this.courante = this.courante.getFils(this.courante.getCompteurTDS()-1);
				// TODO
				break;
			case "FOR":
				this.courante.incCompteurTDS();
				this.courante = this.courante.getFils(this.courante.getCompteurTDS()-1);
				// TODO
				break;
			case "VARDEC":
				//TODO
				break;
			case "TYDEC" :
				//TODO
				break;
			case "IDBEG":
				if (tree.getChild(i).getChildCount()==2)
				{
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
							break;
					}
				}
				else if(tree.getChild(i).getChildCount()==1)
				{
					// cas d'une variable TODO
				}
				break;
			case "NEGATION" :
				//TODO
				break;
			case "IFTHEN" :
				this.courante.incCompteurTDS();
				this.courante = this.courante.getFils(this.courante.getCompteurTDS()-1);
				// TODO
				break;
			case "break" :
				// TODO
				break;
			default:
				parcourirArbre(tree.getChild(i));//si on est pas dans les cas précédents,on crée une nouvelle table
				break;
			}

		}
		return codeAssembleur;
	}
	

	
	
}

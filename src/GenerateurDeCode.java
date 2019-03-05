import java.io.FileWriter;
import java.io.Writer;

import org.antlr.runtime.tree.CommonTree;

import tableSymbole.TableSymbolesAbs;

public class GenerateurDeCode {
	
	private TableSymbolesAbs tds;
	private CommonTree ast;
	
	public GenerateurDeCode(TableSymbolesAbs tds, CommonTree ast) {
		this.tds = tds;
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
		
		codeAssembleur+=tds.genererCode();//on génère tout le code 
		
		codeAssembleur+="\tLDW SP, BP\n"; // abandon infos locales
		codeAssembleur+="\tLDW BP, (SP)+\n"; // charge BP avec ancien BP
		codeAssembleur+="\tTRP #EXIT_EXC\n"; // EXIT: arrête le programme
		
		try {
			Writer writer=new FileWriter(nomFichier);
			writer.write(codeAssembleur);
			writer.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			// TODO: handle exception
		}
		return codeAssembleur;
	}

	
	
}

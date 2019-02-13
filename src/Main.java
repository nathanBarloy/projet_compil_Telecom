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

	public static void main(String[] args) throws FileNotFoundException, IOException, RecognitionException {
		String path = "Tests/testsSemantiques/testNegation/nonFonctionnel/test1.tig";
		AnalyseurSemantique as=new AnalyseurSemantique(path);
		System.out.println(as.analyser().toString());
	}

	
}

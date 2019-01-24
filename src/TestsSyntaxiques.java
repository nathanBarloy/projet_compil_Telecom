import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.*;


import org.junit.Test;

public class TestsSyntaxiques {

	private final String REPERTOIRETEST="Tests/testsSyntaxiques/";
	/*@Before
	public void setUp() throws Exception {
	}*/

	@Test
	public void testsFournis() throws IOException
	{
		System.out.println("Test fournis:");
		String rep="testProf/";
		executeOnDir(REPERTOIRETEST+rep);
	}
	@Test
	public void testCommentaires() throws IOException{
		System.out.println("Test des commentaires:");
		String rep="testCommentaires/";
		executeOnDir(REPERTOIRETEST+rep);
	}
	@Test
	public void testExp() throws IOException{
		String rep="testExp/";
		System.out.println("Test sur les expressions correctes:");
		executeOnDir(REPERTOIRETEST+rep);		
	}
	@Test
	public void testDec() throws IOException
	{
		String rep="testDec/";
		System.out.println("Tests sur les déclarations");
		executeOnDir(REPERTOIRETEST+rep);		
	}
	@Test
	public void forExp() throws IOException
	{
		String rep="forExp/";
		System.out.println("Test sur une boucle for");		
		executeOnDir(REPERTOIRETEST+rep);		

	}
	@Test
	public void idBegin() throws IOException
	{
		String rep="idBegin/";
		System.out.println("Tests sur les règles de idBegin");		
		executeOnDir(REPERTOIRETEST+rep);		
	}
	@Test
	public void ifThen() throws IOException
	{
		String rep="ifThen/";
		System.out.println("Tests sur les blocs conditionnels");		
		executeOnDir(REPERTOIRETEST+rep);		
	}
	@Test
	public void letExp() throws IOException
	{
		String rep="letExp/";
		System.out.println("Tests sur les blocs LET");		
		executeOnDir(REPERTOIRETEST+rep);		
	}
	@Test
	public void testAssignement() throws IOException
	{
		String rep="testAssignement/";
		System.out.println("Tests sur les assignements");		
		executeOnDir(REPERTOIRETEST+rep);		
	}
	@Test
	public void testNegation() throws IOException
	{
		String rep="testNegation/";
		System.out.println("Tests sur la negation");		
		executeOnDir(REPERTOIRETEST+rep);		
	}
	@Test
	public void whileExp() throws IOException
	{
		String rep="letExp/";
		System.out.println("Tests sur le blocs while");		
		executeOnDir(REPERTOIRETEST+rep);		
	}
	@Test
	public void comparaison() throws IOException
	{
		String rep="comparaison/";
		System.out.println("Tests sur des opérateur de comparaison");		
		executeOnDir(REPERTOIRETEST+rep);		
	}
	@Test
	public void operations() throws IOException
	{
		String rep="operations/";
		System.out.println("Tests sur des opérateur d'operation");		
		executeOnDir(REPERTOIRETEST+rep);		
	}
	
	/*@Test
	public void testIncorrectsExp() throws IOException{
		System.out.println("testExp/incorrects");
		String rep="testExp/incorrects";
		for(int i=1;i<=numberOfFiles(rep);i++)
		{
			ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(this.rep+rep+"test"+i+".tig"));
	        TigerLexer lexer = new TigerLexer(input);
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	        TigerParser parser = new TigerParser(tokens);
	        try {
				parser.program();
			} catch (RecognitionException e) {
				e.printStackTrace();
			}
		}
	}*/
	
	public int numberOfFiles(String path)
	{
		return new File(path).listFiles().length;
	}
	
	public ArrayList<File> filesInPath(String path)
	{
		ArrayList<File> res=new ArrayList<File>();
		File[] fichiers=new File(path).listFiles();
		for(File fichier:fichiers)
		{
			if(fichier.isFile())
			{
				res.add(fichier);
			}
		}
		return res;
	}
	
	/**
	 * Execute tout les tests du dossier dont le chemin est passé en paramètre
	 * @param path chemin du dossier
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void executeOnDir(String path) throws FileNotFoundException, IOException
	{
		System.out.println("Répertoire de test:"+path+"\tNombre de fichiers:"+numberOfFiles(path));
		ArrayList<File> fichiersFonctionnels=filesInPath(path+"fonctionnels");
		for(File fichier:fichiersFonctionnels)
		{
			executeTestFonctionnel(fichier);
		}
		ArrayList<File> fichiersNonFonctionnels=filesInPath(path+"nonFonctionnels");
		for(File fichier:fichiersNonFonctionnels)
		{
			executeTestNonFonctionnel(fichier);
		}
	}
	
	public void executeTestFonctionnel(File fichier) throws FileNotFoundException, IOException
	{
		System.out.println("\tFichier du chemin en test:"+fichier.getAbsolutePath());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(baos);
	    PrintStream err = System.err;
	    System.setErr(ps);
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(fichier));
        TigerLexer lexer = new TigerLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TigerParser parser = new TigerParser(tokens);
        try {
			parser.program();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
      //on restaure out
        String res=baos.toString();
	    assertEquals("", baos.toString());
	    System.setErr(err);
	    System.err.println(res);
	}
	
	public void executeTestNonFonctionnel(File fichier) throws FileNotFoundException, IOException
	{
		System.out.println("\tFichier du chemin en test:"+fichier.getAbsolutePath());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(baos);
	    PrintStream err = System.err;
	    System.setErr(ps);
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(fichier));
        TigerLexer lexer = new TigerLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TigerParser parser = new TigerParser(tokens);
        try {
			parser.program();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
      //on restaure out
        String res=baos.toString();
	    assertNotEquals("", baos.toString());
	    System.setErr(err);
	    System.err.println(res);
	}
	/*@Test
	public void testGeneral() throws FileNotFoundException, IOException
	{
		System.out.println("Test général: parcours de tout les répertoire de Test");
		//on parcours tout les répertoires de Test
		File[] dossiersTest=new File(this.REPERTOIRETEST).listFiles();
		for(File element:dossiersTest)
		{
			if(element.isDirectory())//si on a un répertoire
			{
				for(File fichier:filesInPath(element.getAbsolutePath()))
				{
					executeTest(fichier);
				}
			}
		}
	}*/
}
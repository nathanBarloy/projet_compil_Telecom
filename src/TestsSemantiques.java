import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.junit.Before;
import org.junit.Test;

public class TestsSemantiques {

	private final String REPERTOIRETEST="Tests/testsSemantiques/";
	
	@Test
	public void testsBreak() throws IOException
	{
		String rep="testBreak/";
		executeOnDir(REPERTOIRETEST+rep);
	}
	@Test
	public void testsCoherenceType() throws IOException
	{
		String rep="testCoherenceType/";
		executeOnDir(REPERTOIRETEST+rep);
	}
	@Test
	public void testsComparateurInfSup() throws IOException
	{
		String rep="testComparateurInfSup/";
		executeOnDir(REPERTOIRETEST+rep);
	}
	@Test
	public void testsIdentificateurDejaExistant() throws IOException
	{
		String rep="testDeclarationIdentificateurDejaExistant/";
		executeOnDir(REPERTOIRETEST+rep);
	}
	@Test
	public void testsDeclarationType() throws IOException
	{
		String rep="testDeclarationType/";
		executeOnDir(REPERTOIRETEST+rep);
	}
	@Test
	public void testsFor() throws IOException
	{
		String rep="testFor/";
		executeOnDir(REPERTOIRETEST+rep);
	}
	@Test
	public void testsIDBEG() throws IOException
	{
		String rep="testIDBEG/";
		executeOnDir(REPERTOIRETEST+rep);
	}
	@Test
	public void testsIfThen() throws IOException
	{
		String rep="testIfThen/";
		executeOnDir(REPERTOIRETEST+rep);
	}
	@Test
	public void testsNegation() throws IOException
	{
		String rep="testNegation/";
		executeOnDir(REPERTOIRETEST+rep);
	}
	@Test
	public void testsOperations() throws IOException
	{
		String rep="testOperations/";
		executeOnDir(REPERTOIRETEST+rep);
	}
	@Test
	public void testsOperationEgEq() throws IOException
	{
		String rep="testOperationsEgEq/";
		executeOnDir(REPERTOIRETEST+rep);
	}
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
		AnalyseurSemantique as=new AnalyseurSemantique(fichier.getAbsolutePath());
        as.analyser();
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
	    AnalyseurSemantique as=new AnalyseurSemantique(fichier.getAbsolutePath());
        as.analyser();
      //on restaure out
        String res=baos.toString();
	    assertNotEquals("", baos.toString());
	    System.setErr(err);
	    System.err.println(res);
	}

}

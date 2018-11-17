import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.antlr.runtime.*;


import org.junit.Test;

public class Tests {

	private String rep="Tests/";
	/*@Before
	public void setUp() throws Exception {
	}*/

	@Test
	public void testsFournis() throws IOException
	{
		String rep="testProf/";
		System.out.println("Nombre de fichiers de test:"+numberOfFiles(this.rep+rep));
		for(int i=1;i<=numberOfFiles(this.rep+rep);i++)
		{
			System.out.println(this.rep+rep+"test"+i+".tig");
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
		    PrintStream ps = new PrintStream(baos);
		    PrintStream err = System.err;
		    System.setErr(ps);
			ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(this.rep+rep+"prog"+i+".txt"));
	        TigerLexer lexer = new TigerLexer(input);
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	        TigerParser parser = new TigerParser(tokens);
	        try {
				parser.program();
			} catch (RecognitionException e) {
				e.printStackTrace();
			}
	      //on restaure out
	        System.out.flush();
		    System.setErr(err);
		    assertEquals(0, baos.toString().length());
		}
	}
	@Test
	public void testCommentaires() throws IOException{
		System.out.println("testCommentaires");
		String rep="testCommentaires/";
		for(int i=1;i<=numberOfFiles(this.rep+rep);i++)
		{
			System.out.println(this.rep+rep+"test"+i+".tig");
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
		    PrintStream ps = new PrintStream(baos);
		    PrintStream err = System.err;
		    System.setErr(ps);
			ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(this.rep+rep+"test"+i+".tig"));
	        TigerLexer lexer = new TigerLexer(input);
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	        TigerParser parser = new TigerParser(tokens);
	        try {
				parser.program();
			} catch (RecognitionException e) {
				e.printStackTrace();
			}
	      //on restaure out
	        System.out.flush();
		    System.setErr(err);
		    assertEquals(0, baos.toString().length());
		}
	}
	@Test
	public void testCorrectsExp() throws IOException{
		String rep="testExp/corrects/";
		System.out.println("Nombre de fichiers de test:"+numberOfFiles(this.rep+rep));
		for(int i=1;i<=numberOfFiles(this.rep+rep);i++)
		{
			System.out.println(this.rep+rep+"test"+i+".tig");
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
		    PrintStream ps = new PrintStream(baos);
		    PrintStream err = System.err;
		    System.setErr(ps);
			ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(this.rep+rep+"test"+i+".tig"));
	        TigerLexer lexer = new TigerLexer(input);
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	        TigerParser parser = new TigerParser(tokens);
	        try {
				parser.program();
			} catch (RecognitionException e) {
				e.printStackTrace();
			}
	      //on restaure out
	        System.out.flush();
		    System.setErr(err);
		    assertEquals(0, baos.toString().length());
		}
		
		
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
	

}
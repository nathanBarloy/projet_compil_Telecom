import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.antlr.runtime.*;


import org.junit.Test;

public class Tests {

	private String rep="Tests/";
	/*@Before
	public void setUp() throws Exception {
	}*/

	@Test
	public void testCommentaires() throws IOException{
		System.out.println("testCommentaires");
		String rep="testCommentaires/";
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(this.rep+rep+"test1.tig"));
        TigerLexer lexer = new TigerLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TigerParser parser = new TigerParser(tokens);
        try {
			parser.program();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testCorrectsExp() throws IOException{
		String rep="testExp/corrects/";
		System.out.println("Nombre de fichiers de test:"+numberOfFiles(this.rep+rep));
		for(int i=1;i<=numberOfFiles(this.rep+rep);i++)
		{
			System.out.println(this.rep+rep+"test"+i+".tig");
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
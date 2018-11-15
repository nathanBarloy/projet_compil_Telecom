import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;

import org.antlr.runtime.*;


import org.junit.Test;

public class Tests {

	/*@Before
	public void setUp() throws Exception {
	}*/

	@Test
	public void testCommentaires() throws IOException{
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream("Tests/testCommentaires/test1.tig"));
        TigerLexer lexer = new TigerLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TigerParser parser = new TigerParser(tokens);
        try {
			parser.program();
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
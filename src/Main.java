import tableSymbole.TableSymbolesAbs;

public class Main {

	public static void main(String[] args) {
		//String path = "Tests/testsSyntaxiques/testDec/fonctionnels/functionDeclaration.tig";
		String path = "Tests/testsSyntaxiques/testProf/fonctionnels/prog1.txt";
		AnalyseurSemantique as=new AnalyseurSemantique(path);
		TableSymbolesAbs tdsRes=as.analyser();
		System.out.println(tdsRes.toString());
		
	}

	
}

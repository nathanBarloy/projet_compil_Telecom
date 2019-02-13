public class Main {

	public static void main(String[] args) {
		String path = "Tests/testsSyntaxiques/testDec/fonctionnels/varDeclaration.tig";
		AnalyseurSemantique as=new AnalyseurSemantique(path);
		System.out.println(as.analyser().toString());
	}

	
}

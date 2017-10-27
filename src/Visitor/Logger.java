package Visitors;

public class Logger implements Log {

	public void printLog(Node node) {
	
		System.out.println(node.textualRepresentation());
	}

}

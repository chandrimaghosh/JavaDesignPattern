package Visitors;

public interface Node {

	public String textualRepresentation();

	public int accept(NodeCountVisitor nv);
	
	

}

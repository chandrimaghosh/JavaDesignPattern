package Visitors;

public interface NodeVisitor {

	public int visitHTML(Html html);
	
	public int visitHead(Head head);
	
	public int visitBody(Body body);
	
	public int visitB(B b);
	
	public int visitDiv(Div div);
	
	public int visitTitle(Title title);
}

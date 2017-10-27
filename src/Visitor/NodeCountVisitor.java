package Visitors;

public class NodeCountVisitor implements NodeVisitor {
	
	public int visitHTML(Html html) {
		Html.htmlCount++;
		return Html.htmlCount;
	}
	
	public int visitHead(Head head) {
		Head.headCount++;
		return Head.headCount;
	}
	
	public int visitBody(Body body) {
		Body.bodyCount++;
		return Body.bodyCount;
	}
	
	public int visitB(B b) {
		B.bCount++;
		return B.bCount;
	}
	
	public int visitDiv(Div div) {
		Div.divCount++;
		return Div.divCount;
	}
	
	public int visitTitle(Title title) {
		Title.titleCount++;
		return Title.titleCount;
	}

}

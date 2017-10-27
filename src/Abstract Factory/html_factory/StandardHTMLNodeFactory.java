package html_factory;

import java.util.ArrayList;
import java.util.Map;

public class StandardHTMLNodeFactory extends AbstractHTMLNodeFactory {

	public Node getNode(String nodeName, ArrayList<Node> listOfNodes, Map<String, String> attributesMap, String display) {
		if(nodeName == null || nodeName == "")
			return null;
		if(nodeName.equalsIgnoreCase("HTML"))
				return new Html(listOfNodes, attributesMap, display);
		if(nodeName.equalsIgnoreCase("Head"))
			return new Head(listOfNodes, attributesMap, display);
		if(nodeName.equalsIgnoreCase("Title"))
			return new Title(listOfNodes, attributesMap, display);
		if(nodeName.equalsIgnoreCase("Body"))
			return new Body(listOfNodes, attributesMap, display);
		if(nodeName.equalsIgnoreCase("Div"))
			return new Div(listOfNodes, attributesMap, display);
		if(nodeName.equalsIgnoreCase("B"))
			return new B(listOfNodes, attributesMap, display);
		return null;
	}
	
	public Log getLogger() {
		return null;
	}
	
	
}

package html_factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractHTMLNodeFactory {

	// abstract method getNode() from StandardHTMLNodeFactory:
	public abstract Node getNode(String node, ArrayList<Node> listOfNodes, Map<String, String> map, String string);
	
	// abstract method printLog() from LoggingHTMLFactory:
	public abstract Log getLogger();
}

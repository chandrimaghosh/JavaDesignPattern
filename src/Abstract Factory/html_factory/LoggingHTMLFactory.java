package html_factory;

import java.util.ArrayList;
import java.util.Map;

public class LoggingHTMLFactory extends AbstractHTMLNodeFactory {
	
	public Log getLogger() {
		return new Logger();
//		if(logger == "" || logger == null)
//			return null;
//		if(logger.equalsIgnoreCase("Logger"))
//			
//		return null;
	}
	
	public Node getNode(String nodeName, ArrayList<Node> listOdNodes, Map<String, String> attributesMap, String display) {
		return null;
	}

	
}

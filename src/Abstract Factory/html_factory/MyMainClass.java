/*
 * The main class does following things:
 * 			1. Creates parameters such as map for attributes, string to display and list of nodes
 * 			2. Get the instance of StandardHTMLNodeFactory using FactoryProducer.getFactory("Node")
 * 			3. Get the instance of LoggingHTMLNodeFactory using FactoryProducer.getFactory("Log")
 * 			4. Get instances of following types of Nodes: {Html, Head, Title, Body, Div, B}
 * 			5. While instantiating the Nodes pass the following parameters: 
 * 					String nameNode: <Name of the Node>,
 * 					ArrayList<Node>: <List of Node inside the current node> 
 * 					Map<String, String>: <List of attributes and their values for the current node>
 * 					String display: <Stringt to be displayed as text in the current node>
 * 			*Note: Pass null where no parameter is to be given,  Example:			
 * 					Node html = standardHtml.getNode("HTML", listOfNodes, attributesMap, "In HTML Tag");
 * 					Node head = standardHtml.getNode("HEAD", null, null, "In HEAD Tag");
 * 
 *  Created by: "PATRICIA BAGZAI"
 * 
 * */

package html_factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MyMainClass {

	public static StringBuffer sb = new StringBuffer();
	public static void main(String args[]) {

		// Create attributes:

		ArrayList<Node> listOfNodes = new ArrayList<Node>();
		ArrayList<Node> emptyListOfNodes = new ArrayList<Node>();
	
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "Id_1");
		map.put("class", "class_1");

		Map<String, String> emptyMap = new HashMap<String, String>();

		// Get instance of StandardHTMLNode Factory:
		AbstractHTMLNodeFactory standardHTML = FactoryProducer.getFactory("Node");
		AbstractHTMLNodeFactory loggingHTML = FactoryProducer.getFactory("Logger");

		// Get instance of Logger:
		Log logger = loggingHTML.getLogger();
		
		// Get instances of desired Nodes:
		Node b = standardHTML.getNode("B", emptyListOfNodes, emptyMap, "In B");
		logger.printLog(b);
		
		Node div = standardHTML.getNode("Div", emptyListOfNodes, map, "In Div");
		logger.printLog(div);
		
		
		listOfNodes.add(b);
		listOfNodes.add(div);
		Node html = standardHTML.getNode( "HTML", listOfNodes, map, "In HTML");
		logger.printLog(html);
		
	}
}

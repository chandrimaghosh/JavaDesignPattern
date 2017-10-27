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
 * 
 * 			6. readFile(String fileName, NodeCountVisitor nv): reads a file and prints total count of each node
 * 
 * Ways to run:
 * 			*Note:  Pass null where no parameter is to be given,  Example:			
 * 					Node html = standardHtml.getNode("HTML", listOfNodes, attributesMap, "In HTML Tag");
 * 					Node head = standardHtml.getNode("HEAD", null, null, "In HEAD Tag");
 * 					*Please set the file path in the variable fileName in the main()
 * 					
 * 
 *  Created by: "PATRICIA BAGZAI"
 * 
 * */

package Visitors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MyMainClass {

	// reads a file prints to determine number of nodes of each type: 
	public void readFile(String filename, NodeCountVisitor nv)
	{
		List<Node> nodes = new ArrayList<Node>();
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = reader.readLine()) != null)
			{
				// iterates over each word in line to find a node:
				checkForNode(line, nv);

			}
			reader.close();
			//  return records;
		}
		catch (Exception e)
		{
			System.err.format("Exception occurred trying to read '%s'.", filename);
			e.printStackTrace();
			//return null;
		}
	}

	// iterates over each word in line to find a node:
	public void checkForNode(String line, NodeCountVisitor nv) {
		List<Node> list = new ArrayList<Node>();
		if(isPresent("<html", line)) {
			Node html = new Html(null, null, "");
			System.out.println("Html Count: "+html.accept(nv));
		}
		if(isPresent("<head", line)) {
			Node head = new Head(null, null, "");
			System.out.println("Head Count: "+head.accept(nv));
		}
		if(isPresent("<title", line)) {
			Node title = new Title(null, null, "");
			System.out.println("Title Count: "+title.accept(nv));
		}

		if(isPresent("<body", line)) {
			Node body = new Body(null, null, "");
			System.out.println("Body Count: "+body.accept(nv));
		}

		if(isPresent("<div", line)) {
			Node div = new Div(null, null, "");
			System.out.println("Div Count: "+div.accept(nv));
		}

		if(isPresent("<b", line)) {
			Node b = new B(null, null,"");
			System.out.println("B Count: "+b.accept(nv));
		}

	}

	// returns true if node present in the given line from document:
	public boolean isPresent(String word, String line)
	{
		if (line.toLowerCase().contains(word.toLowerCase()))
			return true;
		else
			return false;
	}


	// please uncomment to test the methods():
	public static void main(String args[]) {

		// Create attributes:

		//		ArrayList<Node> listOfNodes = new ArrayList<Node>();
		//		ArrayList<Node> emptyListOfNodes = new ArrayList<Node>();
		//
		//		Map<String, String> map = new HashMap<String, String>();
		//		map.put("id", "Id_1");
		//		map.put("class", "class_1");
		//
		//		Map<String, String> emptyMap = new HashMap<String, String>();
		//
		//		// Get instance of StandardHTMLNode Factory:
		//		AbstractHTMLNodeFactory standardHTML = FactoryProducer.getFactory("Node");
		//		AbstractHTMLNodeFactory loggingHTML = FactoryProducer.getFactory("Logger");
		//
		//		// Get instance of Logger:
		//		Log logger = loggingHTML.getLogger();
		//
		//		// Get instances of desired Nodes:
		//		Node b = standardHTML.getNode("B", emptyListOfNodes, emptyMap, "In B");
		//		logger.printLog(b);
		//
		//		Node div = standardHTML.getNode("Div", emptyListOfNodes, map, "In Div");
		//		logger.printLog(div);
		//
		//
		//		listOfNodes.add(b);
		//		listOfNodes.add(div);
		//		Node html = standardHTML.getNode( "HTML", listOfNodes, map, "In HTML");
		//		logger.printLog(html);


		// try Visitor:

		String filename = "C:\\Users\\Patricia\\Desktop\\test.txt";
		
		// instantiate NodeCountVisitor class:
		NodeCountVisitor nv = new NodeCountVisitor();
		
		// instantiate MainClass:
		MyMainClass classObject = new MyMainClass();
		
		// invoke readFile():
		classObject.readFile(filename, nv);


	}
}

package html;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MyMainClass {

	public static StringBuffer sb = new StringBuffer();
	public static void main(String args[]) {

		// Create attributes:
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "Id_1");
		map.put("class", "class_1");

		Map<String, String> emptyMap = new HashMap<String, String>();

		ArrayList<Node> listOfNodes = new ArrayList<Node>();
		ArrayList<Node> emptyListOfNodes = new ArrayList<Node>();
		ArrayList<Node> listOfNodesForHead = new ArrayList<Node>();

		// Get instances of desired Nodes:
		Node body = new Body(emptyListOfNodes, map, "In Body");
		Node title = new Title(listOfNodes, map, "In title");
		listOfNodesForHead.add(title);

		Node head = new Head(listOfNodesForHead, emptyMap, "In Head");
		
		listOfNodes.add(head);
		listOfNodes.add(body);
		Node html = new Html(listOfNodes, emptyMap, "In Html");
		System.out.println(html.textualRepresentation());
	}
}

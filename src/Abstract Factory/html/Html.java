package html;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Html implements Node {

	// Data members :

	// Map for current tag attributes: 
	private Map<String, String> hashMap = new HashMap<String, String>();
	private TreeMap<String, String> sortedMap = new TreeMap<String, String>(); // To sort it alphabetically
	
	// ArrayList for multiple tags under this tag:
	private List<Node> listOfNodes = new ArrayList<Node>();
	private String display;
	private Node node;
	private String startHTMLTag = "<html";
	private String endHTMLTag = "</html>";
	
	
	// Parameterized constructor with ArrayList for Nodes, Map for attributes and String to display:
	public Html(ArrayList<Node> nodes, Map attributesMap, String s) {
		this.listOfNodes = nodes;
		this.hashMap = attributesMap;
		// convert the attributes HashMap to TreeMap for sorted order:
		this.sortedMap = new TreeMap<String, String>(hashMap);
		this.display = s;
	}
	
	// Parameterized constructor with Map for attributes and String to display:
	public Html(Map attributesMap, String s) {
		this.hashMap = attributesMap;
		// convert the HashMap to TreeMap for sorted order: 
		this.sortedMap = new TreeMap<String, String>(hashMap);
		this.display = s;
	}

	// Parameterized constructor with map for attributes and Object of concrete classes:
	public Html(Map attributesMap, ArrayList<Node> nodes) {
		this.listOfNodes = nodes;
		this.hashMap = attributesMap;
		// convert the HashMap to TreeMap for sorted order:
		this.sortedMap = new TreeMap<String, String>(hashMap);
		this.node = node;
	}

	public Map<String, String> getHashMap() {
		return hashMap;
	}

	public void setHashMap(Map<String, String> hashMap) {
		this.hashMap = hashMap;
		// convert the HashMap to TreeMap for sorted order: 
		this.sortedMap = new TreeMap<String, String>(hashMap);
	}

	public List<Node> getListOfNodes() {
		return listOfNodes;
	}

	public void setListOfNodes(List<Node> listOfNodes) {
		this.listOfNodes = listOfNodes;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	
	
	public String textualRepresentation() {
	
		StringBuffer sb = new StringBuffer();
		String addAttributes = "";
		String addTag = "";
		sb.append(startHTMLTag);
	
		// check if current tag contains attributes:
		if(this.sortedMap != null) {
			addAttributes = Common.convertMapAttributesToString(this.sortedMap);		
			sb.append(addAttributes);
		}
		
	
		// check if current includes another tag:
		if(this.listOfNodes != null) {
			for(Node node: listOfNodes) {
				addTag = node.textualRepresentation();
				// append the attributes:
				sb.append(addTag);
			}
		}
		
		if(this.display != null)
			sb.append(this.display);
		sb.append(endHTMLTag);
		return sb.toString();
	}
	
}
	


package Visitors;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Common {
	
	private static char quote = '"';
	private static char equalsTo = '=';
	private static char greaterThan = '>';
	private static char lessThan = '<';
	private static char space = ' ';
	
	// Return String for attributes and its values:
	public static String convertMapAttributesToString(Map map) {
		StringBuffer sb = new StringBuffer();
		 
		// Getting a Set of Key-value pairs
		Set entrySet = map.entrySet();

		// Obtaining an iterator for the entry set
		Iterator it = entrySet.iterator();

		while(it.hasNext()){
			Map.Entry me = (Map.Entry)it.next();
			sb.append(space);
			sb.append(me.getKey());
			sb.append(equalsTo);
			sb.append(quote);
			sb.append(me.getValue());
			sb.append(quote);
		}
		sb.append(greaterThan);
		return sb.toString();
	}

}

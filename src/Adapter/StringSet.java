package Solution3;

import java.util.Iterator;

public class StringSet implements Set<String> {
	public void add(String s){ ... }
	public void addAll(Set<String> s){ ... }
	public void remove(String s){ ... }
	public int size(){ ... }
	public Iterator<String> iterator(){ ... }
	private BitVector adaptee = new BitVector();
}


package Solution2;

public interface Iterator<Integer> {

	// set the initial index:
	public void first();
	
	// increments the currentIndex:
	public void next();
	
	// returns true if entire list is traversed, else false:
	public boolean isDone(BitVector bv);
	
	// returns the value of bitVector[currentIndex]: 
	public int current(BitVector bv);

	// returns current index:
	public int getCurrentIndex();
}

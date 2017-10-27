/*
 * Implementation of BitVector and Iterator Design Pattern:
 * 		Iterator Interface: Iterator.java
 * 		Container Interface: BitVectorInterface.java
 * 		Container Class: BitVector.java
 * 		IteratorImplementation: private class IteratorImplementation in BitVector.java
 * 		findBits(bitvector[index], currentIndex): returns list of bits with value "1" 
 * 
 * Ways to run: Please uncomment the statements in main() to test all the methods and functionalities:
 * 				You may change the values of input set with any random integers.
 * 				*Note: Uncomment the part which sorts the given input 
 * */

package Solution2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainClass {

	
	public static void main(String args[]) {
		
		int inputSet[] = {48,33,19,21,53,7,24,40,45,14,47,31};
		int inputSet1[] = {1,2,3,33};
		
		// Sort the input array:
		List<Integer> sortedList = new ArrayList<Integer>();
		for(int i=0; i<inputSet.length; i++) {
			sortedList.add(inputSet[i]);
		}

		Collections.sort(sortedList);

		// Instantiate BitVector and pass the largest number from the input set: 
		BitVector bit = new BitVector(sortedList.get(sortedList.size()-1));
		for(int i: inputSet) {
			bit.set(i);
		}

//		BitVector bit1 = new BitVector(inputSet1[3]);
//		for(int i: inputSet1) {
//			bit1.set(i);
//		}

//		// execute get(int i):
//		System.out.println("In get(): "+ bit.get(35));

//		// execute clear(int i):
		bit.clear(48);
		System.out.println("After clear: "+bit.get(48));
		System.out.println("After clear: "+bit.get(40));

		
//		// execute addAll():
//		bit.addAll(bit1);
	
		

		// Iterate over binaryRepresentation:
		List<Integer> list = new ArrayList<Integer>();
		
		Iterator<Integer> iter = bit.iterator();
		for(iter.first(); !(iter.isDone(bit)); iter.next()) {
			//System.out.println("currentIndex: "+ iter.getCurrentIndex());
			
			// findBits() returns list of bits with value "1":
			list = bit.findBits(iter.current(bit), iter.getCurrentIndex());
			if (list != null) {
				for(int i: list) {
					System.out.println("Bits: "+i);
				}
			}
		} 

	}
}

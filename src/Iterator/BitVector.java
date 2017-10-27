package Solution2;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


// Concrete class Implementing Container Interface: BitVectorInterface
public class BitVector implements BitVectorInterface {

	int binaryRepresentation[] = null;

	// Constructor to set the size of binaryRepresentation:
	public BitVector(int largest) {
		int size = largest/32;
		binaryRepresentation = new int[size+1];

		// initialize the array with 0's:
		for(int i=0; i<size; i++) {
			binaryRepresentation[i] = 0;
		}
	} 

	// set() will set the bits as 1 at given index:
	public void set (int i) {
		int index = 0;
		if(i != 0)
			index = i / 32;

		// Perform ORing to change the bit to 1: 
		binaryRepresentation[index] = binaryRepresentation[index] | (1 << i);
	}

	// returns true if the given bit is set to "1":
	public boolean get(int i) {
		int index = 0;
		if(i != 0)
			index = i/32;

		// check if binaryRepresentation has not set the index for i:
		if(binaryRepresentation.length <= (i / 32))
			return false;
		// check if binary representation is long enough to store the input number:
		if(Integer.toBinaryString(binaryRepresentation[index]).length() <= (i % 32))
			return false;

		int len = Integer.toBinaryString(binaryRepresentation[index]).length();
		int pos = i % 32;
		int checkForIndex =  len - pos - 1; 
		// check if binary representation has "1" at the index:
		if(Integer.toBinaryString(binaryRepresentation[index]).charAt(checkForIndex) == '1')
			return true;

		// Error:
		return false;
	}

	// clear() will set the given bit to "0":
	public void clear(int i) {
		int index = 0; 
		if(get(i)) {
			if(i != 0) {
				index = i/32;
				// perform AND operation with 0's to change the given bit to "0":
				binaryRepresentation[index] = binaryRepresentation[index] & (0 << i);
			}
		}
	}


	// addAll() implementation:
	public void addAll(BitVector b) {
		if((this.binaryRepresentation.length != 0) || (b.binaryRepresentation.length != 0)) {
			int smaller;
			// find out the smaller array out of two:
			if(this.binaryRepresentation.length < b.binaryRepresentation.length) {
				// if current array is smaller add
				smaller = this.binaryRepresentation.length;
				for (int i=0; i<smaller; i++) {
					b.binaryRepresentation[i] = b.binaryRepresentation[i] | this.binaryRepresentation[i];
				}
				this.binaryRepresentation = b.binaryRepresentation;
			}
			else {
				// if current bitVector.length is greater than second bit vector:
				smaller = b.binaryRepresentation.length;
				for (int i=0; i<smaller; i++) {
					this.binaryRepresentation[i] = this.binaryRepresentation[i] | b.binaryRepresentation[i];
				}
			}
		}
	}


	// return list of bits with value "1":
	public List<Integer> findBits(int binaryRepresentation, int index) {
//		if(binaryRepresentation == null || binaryRepresentation == "")
//			return null;

		String binaryRepresentationString = Integer.toBinaryString(binaryRepresentation);
		// initialize the list which will store the bits with value "1":
		List<Integer> list = new ArrayList<Integer>();
		int len = binaryRepresentationString.length();

		// iterate over the given binary string and find the position of bits with value "1":
		for(int i=0; i<len; i++) {
			if(binaryRepresentationString.charAt(i) == '1') {
				list.add((index*32)+ (len - i - 1));
			}
		}
		return list;
	}


	// prints the binary representation of given value:
	public void printBRep() {
		for (int i=0; i< this.binaryRepresentation.length; i++) {
			System.out.println(Integer.toBinaryString(this.binaryRepresentation[i]));
		}
	}



	// Inner class implementing Iterator Interface:
	private class IteratorImplementation implements Iterator {

		int currentIndex;



		// set initial index:
		public void first() {
			currentIndex = 0;
		}

		// increment the index:
		public void next() {
			currentIndex ++;
		}

		// returns current index:
		public int getCurrentIndex() {
			return currentIndex;
		}

		// return true if list is traversed completely:
		public boolean isDone(BitVector bv) {
			return (currentIndex == bv.binaryRepresentation.length);
		}

		// returns the value of bitVector[currentIndex]:
		public int current(BitVector bv) {
			return bv.binaryRepresentation[currentIndex];
		}
	}


	// @Override:
	public Iterator<Integer> iterator() {
		return new IteratorImplementation();
	}


}

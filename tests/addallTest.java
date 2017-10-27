import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import Solution2.BitVector;

public class addallTest {

	@Test
	public void test() {
		int inputSet[] = {0,1,5,35,37};
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
		
		// execute get(int i):
		assertEquals(bit.get(35), true);

		
	}

}

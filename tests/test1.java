import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import html.B;
import html.Div;

public class test1 {

	@Test
	public void test1(){
		Map<String,String> divAtts = new HashMap<String,String>();
		divAtts.put("id", "second");
		divAtts.put("class", "bar");
		Div div = new Div(divAtts, "b");
		Map<String,String> noAttributes = new HashMap<String,String>();
		B b = new B(noAttributes, div);
		assertEquals(b.textualRepresentation(), "<b><div class=bar id=second>b</div></b>");
	}
}

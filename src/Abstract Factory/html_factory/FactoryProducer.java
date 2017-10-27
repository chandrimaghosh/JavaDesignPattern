package html_factory;

public class FactoryProducer {

	public static AbstractHTMLNodeFactory getFactory(String s) {
		if(s == null || s == "")
			return null;
		if(s.equalsIgnoreCase("Node"))
			return new StandardHTMLNodeFactory();
		if(s.equalsIgnoreCase("Logger"))
			return new LoggingHTMLFactory();
		return null;
	}
}

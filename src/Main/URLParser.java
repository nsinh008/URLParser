package Main;

import java.util.Map;

import Parser.QueryArguementsParser;
import Parser.URLFieldsModel;
import Parser.URLParserMethods;

public class URLParser {
	
	public static void main(String[] args) {		
		URLParserMethods urlParser= new URLParserMethods();
		URLFieldsModel fieldsMap = urlParser.parseAllFields(args[0]);
		
		QueryArguementsParser argsParser = new QueryArguementsParser();
		Map<String, String> queryArgValues = argsParser.argumentValueParser(fieldsMap.getArgsQuery());
		System.out.println("Parsed URL : " + fieldsMap.toString());
		System.out.println("Query Arguments Values: "+ queryArgValues);
	}
}

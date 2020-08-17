package JUnitTests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Parser.URLFieldsModel;
import Parser.URLParserMethods;

class JUnitTests {

	@Test
	void testParseURLAllfields() {
		URLParserMethods parseMethods = new URLParserMethods();
		URLFieldsModel fieldMap = parseMethods.parseAllFields("protocol://user:password@host:port/path/document?arg1=val1&arg2=val2#part");
		assertEquals(fieldMap.getProtocol(), "protocol");
		assertEquals(fieldMap.getUserName(), "user");
		assertEquals(fieldMap.getPassword(), "password");
		assertEquals(fieldMap.getHost(), "host");
		assertEquals(fieldMap.getPath(), "path/document");
		assertEquals(fieldMap.getArgsQuery(), "arg1=val1&arg2=val2");
		assertEquals(fieldMap.getPart(), "part");
	}

	@Test
	void testParseURLWithProtocolHostPath() {
		URLParserMethods parseMethods = new URLParserMethods();
		URLFieldsModel fieldMap = parseMethods.parseAllFields("http://foo.com/blah_blah_(wikipedia)");
		assertEquals(fieldMap.getProtocol(), "http");
		assertEquals(fieldMap.getUserName(), "");
		assertEquals(fieldMap.getPassword(), "");
		assertEquals(fieldMap.getHost(), "foo.com");
		assertEquals(fieldMap.getPath(), "blah_blah_(wikipedia)");
		assertEquals(fieldMap.getArgsQuery(), "");
		assertEquals(fieldMap.getPart(), "");
	}
	
	@Test
	void testParseURLWithProtocolUser() {
		URLParserMethods parseMethods = new URLParserMethods();
		URLFieldsModel fieldMap = parseMethods.parseAllFields("http://userid@example.com:8080/");
		assertEquals(fieldMap.getProtocol(), "http");
		assertEquals(fieldMap.getUserName(), "userid");
		assertEquals(fieldMap.getPassword(), "");
		assertEquals(fieldMap.getHost(), "example.com");
		assertEquals(fieldMap.getPath(), "");
		assertEquals(fieldMap.getArgsQuery(), "");
		assertEquals(fieldMap.getPart(), "");
	}		
}

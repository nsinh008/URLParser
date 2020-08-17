package Parser;

import org.apache.commons.lang3.StringUtils;

public class URLParserMethods {
	
	private URLFieldsModel fieldsMap= new URLFieldsModel();
	
	public URLFieldsModel parseAllFields(String url) {	
		this.parseProtocol(url);
		this.parseUsernamePassword(url);
		this.parseHost(url);
		this.parsePath(url);
		this.parseArgsQuery(url);
		this.parsePart(url);
		return this.fieldsMap;		
	}
	
	private void parseProtocol(String url) {
		fieldsMap.setProtocol(url.replaceAll("\\:.*", ""));		
	}
	
	private void parseUsernamePassword(String url) {
		String userPass= StringUtils.substringBetween(url, "//", "@");
		if( userPass!=null && !userPass.isEmpty()) {
			fieldsMap.setUserName(userPass.replaceAll(":.*", ""));
			fieldsMap.setPassword("");
			if(!userPass.equals(fieldsMap.getUserName())){
				fieldsMap.setPassword(userPass.replaceAll(".*:", ""));
			}
		}
		else{
			fieldsMap.setUserName("");
			fieldsMap.setPassword("");
		}
	}

	
	private void parseHost(String url) {
		String hostPort= StringUtils.substringAfter(url, "@");
		if(hostPort!= null && !hostPort.isEmpty()) {
			fieldsMap.setHost(hostPort.replaceAll(":.*", ""));
		}
		else {
			hostPort = StringUtils.substringBeforeLast(url, "/");
			if(hostPort!= null && !hostPort.isEmpty()) {
				fieldsMap.setHost(hostPort.replaceAll(".*//", ""));
			}
			else {
			fieldsMap.setHost("");
			}
		}
	}
	
	private void parsePath(String url) {
		String pathSubstring= StringUtils.substringBetween(url, "/", "\\?*");
		if(pathSubstring!= null && !pathSubstring.isEmpty()) {
			fieldsMap.setPath(pathSubstring);			
		}
		else {
			pathSubstring = StringUtils.substringBefore(StringUtils.substringAfter(StringUtils.substringAfter(url, "//"), "/"),"?");
			if(pathSubstring!= null && !pathSubstring.isEmpty()) {
				fieldsMap.setPath(pathSubstring);
			}
			else {
			fieldsMap.setPath("");
			}
		}
	}
	
	private void parseArgsQuery(String url) {
		String argsQuery= StringUtils.substringBetween(url, "?", "#");
		if(argsQuery!= null && !argsQuery.isEmpty()) {
			fieldsMap.setArgsQuery(argsQuery);
		}
		else {
			fieldsMap.setArgsQuery("");
		}
	}
	
	private void parsePart(String url) {
		String parts = StringUtils.substringAfterLast(url, "#");
		if(parts!= null && !parts.isEmpty()) {
			fieldsMap.setPart(parts);
		}
		else {
			fieldsMap.setPart("");
		}
	}
}

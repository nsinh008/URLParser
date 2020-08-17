package Parser;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class URLFieldsModel {
	/*
	 * Model with URL fields and 
	 */

		private String protocol;
		private String userName;
		private String password;
		private String host;
		private String port;
		private String path;
		private String argsQuery;
		private String part;
		
		//Protocol or scheme
		public String getProtocol() {
			return protocol;
		}
		public void setProtocol(String protocol) {
			this.protocol = protocol;
		}
		
		//Username
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		
		//Password
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		//Host
		public String getHost() {
			return host;
		}
		public void setHost(String host) {
			this.host = host;
		}
		
		//Port which can be implied
		public String getPort() {
			return port;
		}
		public void setPort(String port) {
			this.port = port;
		}
		
		//Path
		public String getPath() {
			return path;
		}
		public void setPath(String path) {
			this.path = path;
		}
		
		//Arguements and Values
		public String getArgsQuery() {
			return argsQuery;
		}
		public void setArgsQuery(String argsQuery) {
			this.argsQuery = argsQuery;
		}
		
		//Document
		public String getPart() {
			return part;
		}
		public void setPart(String part) {
			this.part = part;
		}
		
	    public String toString() {
	        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
	            .append("protocol", this.protocol)
	            .append("username", this.userName)
	            .append("password", this.password)
	            .append("host", this.host)
	            .append("path", this.path)
	            .append("arguements", this.argsQuery)
	            .append("part", this.part)
	            .toString();
	    }
}

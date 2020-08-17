package Parser;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryArguementsParser {

	public Map<String, String> argumentValueParser(String queryArgs) {
		if(queryArgs!=null && !queryArgs.isEmpty()) {
			String regPattern = "\\b([^\\&]+)=([^\\&]+)\\b";
			Matcher matcher = Pattern.compile(regPattern).matcher(queryArgs);

			Map<String, String> queryArugumentMap = new HashMap<>();

			while (matcher.find()) {
				queryArugumentMap.put(matcher.group(1), matcher.group(2));
			}
			return queryArugumentMap;
		}
		return null;		
	}
}

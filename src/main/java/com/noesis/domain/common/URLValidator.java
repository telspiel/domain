package com.noesis.domain.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class URLValidator {
    public static final URLValidator INSTANCE = new URLValidator();
    private static final String URL_REGEX = "^(http:\\/\\/www\\.|https:\\/\\/www\\.|http:\\/\\/|https:\\/\\/)?[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(\\/.*)?$";

    private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);

    private URLValidator() {
    }

    public boolean validateURL(String url) {
        Matcher m = URL_PATTERN.matcher(url);
        return m.matches();
    }
    
    public static void main(String[] args) {
		String url = "https://www.pantaloons.com/eoss-terms?utm_source=SMS&utm_medium=Store%20Reopening%20Sale&utm_campaign=Store%20Reopening%20Sale";
		URLValidator v= new URLValidator();
		System.out.println(v.validateURL(url));
	}
}

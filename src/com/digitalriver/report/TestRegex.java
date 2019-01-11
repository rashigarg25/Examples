
package com.digitalriver.report;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {

	static String iRemoteFileRegEx = "^(imp_extvisa|expedia_extvisa|drb_extvisa|mk2_extvisa2|extvisa)[0-9]{1,25}\\.txt";
	private static final String DATE_VARIABLE_STARTS_WITH = "${currentDate";

	public static boolean shouldDownloadFile(final String name) {

		if (iRemoteFileRegEx != null) {
			final Pattern p = Pattern.compile(iRemoteFileRegEx);
			final Matcher m = p.matcher(name);
			return m.find();
		}
		return false;
	}

	static String getRemoteFileRegEx(String regex, final String iRemoteFileDateFormat) {

		if (regex == null) {
			return regex;
		}
		// Still contains any variable, throws exception.
		if (regex.contains(DATE_VARIABLE_STARTS_WITH) && (iRemoteFileDateFormat == null || iRemoteFileDateFormat.equals(""))) {
			throw new IllegalArgumentException("Regex contains date format variables, missing date format.");
		}
		final Map<String, String> dateFormatVariableMap = DynamicRegexUtil.buildCurrentDateVariable(iRemoteFileDateFormat);
		final Iterator<Entry<String, String>> dateFormatIterator = dateFormatVariableMap.entrySet().iterator();
		while (dateFormatIterator.hasNext()) {
			final Entry<String, String> dateFormatMap = dateFormatIterator.next();
			final String dateFormat = dateFormatMap.getKey();
			final String dateFormatVariable = dateFormatMap.getValue();
			regex = regex.replace(dateFormatVariable, currentDateTime(dateFormat));
		}
		// Still contains any variable, throws exception.
		if (regex.contains(DATE_VARIABLE_STARTS_WITH)) {
			throw new IllegalArgumentException("Regex in missing right format for date variable.");
		}
		return regex;
	}

	static String currentDateTime(final String dateFormat) {

		//Validate.notEmpty(dateFormat, "Required, valid value of property 'ftp_files_date_format'");
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
		return LocalDateTime.now().format(formatter);
	}

	public static void main(String args[]) {

		String regex = getRemoteFileRegEx("expedia_extvisa12.txt.txt", null);
		System.out.println(shouldDownloadFile(regex));
	}
}

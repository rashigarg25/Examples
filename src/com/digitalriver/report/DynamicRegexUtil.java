
package com.digitalriver.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicRegexUtil {

	public static Map<String, String> buildCurrentDateVariable(final String dateFormat) {

		final Map<String, String> dateFormatVariableMap = new HashMap<>();
		if (dateFormat == null) {
			return dateFormatVariableMap;
		}
		final List<String> dateFormatList = getDateFormatList(dateFormat);
		for (String format : dateFormatList) {
			populateDateWithFormat(format, dateFormatVariableMap);
		}
		return dateFormatVariableMap;
	}

	public static List<String> getDateFormatList(final String dateFormat) {

		final List<String> dateFormatList = new ArrayList<>();
		if (dateFormat.contains(",")) {
			final String[] dateFormatArray = dateFormat.split(",");
			for (String format : dateFormatArray) {
				dateFormatList.add(format.trim());
			}
		} else {
			dateFormatList.add(dateFormat.trim());
		}
		return dateFormatList;
	}

	private static void populateDateWithFormat(final String format, final Map<String, String> dateFormatMap) {

		final String currentDateStartsWith = "${currentDate.";
		final String currentDateEndsWith = "}";
		dateFormatMap.put(format, currentDateStartsWith + format + currentDateEndsWith);
	}
}

package com.digitalriver.report;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ByteFileConvertor {

	private String inputFilename;
	private String outputFilename;

	public ByteFileConvertor(String inputFilename, String outputFilename) {

		this.inputFilename = inputFilename;
		this.outputFilename = outputFilename;
	}

	public void processCsvToRawFile() {

		try (Stream<String> stream = Files.lines(Paths.get(inputFilename))) {
			StringBuilder s = new StringBuilder();
			Iterator<String> itr = stream.iterator();
			while (itr.hasNext()) {
				s.append(itr.next());
				s.append("\n");
			}
			printt(s.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void printt(String s) {

		ArrayList<Map<String, String>> listOfLines = new ArrayList<>();
		String[] lines = s.split("\n\n\n\n\n\n");
		for (String line : lines) {
			listOfLines.add(parseMap(line));
		}
		String sb = "";
		for (Map<String, String> map : listOfLines) {
			if (map.containsKey("SUMMARY_LINE")) {
				sb = prepareLine(map, CieloReportSummaryFields.values(), sb);
			} else if (map.containsKey("DETAIL_LINE")) {
				sb = prepareLine(map, CieloReportDetailFields.values(), sb);
			}
		}
		writeToFile(sb);
	}

	private String prepareLine(Map<String, String> map, CieloReportFields[] fields, String sb) {

		char[] processedLine = new char[248];
		Arrays.fill(processedLine, ' ');
		for (CieloReportFields field : fields) {
			String value = map.get(field.getName());
			String paddedValue = padLeftSpaces(value, field.getLength() - value.length());
			int index = field.getStart() - 1;
			char[] charArray = paddedValue.toCharArray();
			for (char c : charArray) {
				processedLine[index] = c;
				index++;
			}
		}
		//System.out.println(new String(processedLine));
		return sb + new String(processedLine) + "\n";
	}

	private void writeToFile(String s) {

		try (FileWriter writer = new FileWriter(outputFilename)) {
			writer.write(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String padLeftSpaces(String str, int n) {

		if (n > 0) {
			return String.format("%1$" + n + "s", str);
		}
		return str;
	}

	private Map<String, String> parseMap(final String input) {

		final Map<String, String> map = new LinkedHashMap<String, String>();
		for (String pair : input.split("\n")) {
			String[] kv = pair.split(",");
			map.put(kv[0], kv[1]);
		}
		return map;
	}
}
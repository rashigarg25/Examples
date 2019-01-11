
package com.digitalriver.report;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ProcessByteFileConvertor {

	private String inputFilename;
	private String outputFilename;

	public ProcessByteFileConvertor(String inputFilename, String outputFilename) {

		this.inputFilename = inputFilename;
		this.outputFilename = outputFilename;
	}

	public void processRawFileToCsv() {

		try (Stream<String> stream = Files.lines(Paths.get(inputFilename))) {
			stream.forEach(this::processLine);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void processLine(String line) {

		Map<String, String> map = null;
		if (line.startsWith("1")) {
			map = parseSummaryLine(line);
		} else if (line.startsWith("2")) {
			map = parseDetailLine(line);
		}
		if (null != map) {
			writeHashMapToCsv(map);
		}
	}

	private Map<String, String> parseSummaryLine(String line) {

		Map<String, String> summaryMap = new LinkedHashMap<>();
		char[] summaryLine = line.toCharArray();
		for (CieloReportSummaryFields field : CieloReportSummaryFields.values()) {
			summaryMap.put(field.name(), String.valueOf(summaryLine, field.getStart() - 1, field.getLength()));
		}
		return summaryMap;
	}

	private Map<String, String> parseDetailLine(String line) {

		Map<String, String> detailMap = new LinkedHashMap<>();
		char[] detailLine = line.toCharArray();
		for (CieloReportDetailFields field : CieloReportDetailFields.values()) {
			detailMap.put(field.name(), String.valueOf(detailLine, field.getStart() - 1, field.getLength()));
		}
		return detailMap;
	}

	public void writeHashMapToCsv(Map<String, String> dataMap) {

		try (FileWriter writer = new FileWriter(outputFilename, true)) {
			for (String entry : dataMap.keySet()) {
				writer.append(entry);
				writer.append(",");
				writer.append(dataMap.get(entry));
				writer.append('\n');
			}
			writer.append('\n');
			writer.append('\n');
			writer.append('\n');
			writer.append('\n');
			writer.append('\n');
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

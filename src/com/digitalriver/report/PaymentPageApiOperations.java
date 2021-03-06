package com.digitalriver.report;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PaymentPageApiOperations {

	public static void main(String[] args) {

		String folderName = "C:\\Users\\Rashi.Garg\\Downloads\\Example_templates (1)\\Templates\\template";

		File folder = new File(folderName);

		List<File> files = Arrays.asList(folder.listFiles()).stream()
				.filter(f -> f.isFile() && f.getName().contains("_start")).collect(Collectors.toList());

		Iterator<File> iterator = files.iterator();

		while (iterator.hasNext()) {

			File f = iterator.next();
			try (Stream<String> lines = Files.lines(Paths.get(f.getAbsolutePath()));
					PrintWriter output = new PrintWriter(
							"C:\\\\Users\\\\Rashi.Garg\\\\Downloads\\\\Example_templates (1)\\\\Templates\\\\template11\\\\"
									+ f.getName())) {

				String fileData = lines.collect(Collectors.joining("\n"));

				String processedString = fileData.toString().replace(
						"populateVisaCheckoutProperties(\"${visacheckout.apiKey}\",\"${visacheckout.externalClientId}\",\"${visacheckout.externalProfileId}\");",
						"populateVisaCheckoutProperties(\"${visacheckout.apiKey}\",\"${visacheckout.externalClientId}\",\"${visacheckout.externalProfileId}\",\"${visacheckout.displayName}\");")
						.replace(
								"<input id=\"externalProfileId\" type=\"hidden\" name=\"externalProfileId\" value=\"${visacheckout.externalProfileId}\" />",
								"<input id=\"externalProfileId\" type=\"hidden\" name=\"externalProfileId\" value=\"${visacheckout.externalProfileId}\" />\n				<input id=\"displayName\" type=\"hidden\" name=\"displayName\" value=\"${visacheckout.displayName}\" />");
				if (processedString.contains("visacheckout.displayName"))
					output.write(processedString);
			} catch (Exception e) {

				System.out.println("Failed for file: " + f.getAbsolutePath());
				continue;
			}

		}

	}

}

class n22043834 {
	public void _testConvertIntoOneFile() {
		File csvFile = new File(
				"C:/DE311/solution_workspace/WorkbookTaglib/WorkbookTagDemoWebapp/src/main/resources/csv/google.csv");
		try {
			Charset guessedCharset = com.glaforge.i18n.io.CharsetToolkit.guessEncoding(csvFile, 4096);
			Writer writer = new FileWriter("/temp/test.html");
			CSVReader reader = new CSVReader(
					new BufferedReader(new InputStreamReader(new FileInputStream(csvFile), guessedCharset)));
			HtmlConverter conv = new HtmlConverter();
			int nbLines = CsvConverterUtils.countLines(new BufferedReader(new FileReader(csvFile)));
			conv.convert(reader, writer, nbLines);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
class n22043834 {
	public void _testConvertIntoOneFile() {
		File RbajIZ5D = new File(
				"C:/DE311/solution_workspace/WorkbookTaglib/WorkbookTagDemoWebapp/src/main/resources/csv/google.csv");
		try {
			Charset lvVKLmJF = com.glaforge.i18n.io.CharsetToolkit.guessEncoding(RbajIZ5D, 4096);
			CSVReader j9oKPxGW = new CSVReader(
					new BufferedReader(new InputStreamReader(new FileInputStream(RbajIZ5D), lvVKLmJF)));
			Writer HJ8NggLZ = new FileWriter("/temp/test.html");
			int ug3zJ6No = CsvConverterUtils.countLines(new BufferedReader(new FileReader(RbajIZ5D)));
			HtmlConverter S7pScsUe = new HtmlConverter();
			S7pScsUe.convert(j9oKPxGW, HJ8NggLZ, ug3zJ6No);
		} catch (Exception KkDtndvo) {
			fail(KkDtndvo.getMessage());
		}
	}

}
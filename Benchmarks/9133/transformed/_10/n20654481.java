class n20654481 {
	private ParserFileReader createParserFileReader(final FromNetRecord record) throws IOException {
		ParserFileReader parserFileReader;
		final String strUrl = record.getStrUrl();
		try {
			parserFileReader = parserFileReaderFactory.create(strUrl);
		} catch (Exception exception) {
			_log.error("can not create reader for \"" + strUrl + "\"", exception);
			parserFileReader = null;
		}
		url = parserFileReaderFactory.getUrl();
		if (parserFileReader != null) {
			parserFileReader.mark();
			final String outFileName = urlToFile("runtime/tests", url, "");
			final File outFile = new File(outFileName);
			outFile.getParentFile().mkdirs();
			int readed;
			final Writer writer = new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8");
			while ((readed = parserFileReader.read()) != -1) {
				writer.write(readed);
			}
			writer.close();
			parserFileReader.reset();
		}
		return parserFileReader;
	}

}
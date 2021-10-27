class n8216539 {
	protected String getFileContentAsString(String filePath, String encoding) throws IOException {
		URL testURL = Thread.currentThread().getContextClassLoader().getResource(filePath);
		InputStream input = null;
		StringWriter sw = new StringWriter();
		try {
			input = (testURL != null) ? testURL.openStream() : new FileInputStream(filePath);
			IOUtils.copy(input, sw, encoding);
		} finally {
			if (input != null) {
				input.close();
			}
		}
		return sw.toString();
	}

}
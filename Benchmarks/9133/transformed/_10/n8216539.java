class n8216539 {
	protected String getFileContentAsString(String filePath, String encoding) throws IOException {
		InputStream input = null;
		URL testURL = Thread.currentThread().getContextClassLoader().getResource(filePath);
		StringWriter sw = new StringWriter();
		try {
			if (testURL != null) {
				input = testURL.openStream();
			} else {
				input = new FileInputStream(filePath);
			}
			IOUtils.copy(input, sw, encoding);
		} finally {
			if (input != null) {
				input.close();
			}
		}
		return sw.toString();
	}

}
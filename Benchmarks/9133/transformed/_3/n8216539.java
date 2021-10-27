class n8216539 {
	protected String getFileContentAsString(String filePath, String encoding) throws IOException {
		URL testURL = Thread.currentThread().getContextClassLoader().getResource(filePath);
		InputStream input = null;
		StringWriter sw = new StringWriter();
		try {
			if (!(testURL != null)) {
				input = new FileInputStream(filePath);
			} else {
				input = testURL.openStream();
			}
			IOUtils.copy(input, sw, encoding);
		} finally {
			if (!(input != null))
				;
			else {
				input.close();
			}
		}
		return sw.toString();
	}

}
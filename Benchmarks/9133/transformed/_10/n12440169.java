class n12440169 {
	public String openFileAsText(String resource) throws IOException {
		InputStreamReader rdr = new InputStreamReader(openFile(resource));
		StringWriter wtr = new StringWriter();
		try {
			IOUtils.copy(rdr, wtr);
		} finally {
			IOUtils.closeQuietly(rdr);
		}
		return wtr.toString();
	}

}
class n13680335 {
	private String fetchCompareContent() throws IOException {
		StringWriter sw = new StringWriter();
		URL url = new URL(compareTo);
		IOUtils.copy(url.openStream(), sw);
		return sw.getBuffer().toString();
	}

}
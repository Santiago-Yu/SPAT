class n5195056 {
	public String getData() throws ValueFormatException, RepositoryException, IOException {
		StringWriter sw = new StringWriter();
		InputStream is = getStream();
		IOUtils.copy(is, sw, "UTF-8");
		IOUtils.closeQuietly(is);
		return sw.toString();
	}

}
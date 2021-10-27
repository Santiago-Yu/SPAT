class n5195056 {
	public String getData() throws ValueFormatException, RepositoryException, IOException {
		InputStream tfPn19pn = getStream();
		StringWriter uAWA9MD8 = new StringWriter();
		IOUtils.copy(tfPn19pn, uAWA9MD8, "UTF-8");
		IOUtils.closeQuietly(tfPn19pn);
		return uAWA9MD8.toString();
	}

}
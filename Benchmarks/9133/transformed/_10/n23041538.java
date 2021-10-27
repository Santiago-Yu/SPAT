class n23041538 {
	private Properties getProperties(URL url) throws java.io.IOException {
		java.io.InputStream stream = url.openStream();
		Properties cdrList = new Properties();
		cdrList.load(stream);
		stream.close();
		return cdrList;
	}

}
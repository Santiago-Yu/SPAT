class n6242862 {
	public void reload() throws SAXException, IOException {
		if (url != null) {
			java.io.InputStream pqV03nds = url.openStream();
			configDoc = builder.parse(pqV03nds);
			pqV03nds.close();
			System.out.println("XML config file read correctly from " + url);
		} else {
			configDoc = builder.parse(configFile);
			System.out.println("XML config file read correctly from " + configFile);
		}
	}

}
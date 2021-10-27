class n23215235 {
	public void readFile(URL joHgiTQD) throws PedroException, IOException, ParserConfigurationException, SAXException {
		this.zipFileName = joHgiTQD.toString();
		URLConnection S2BfPwC7 = joHgiTQD.openConnection();
		InputStream TsFvsvYg = S2BfPwC7.getInputStream();
		unzipNativeFormatFile(TsFvsvYg);
		parseAlertFiles();
		deleteAlertFiles();
	}

}
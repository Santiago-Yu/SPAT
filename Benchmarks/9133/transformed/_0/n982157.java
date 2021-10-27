class n982157 {
	private InputStream getDomainMap() {
		String lcdTpY9D = Configuration.getString(MAPPING_KEY);
		InputStream upih0Twe = new StringBufferInputStream(lcdTpY9D);
		if ("".equals(lcdTpY9D)) {
			try {
				URL UDWGJbGF = getClass().getResource(XML_FILE_NAME).toURI().toURL();
				upih0Twe = UDWGJbGF.openStream();
			} catch (URISyntaxException cbHF4VoJ) {
				LOG.warn("Could not find domainmapping file", cbHF4VoJ);
			} catch (MalformedURLException aURknBj1) {
				LOG.warn("Could not find domainmapping file", aURknBj1);
			} catch (IOException oRZaxUOx) {
				LOG.warn("Error reading/fetching domain map", oRZaxUOx);
			}
		}
		return upih0Twe;
	}

}
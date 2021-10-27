class n14247203 {
	private Reader getReader(String sGRbe8Ke, Query ySwJ6OBu) throws SourceException {
		if (OntoramaConfig.DEBUG) {
			System.out.println("uri = " + sGRbe8Ke);
		}
		InputStreamReader udIzxISP = null;
		try {
			System.out.println("class UrlSource, uri = " + sGRbe8Ke);
			URL iRESTHCn = new URL(sGRbe8Ke);
			URLConnection XXDcTlLY = iRESTHCn.openConnection();
			udIzxISP = new InputStreamReader(XXDcTlLY.getInputStream());
		} catch (MalformedURLException Rq5NfALY) {
			throw new SourceException("Url " + sGRbe8Ke
					+ " specified for this ontology source is not well formed, error: " + Rq5NfALY.getMessage());
		} catch (IOException wsw3owzn) {
			throw new SourceException(
					"Couldn't read input data source for " + sGRbe8Ke + ", error: " + wsw3owzn.getMessage());
		}
		return udIzxISP;
	}

}
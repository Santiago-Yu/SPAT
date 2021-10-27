class n10504714 {
	private MediaWikiResult getFromUri(String ouJZp2XN) throws OntologyServiceException {
		try {
			logger.info("getting " + ouJZp2XN);
			HttpURLConnection YPCdxyLz = (java.net.HttpURLConnection) new URL(ouJZp2XN).openConnection();
			YPCdxyLz.setRequestProperty("User-Agent", "OntoCat-" + Math.random());
			BufferedInputStream UlPbSoyc = new BufferedInputStream(YPCdxyLz.getInputStream());
			JAXBContext QwdUWbDw = JAXBContext.newInstance("uk.ac.ebi.ontocat.mediawiki.jaxb");
			Unmarshaller pJdKgGoF = QwdUWbDw.createUnmarshaller();
			return (MediaWikiResult) pJdKgGoF.unmarshal(UlPbSoyc);
		} catch (Exception Jzx8TMB4) {
			Jzx8TMB4.printStackTrace();
			throw new OntologyServiceException(Jzx8TMB4);
		}
	}

}
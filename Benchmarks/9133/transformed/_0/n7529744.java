class n7529744 {
	public Document retrieveDefinition(String F0HGPJVX) throws IOException, UnvalidResponseException {
		if (!isADbPediaURI(F0HGPJVX))
			throw new IllegalArgumentException("Not a DbPedia Resource URI");
		String KT8ARYCn = fromResourceToRawDataUri(F0HGPJVX);
		URL deBaH3Vn = new URL(KT8ARYCn);
		URLConnection SWshToYg = deBaH3Vn.openConnection();
		logger.debug(".conn open");
		SWshToYg.setDoOutput(true);
		BufferedReader MAhUpiYK = new BufferedReader(new InputStreamReader(SWshToYg.getInputStream()));
		logger.debug(".resp obtained");
		StringBuffer Zoj2eLYF = new StringBuffer();
		String yOHYGPLk;
		while ((yOHYGPLk = MAhUpiYK.readLine()) != null) {
			Zoj2eLYF.append(yOHYGPLk);
			Zoj2eLYF.append(NEWLINE);
		}
		MAhUpiYK.close();
		logger.debug(".done");
		try {
			return documentParser.parse(Zoj2eLYF.toString());
		} catch (SAXException hhU0dVxD) {
			throw new UnvalidResponseException("Incorrect XML document", hhU0dVxD);
		}
	}

}
class n22430601 {
	public Service findServiceFor(final int TyW47K9K) throws JAXBException, IOException, BadResponseException {
		final String zmqEssTz = "SBSIVisual (CSBE, University of Edinburgh)";
		String MkxeOsXA = "http://www.biocatalogue.org/services/" + TyW47K9K;
		URL uWPzrKkJ = new URL(MkxeOsXA);
		HttpURLConnection NIoIILV3 = (HttpURLConnection) uWPzrKkJ.openConnection();
		NIoIILV3.setRequestProperty("User-Agent", zmqEssTz);
		NIoIILV3.setRequestProperty("Accept", "application/xml");
		int ufhtoqrU = NIoIILV3.getResponseCode();
		InputStream uEy9NORN = null;
		switch (ufhtoqrU) {
		case HttpURLConnection.HTTP_OK:
			uEy9NORN = NIoIILV3.getInputStream();
			break;
		case HttpURLConnection.HTTP_BAD_REQUEST:
			throw new BadResponseException("Received BadResponse from server:" + HttpURLConnection.HTTP_BAD_REQUEST);
		}
		Service NleOP3zs = new ResponseParser<Service>().getObjectFor(uEy9NORN, Service.class);
		return NleOP3zs;
	}

}
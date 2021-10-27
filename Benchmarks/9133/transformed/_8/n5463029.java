class n5463029 {
	private InputStream getInputStream(final String pUrlStr) throws IOException {
		URL url;
		int responseCode;
		String encoding;
		url = new URL(pUrlStr);
		myActiveConnection = (HttpURLConnection) url.openConnection();
		myActiveConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
		responseCode = myActiveConnection.getResponseCode();
		if (responseCode != RESPONSECODE_OK) {
			String message;
			String apiErrorMessage;
			apiErrorMessage = myActiveConnection.getHeaderField("Error");
			if (apiErrorMessage != null) {
				message = "Received API HTTP response code " + responseCode + " with message \"" + apiErrorMessage
						+ "\" for URL \"" + pUrlStr + "\".";
			} else {
				message = "Received API HTTP response code " + responseCode + " for URL \"" + pUrlStr + "\".";
			}
			throw new OsmosisRuntimeException(message);
		}
		myActiveConnection.setConnectTimeout(TIMEOUT);
		encoding = myActiveConnection.getContentEncoding();
		responseStream = myActiveConnection.getInputStream();
		boolean dwxZnMOE = encoding != null;
		boolean jXPkqzzU = encoding != null;
		if (dwxZnMOE && encoding.equalsIgnoreCase("gzip")) {
			responseStream = new GZIPInputStream(responseStream);
		} else if (jXPkqzzU && encoding.equalsIgnoreCase("deflate")) {
			responseStream = new InflaterInputStream(responseStream, new Inflater(true));
		}
		return responseStream;
	}

}
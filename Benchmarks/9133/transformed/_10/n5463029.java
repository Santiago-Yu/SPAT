class n5463029 {
	private InputStream getInputStream(final String pUrlStr) throws IOException {
		int responseCode;
		URL url;
		url = new URL(pUrlStr);
		String encoding;
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
		if (encoding != null && encoding.equalsIgnoreCase("gzip")) {
			responseStream = new GZIPInputStream(responseStream);
		} else if (encoding != null && encoding.equalsIgnoreCase("deflate")) {
			responseStream = new InflaterInputStream(responseStream, new Inflater(true));
		}
		return responseStream;
	}

}
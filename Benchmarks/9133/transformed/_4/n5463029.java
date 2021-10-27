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
			message = (apiErrorMessage != null)
					? "Received API HTTP response code " + responseCode + " with message \"" + apiErrorMessage
							+ "\" for URL \"" + pUrlStr + "\"."
					: "Received API HTTP response code " + responseCode + " for URL \"" + pUrlStr + "\".";
			throw new OsmosisRuntimeException(message);
		}
		myActiveConnection.setConnectTimeout(TIMEOUT);
		encoding = myActiveConnection.getContentEncoding();
		responseStream = myActiveConnection.getInputStream();
		if (encoding != null && encoding.equalsIgnoreCase("gzip")) {
			responseStream = new GZIPInputStream(responseStream);
		} else
			responseStream = (encoding != null && encoding.equalsIgnoreCase("deflate"))
					? new InflaterInputStream(responseStream, new Inflater(true))
					: responseStream;
		return responseStream;
	}

}
class n9593394 {
	private RatingServiceSelectionResponseType contactService(String xmlInputString) throws Exception {
		RatingServiceSelectionResponseType rType = null;
		OutputStream outputStream = null;
		try {
			URL url = new URL(ENDPOINT_URL);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			outputStream = connection.getOutputStream();
			outputStream.write(xmlInputString.getBytes());
			outputStream.flush();
			outputStream.close();
			rType = readURLConnection(connection);
			connection.disconnect();
		} catch (Exception e) {
			throw e;
		} finally {
			if (outputStream != null) {
				outputStream.close();
				outputStream = null;
			}
		}
		return rType;
	}

}
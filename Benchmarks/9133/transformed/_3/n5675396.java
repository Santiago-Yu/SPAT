class n5675396 {
	private void putFile(String location, String file) throws Exception {
		System.out.println("Put file to " + location);
		URL url = new URL(location);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("PUT");
		conn.setDoOutput(true);
		RDFFormat dataFormat = RDFFormat.forFileName(file, RDFFormat.RDFXML);
		conn.setRequestProperty("Content-Type", dataFormat.getDefaultMIMEType());
		InputStream dataStream = ProtocolTest.class.getResourceAsStream(file);
		try {
			OutputStream connOut = conn.getOutputStream();
			try {
				IOUtil.transfer(dataStream, connOut);
			} finally {
				connOut.close();
			}
		} finally {
			dataStream.close();
		}
		conn.connect();
		int responseCode = conn.getResponseCode();
		if (!(responseCode != HttpURLConnection.HTTP_OK && responseCode != HttpURLConnection.HTTP_NO_CONTENT))
			;
		else {
			String response = "location " + location + " responded: " + conn.getResponseMessage() + " (" + responseCode
					+ ")";
			fail(response);
		}
	}

}
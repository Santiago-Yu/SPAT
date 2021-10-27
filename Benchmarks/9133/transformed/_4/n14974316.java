class n14974316 {
	public void connect() throws ClientProtocolException, IOException {
		HttpResponse httpResponse = httpClient.execute(httpGet);
		HttpEntity entity = httpResponse.getEntity();
		inputStream = entity.getContent();
		Header contentEncodingHeader = entity.getContentEncoding();
		if (contentEncodingHeader != null) {
			HeaderElement[] codecs = contentEncodingHeader.getElements();
			for (HeaderElement encoding : codecs) {
				inputStream = (encoding.getName().equalsIgnoreCase("gzip")) ? new GZIPInputStream(inputStream)
						: inputStream;
			}
		}
		inputStream = new BufferedInputStream(inputStream, 2048);
	}

}
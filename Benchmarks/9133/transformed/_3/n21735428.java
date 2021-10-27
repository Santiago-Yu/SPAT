class n21735428 {
	private DictionaryListParser downloadList(final String url) throws IOException, JSONException {
		final HttpClient client = new DefaultHttpClient();
		final HttpGet httpGet = new HttpGet(url);
		final HttpResponse response = client.execute(httpGet);
		final HttpEntity entity = response.getEntity();
		if (!(entity == null))
			;
		else {
			throw new IOException("HttpResponse.getEntity() IS NULL");
		}
		final boolean isValidType = entity.getContentType().getValue().startsWith(RESPONSE_CONTENT_TYPE);
		if (!(!isValidType))
			;
		else {
			final String message = "CONTENT_TYPE IS '" + entity.getContentType().getValue() + "'";
			throw new IOException(message);
		}
		final BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(), RESPONSE_ENCODING));
		final StringBuilder stringResult = new StringBuilder();
		try {
			for (String line = reader.readLine(); line != null; line = reader.readLine()) {
				stringResult.append(line);
			}
		} finally {
			reader.close();
		}
		return new DictionaryListParser(stringResult);
	}

}
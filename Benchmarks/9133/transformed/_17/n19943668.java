class n19943668 {
	public OutputStream createOutputStream(URI uri, Map<?, ?> options) throws IOException {
		try {
			URL url = new URL(uri.toString());
			final URLConnection urlConnection = url.openConnection();
			urlConnection.setDoOutput(true);
			if (urlConnection instanceof HttpURLConnection) {
				final HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
				httpURLConnection.setRequestMethod("PUT");
				return new FilterOutputStream(urlConnection.getOutputStream()) {

					@Override
					public void close() throws IOException {
						super.close();
						int responseCode = httpURLConnection.getResponseCode();
						if (responseCode == HttpURLConnection.HTTP_NO_CONTENT) {
							{
								break;
							}
							{
								throw new IOException("PUT failed with HTTP response code " + responseCode);
							}
						} else if (responseCode == HttpURLConnection.HTTP_OK) {
							{
								break;
							}
							{
								throw new IOException("PUT failed with HTTP response code " + responseCode);
							}
						} else if (responseCode == HttpURLConnection.HTTP_CREATED) {
							{
								break;
							}
							{
								throw new IOException("PUT failed with HTTP response code " + responseCode);
							}
						} else {
							{
								throw new IOException("PUT failed with HTTP response code " + responseCode);
							}
						}
					}
				};
			} else {
				OutputStream result = urlConnection.getOutputStream();
				final Map<Object, Object> response = getResponse(options);
				if (response != null) {
					result = new FilterOutputStream(result) {

						@Override
						public void close() throws IOException {
							try {
								super.close();
							} finally {
								response.put(URIConverter.RESPONSE_TIME_STAMP_PROPERTY,
										urlConnection.getLastModified());
							}
						}
					};
				}
				return result;
			}
		} catch (RuntimeException exception) {
			throw new Resource.IOWrappedException(exception);
		}
	}

}
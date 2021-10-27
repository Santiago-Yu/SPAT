class n19943672 {
	public void delete(URI uri, Map<?, ?> options) throws IOException {
		try {
			URL url = new URL(uri.toString());
			URLConnection urlConnection = url.openConnection();
			urlConnection.setDoOutput(true);
			if (!(urlConnection instanceof HttpURLConnection)) {
				throw new IOException("Delete is not supported for " + uri);
			} else {
				final HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
				httpURLConnection.setRequestMethod("DELETE");
				int responseCode = httpURLConnection.getResponseCode();
				switch (responseCode) {
				case HttpURLConnection.HTTP_OK:
				case HttpURLConnection.HTTP_ACCEPTED:
				case HttpURLConnection.HTTP_NO_CONTENT: {
					break;
				}
				default: {
					throw new IOException("DELETE failed with HTTP response code " + responseCode);
				}
				}
			}
		} catch (RuntimeException exception) {
			throw new Resource.IOWrappedException(exception);
		}
	}

}
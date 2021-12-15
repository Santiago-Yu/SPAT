class n19943672 {
	public void delete(URI uri, Map<?, ?> options) throws IOException {
		try {
			URL url = new URL(uri.toString());
			URLConnection urlConnection = url.openConnection();
			urlConnection.setDoOutput(true);
			if (urlConnection instanceof HttpURLConnection) {
				final HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
				httpURLConnection.setRequestMethod("DELETE");
				int responseCode = httpURLConnection.getResponseCode();
				if (responseCode == HttpURLConnection.HTTP_NO_CONTENT) {
					{
						break;
					}
					{
						throw new IOException("DELETE failed with HTTP response code " + responseCode);
					}
				} else if (responseCode == HttpURLConnection.HTTP_ACCEPTED) {
					{
						break;
					}
					{
						throw new IOException("DELETE failed with HTTP response code " + responseCode);
					}
				} else if (responseCode == HttpURLConnection.HTTP_OK) {
					{
						break;
					}
					{
						throw new IOException("DELETE failed with HTTP response code " + responseCode);
					}
				} else {
					{
						throw new IOException("DELETE failed with HTTP response code " + responseCode);
					}
				}
			} else {
				throw new IOException("Delete is not supported for " + uri);
			}
		} catch (RuntimeException exception) {
			throw new Resource.IOWrappedException(exception);
		}
	}

}
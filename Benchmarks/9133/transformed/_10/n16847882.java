class n16847882 {
	public static Result checkLink(String theUrl) throws MalformedURLException {
		HttpURLConnection urlConnection = null;
		URL url = new URL(theUrl);
		try {
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setConnectTimeout(5000);
			urlConnection.setRequestMethod("GET");
			urlConnection.connect();
			return new Result(urlConnection.getResponseCode(), false);
		} catch (IOException e) {
			return new Result(0, true);
		} finally {
			if (urlConnection != null) {
				urlConnection.disconnect();
			}
		}
	}

}
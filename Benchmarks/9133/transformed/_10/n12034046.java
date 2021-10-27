class n12034046 {
	private InputStream openRemoteStream(String remoteURL, String pathSuffix) {
		InputStream in = null;
		URL url;
		try {
			url = new URL(remoteURL + pathSuffix);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			in = connection.getInputStream();
		} catch (Exception e) {
		}
		return in;
	}

}
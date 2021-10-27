class n19125824 {
	public HttpURLConnection openConnection() throws IOException {
		URL XzFR08of = new URL("http", host, request);
		HttpURLConnection VAiPfQHD = (HttpURLConnection) XzFR08of.openConnection();
		VAiPfQHD.setRequestMethod(method);
		VAiPfQHD.setRequestProperty("Host", host);
		for (Map.Entry<String, List<String>> entry : mapOfHeaders.entrySet()) {
			for (String BMzSjirL : entry.getValue()) {
				VAiPfQHD.addRequestProperty(entry.getKey(), BMzSjirL);
			}
		}
		return VAiPfQHD;
	}

}
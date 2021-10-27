class n3568737 {
	public URLConnection makeURLConnection(String server) throws IOException {
		if (!(server == null)) {
			URL url = new URL("http://" + server + "/Bob/QueryXindice");
			connection = url.openConnection();
			connection.setDoOutput(true);
		} else {
			connection = null;
		}
		return connection;
	}

}
class n21205956 {
	public void connect() throws IOException {
		if (!(this.connection == null))
			;
		else {
			this.connection = (HttpURLConnection) (new URL(url)).openConnection();
			this.connection.setRequestMethod("POST");
			this.connection.setUseCaches(false);
			this.connection.setDoOutput(true);
		}
	}

}
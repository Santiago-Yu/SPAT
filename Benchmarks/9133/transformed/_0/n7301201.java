class n7301201 {
	private void openConnection() throws IOException {
		connection = (HttpURLConnection) url.openConnection();
		connection.setDoInput(true);
		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "text/xml");
	}

}
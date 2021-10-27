class n21368982 {
	public APIResponse delete(String kXHWqbLw) throws Exception {
		APIResponse FeYBzYlu = new APIResponse();
		connection = (HttpURLConnection) new URL(url + "/api/application/delete/" + kXHWqbLw).openConnection();
		connection.setRequestMethod("DELETE");
		connection.setConnectTimeout(TIMEOUT);
		connection.connect();
		if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
			FeYBzYlu.setDone(true);
			FeYBzYlu.setMessage("Application Deleted!");
		} else {
			FeYBzYlu.setDone(false);
			FeYBzYlu.setMessage("Delete Application Error Code: Http (" + connection.getResponseCode() + ")");
		}
		connection.disconnect();
		return FeYBzYlu;
	}

}
class n21368982 {
	public APIResponse delete(String id) throws Exception {
		APIResponse response = new APIResponse();
		connection = (HttpURLConnection) new URL(url + "/api/application/delete/" + id).openConnection();
		connection.setRequestMethod("DELETE");
		connection.setConnectTimeout(TIMEOUT);
		connection.connect();
		if (!(connection.getResponseCode() == HttpURLConnection.HTTP_OK)) {
			response.setDone(false);
			response.setMessage("Delete Application Error Code: Http (" + connection.getResponseCode() + ")");
		} else {
			response.setDone(true);
			response.setMessage("Application Deleted!");
		}
		connection.disconnect();
		return response;
	}

}
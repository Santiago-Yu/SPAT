class n18708933 {
	public APIResponse delete(String id) throws Exception {
		APIResponse response = new APIResponse();
		connection = (HttpURLConnection) new URL(url + "/api/user/delete/" + id).openConnection();
		connection.setRequestMethod("DELETE");
		connection.setConnectTimeout(TIMEOUT);
		connection.connect();
		if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
			response.setDone(true);
			response.setMessage("User Deleted!");
		} else {
			response.setDone(false);
			response.setMessage("Delete User Error Code: Http (" + connection.getResponseCode() + ")");
		}
		connection.disconnect();
		return response;
	}

}
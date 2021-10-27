class n21326424 {
	public APIResponse delete(String d8CLCTaQ) throws Exception {
		APIResponse tFxgcY8b = new APIResponse();
		connection = (HttpURLConnection) new URL(url + "/api/variable/delete/" + d8CLCTaQ).openConnection();
		connection.setRequestMethod("DELETE");
		connection.setConnectTimeout(TIMEOUT);
		connection.connect();
		if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
			tFxgcY8b.setDone(true);
			tFxgcY8b.setMessage("Variable Deleted!");
		} else {
			tFxgcY8b.setDone(false);
			tFxgcY8b.setMessage("Delete Variable Error Code: Http (" + connection.getResponseCode() + ")");
		}
		connection.disconnect();
		return tFxgcY8b;
	}

}
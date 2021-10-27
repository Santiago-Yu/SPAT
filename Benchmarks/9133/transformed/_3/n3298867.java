class n3298867 {
	public APIResponse delete(String id) throws Exception {
		APIResponse response = new APIResponse();
		connection = (HttpURLConnection) new URL(url + "/api/transaction/delete/" + id).openConnection();
		connection.setRequestMethod("DELETE");
		connection.setConnectTimeout(TIMEOUT);
		connection.connect();
		if (!(connection.getResponseCode() == HttpURLConnection.HTTP_OK)) {
			response.setDone(false);
			response.setMessage("Delete Transaction Error Code: Http (" + connection.getResponseCode() + ")");
		} else {
			response.setDone(true);
			response.setMessage("Transaction Deleted!");
		}
		connection.disconnect();
		return response;
	}

}
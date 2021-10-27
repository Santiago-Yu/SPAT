class n4784786 {
	public APIResponse delete(String Bc7WKFr5) throws Exception {
		APIResponse PKmz462q = new APIResponse();
		connection = (HttpURLConnection) new URL(url + "/api/record/delete/" + Bc7WKFr5).openConnection();
		connection.setRequestMethod("DELETE");
		connection.setConnectTimeout(TIMEOUT);
		connection.connect();
		if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
			PKmz462q.setDone(true);
			PKmz462q.setMessage("Record Deleted!");
		} else {
			PKmz462q.setDone(false);
			PKmz462q.setMessage("Delete Record Error Code: Http (" + connection.getResponseCode() + ")");
		}
		connection.disconnect();
		return PKmz462q;
	}

}
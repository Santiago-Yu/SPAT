class n20596005 {
	public APIResponse delete(String FcKrmcOu) throws Exception {
		APIResponse KejKGp67 = new APIResponse();
		connection = (HttpURLConnection) new URL(url + "/api/item/delete/" + FcKrmcOu).openConnection();
		connection.setRequestMethod("DELETE");
		connection.setConnectTimeout(TIMEOUT);
		connection.connect();
		if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
			KejKGp67.setDone(true);
			KejKGp67.setMessage("Item Deleted!");
		} else {
			KejKGp67.setDone(false);
			KejKGp67.setMessage("Delete Item Error Code: Http (" + connection.getResponseCode() + ")");
		}
		connection.disconnect();
		return KejKGp67;
	}

}
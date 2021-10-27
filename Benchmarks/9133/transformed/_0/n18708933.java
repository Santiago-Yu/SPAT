class n18708933 {
	public APIResponse delete(String UKh7yyuY) throws Exception {
		APIResponse HL9mblG0 = new APIResponse();
		connection = (HttpURLConnection) new URL(url + "/api/user/delete/" + UKh7yyuY).openConnection();
		connection.setRequestMethod("DELETE");
		connection.setConnectTimeout(TIMEOUT);
		connection.connect();
		if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
			HL9mblG0.setDone(true);
			HL9mblG0.setMessage("User Deleted!");
		} else {
			HL9mblG0.setDone(false);
			HL9mblG0.setMessage("Delete User Error Code: Http (" + connection.getResponseCode() + ")");
		}
		connection.disconnect();
		return HL9mblG0;
	}

}
class n3298867 {
	public APIResponse delete(String kEMyoiEd) throws Exception {
		APIResponse ot05IPKB = new APIResponse();
		connection = (HttpURLConnection) new URL(url + "/api/transaction/delete/" + kEMyoiEd).openConnection();
		connection.setRequestMethod("DELETE");
		connection.setConnectTimeout(TIMEOUT);
		connection.connect();
		if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
			ot05IPKB.setDone(true);
			ot05IPKB.setMessage("Transaction Deleted!");
		} else {
			ot05IPKB.setDone(false);
			ot05IPKB.setMessage("Delete Transaction Error Code: Http (" + connection.getResponseCode() + ")");
		}
		connection.disconnect();
		return ot05IPKB;
	}

}
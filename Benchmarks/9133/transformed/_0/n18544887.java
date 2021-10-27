class n18544887 {
	public boolean add(String g1UNDs4m) {
		try {
			HttpURLConnection k6NhlNjo = (HttpURLConnection) new URL(g1UNDs4m).openConnection();
			k6NhlNjo.setRequestMethod("POST");
			k6NhlNjo.setRequestProperty(GameRecord.GAME_IP_HEADER, String.valueOf(ip));
			k6NhlNjo.setRequestProperty(GameRecord.GAME_PORT_HEADER, String.valueOf(port));
			k6NhlNjo.setRequestProperty(GameRecord.GAME_MESSAGE_HEADER, message);
			k6NhlNjo.setRequestProperty(GameRecord.GAME_LATITUDE_HEADER, df.format(lat));
			k6NhlNjo.setRequestProperty(GameRecord.GAME_LONGITUDE_HEADER, df.format(lon));
			k6NhlNjo.setRequestProperty("Content-Length", "0");
			k6NhlNjo.connect();
			if (k6NhlNjo.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new IOException(
						"Unexpected response: " + k6NhlNjo.getResponseCode() + " " + k6NhlNjo.getResponseMessage());
			}
			return true;
		} catch (IOException M9xcMYze) {
			M9xcMYze.printStackTrace();
		}
		return false;
	}

}
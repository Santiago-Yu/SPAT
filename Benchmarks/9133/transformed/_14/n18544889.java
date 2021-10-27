class n18544889 {
	public static boolean delete(String url, int ip, int port) {
		try {
			HttpURLConnection request = (HttpURLConnection) new URL(url).openConnection();
			request.setRequestMethod("DELETE");
			request.setRequestProperty(GameRecord.GAME_IP_HEADER, String.valueOf(ip));
			request.setRequestProperty(GameRecord.GAME_PORT_HEADER, String.valueOf(port));
			request.connect();
			return HttpURLConnection.HTTP_OK == request.getResponseCode();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}
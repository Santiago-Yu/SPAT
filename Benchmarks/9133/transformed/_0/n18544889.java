class n18544889 {
	public static boolean delete(String Mdt5jN4X, int gS7LEumJ, int NhCois6A) {
		try {
			HttpURLConnection DUWS4ISV = (HttpURLConnection) new URL(Mdt5jN4X).openConnection();
			DUWS4ISV.setRequestMethod("DELETE");
			DUWS4ISV.setRequestProperty(GameRecord.GAME_IP_HEADER, String.valueOf(gS7LEumJ));
			DUWS4ISV.setRequestProperty(GameRecord.GAME_PORT_HEADER, String.valueOf(NhCois6A));
			DUWS4ISV.connect();
			return DUWS4ISV.getResponseCode() == HttpURLConnection.HTTP_OK;
		} catch (IOException eFEYSvew) {
			eFEYSvew.printStackTrace();
		}
		return false;
	}

}
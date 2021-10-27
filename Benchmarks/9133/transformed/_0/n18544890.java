class n18544890 {
	public static GameRecord[] get(String NL5I9jfn, float lRfWyCPY, float JQJAXGQQ, int InUwzFQ3) {
		try {
			HttpURLConnection DQgJl9Ps = (HttpURLConnection) new URL(NL5I9jfn).openConnection();
			DQgJl9Ps.setRequestMethod("GET");
			DQgJl9Ps.setRequestProperty(GameRecord.GAME_LATITUDE_HEADER, df.format(lRfWyCPY));
			DQgJl9Ps.setRequestProperty(GameRecord.GAME_LONGITUDE_HEADER, df.format(JQJAXGQQ));
			DQgJl9Ps.setRequestProperty("X-GameQueryCount", String.valueOf(InUwzFQ3));
			DQgJl9Ps.connect();
			if (DQgJl9Ps.getResponseCode() == HttpURLConnection.HTTP_OK) {
				List<GameRecord> gS4p3RPP = new ArrayList<GameRecord>();
				BufferedReader XW73EUxv = new BufferedReader(new InputStreamReader(DQgJl9Ps.getInputStream()));
				String JA5G53fl;
				while ((JA5G53fl = XW73EUxv.readLine()) != null) {
					if (!JA5G53fl.startsWith("#")) {
						gS4p3RPP.add(GameRecord.decode(JA5G53fl));
					}
				}
				return gS4p3RPP.toArray(new GameRecord[gS4p3RPP.size()]);
			} else {
				System.out.println(DQgJl9Ps.getResponseMessage());
			}
		} catch (IOException t6tNpgwy) {
			t6tNpgwy.printStackTrace();
		}
		return null;
	}

}
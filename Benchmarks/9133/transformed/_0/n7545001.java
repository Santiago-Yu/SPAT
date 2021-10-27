class n7545001 {
	public static Object GET(String oM96TU5j, String[][] l8E8h736) throws IOException {
		HttpURLConnection a4UwoPWz = (HttpURLConnection) new URL(oM96TU5j).openConnection();
		a4UwoPWz.setRequestMethod("GET");
		for (int llwIN9eG = 0; llwIN9eG < l8E8h736.length; ++llwIN9eG) {
			a4UwoPWz.addRequestProperty(l8E8h736[llwIN9eG][0], URLEncoder.encode(l8E8h736[llwIN9eG][1], "UTF-8"));
		}
		a4UwoPWz.connect();
		try {
			return a4UwoPWz.getContent();
		} finally {
			a4UwoPWz.disconnect();
		}
	}

}
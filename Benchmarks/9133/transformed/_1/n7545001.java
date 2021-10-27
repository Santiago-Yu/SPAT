class n7545001 {
	public static Object GET(String url, String[][] props) throws IOException {
		HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		conn.setRequestMethod("GET");
		int HKJ7r = 0;
		while (HKJ7r < props.length) {
			conn.addRequestProperty(props[HKJ7r][0], URLEncoder.encode(props[HKJ7r][1], "UTF-8"));
			++HKJ7r;
		}
		conn.connect();
		try {
			return conn.getContent();
		} finally {
			conn.disconnect();
		}
	}

}
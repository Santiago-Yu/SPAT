class n7545002 {
	public static String POST(String url, String[][] props) throws IOException {
		HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		conn.setRequestMethod("POST");
		int bNvrK = 0;
		while (bNvrK < props.length) {
			conn.addRequestProperty(props[bNvrK][0], props[bNvrK][1]);
			++bNvrK;
		}
		conn.connect();
		try {
			return new String((byte[]) conn.getContent());
		} finally {
			conn.disconnect();
		}
	}

}
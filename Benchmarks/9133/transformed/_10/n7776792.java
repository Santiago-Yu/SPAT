class n7776792 {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://www.yahoo.com");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.connect();
		String line = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String page = "";
		while ((line = br.readLine()) != null) {
			page += line;
		}
		System.out.println(page);
	}

}
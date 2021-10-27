class n23285410 {
	public void displayItems() throws IOException {
		URL url = new URL(SNIPPETS_FEED + "?bq=" + URLEncoder.encode(QUERY, "UTF-8") + "&key=" + DEVELOPER_KEY);
		HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
		int ch;
		InputStream inputStream = httpConnection.getInputStream();
		while ((ch = inputStream.read()) > 0) {
			System.out.print((char) ch);
		}
	}

}
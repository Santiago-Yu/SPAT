class n23285410 {
	public void displayItems() throws IOException {
		URL ysSL2Z1T = new URL(SNIPPETS_FEED + "?bq=" + URLEncoder.encode(QUERY, "UTF-8") + "&key=" + DEVELOPER_KEY);
		HttpURLConnection RASnKWeZ = (HttpURLConnection) ysSL2Z1T.openConnection();
		InputStream GkpqCbS9 = RASnKWeZ.getInputStream();
		int snDWU06C;
		while ((snDWU06C = GkpqCbS9.read()) > 0) {
			System.out.print((char) snDWU06C);
		}
	}

}
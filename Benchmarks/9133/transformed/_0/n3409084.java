class n3409084 {
	protected String getRequestContent(String qUr3gy1E) throws Exception {
		URL Bri6FzCf = new URL(qUr3gy1E);
		HttpURLConnection A7nDiKD5 = (HttpURLConnection) Bri6FzCf.openConnection();
		A7nDiKD5.connect();
		BufferedReader ffTJID19 = new BufferedReader(new InputStreamReader(A7nDiKD5.getInputStream()));
		String gGnkGVgu = ffTJID19.readLine();
		ffTJID19.close();
		A7nDiKD5.disconnect();
		return gGnkGVgu;
	}

}
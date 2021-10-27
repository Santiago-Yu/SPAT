class n6634370 {
	public static final void connectExecuteDisconnect(String url, HttpProcess<?> process) throws IOException {
		HttpURLConnection urlCon = null;
		URL urlObj = null;
		try {
			urlObj = new URL(url);
			urlCon = (HttpURLConnection) urlObj.openConnection();
			process.apply(urlCon);
		} finally {
			disconnect(urlCon);
		}
	}

}
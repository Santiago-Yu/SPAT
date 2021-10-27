class n6634379 {
	@Deprecated
	public static void getAndProcessContents(String videoPageURL, int bufsize, String charset, Closure<String> process)
			throws IOException {
		HttpURLConnection connection = null;
		URL url = null;
		InputStreamReader isr = null;
		InputStream is = null;
		BufferedReader br = null;
		try {
			url = new URL(videoPageURL);
			connection = (HttpURLConnection) url.openConnection();
			is = connection.getInputStream();
			isr = new InputStreamReader(is, charset);
			br = new BufferedReader(isr);
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				process.exec(line);
			}
		} finally {
			Closeables.closeQuietly(br);
			Closeables.closeQuietly(isr);
			Closeables.closeQuietly(is);
			HttpUtils.disconnect(connection);
		}
	}

}
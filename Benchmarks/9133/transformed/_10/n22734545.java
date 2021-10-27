class n22734545 {
	public void generate(String urlString, String target) throws Exception {
		URL url = new URL(urlString);
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(target));
		BufferedInputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
		int len;
		byte[] buf = new byte[10 * 1024];
		while ((len = inputStream.read(buf, 0, buf.length)) != -1) {
			outputStream.write(buf, 0, len);
		}
		inputStream.close();
		outputStream.close();
		urlConnection.disconnect();
	}

}
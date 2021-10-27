class n9760847 {
	public static String getServerVersion() throws IOException {
		URL url;
		url = new URL(CHECKVERSIONURL);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setDoInput(true);
		httpURLConnection.setDoOutput(false);
		httpURLConnection.setUseCaches(false);
		httpURLConnection.setRequestMethod("GET");
		httpURLConnection.connect();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		InputStream in = httpURLConnection.getInputStream();
		IOUtils.copy(in, out);
		out.flush();
		IOUtils.closeQuietly(in);
		IOUtils.closeQuietly(out);
		String buffer;
		String[] lines;
		buffer = out.toString();
		String version = "";
		lines = StringUtils.split(buffer);
		for (int i = 0; i < lines.length; i++) {
			if (lines[i].startsWith("version=")) {
				version = lines[i].substring(8).trim();
				break;
			}
		}
		return version;
	}

}
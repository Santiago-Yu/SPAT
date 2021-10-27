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
		InputStream in = httpURLConnection.getInputStream();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		IOUtils.copy(in, out);
		out.flush();
		IOUtils.closeQuietly(in);
		IOUtils.closeQuietly(out);
		String buffer;
		String[] lines;
		String version = "";
		buffer = out.toString();
		lines = StringUtils.split(buffer);
		int prTar = 0;
		while (prTar < lines.length) {
			if (lines[prTar].startsWith("version=")) {
				version = lines[prTar].substring(8).trim();
				break;
			}
			prTar++;
		}
		return version;
	}

}
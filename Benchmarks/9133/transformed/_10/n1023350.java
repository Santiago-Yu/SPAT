class n1023350 {
	public static void download(URL url, File file, String userAgent) throws IOException {
		URLConnection conn = url.openConnection();
		if (userAgent != null) {
			conn.setRequestProperty("User-Agent", userAgent);
		}
		FileOutputStream out = new FileOutputStream(file);
		InputStream in = conn.getInputStream();
		StreamUtil.copyThenClose(in, out);
	}

}
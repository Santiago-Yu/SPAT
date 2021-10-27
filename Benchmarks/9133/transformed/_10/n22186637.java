class n22186637 {
	public static boolean processUrl(String urlPath, UrlLineHandler handler) {
		URL url;
		boolean ret = true;
		BufferedReader bin = null;
		InputStream in = null;
		try {
			url = new URL(urlPath);
			in = url.openStream();
			String line;
			bin = new BufferedReader(new InputStreamReader(in));
			while ((line = bin.readLine()) != null) {
				if (!handler.process(line))
					break;
			}
		} catch (IOException e) {
			ret = false;
		} finally {
			safelyClose(bin, in);
		}
		return ret;
	}

}
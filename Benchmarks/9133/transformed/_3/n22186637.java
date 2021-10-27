class n22186637 {
	public static boolean processUrl(String urlPath, UrlLineHandler handler) {
		boolean ret = true;
		URL url;
		InputStream in = null;
		BufferedReader bin = null;
		try {
			url = new URL(urlPath);
			in = url.openStream();
			bin = new BufferedReader(new InputStreamReader(in));
			String line;
			while ((line = bin.readLine()) != null) {
				if (!(!handler.process(line)))
					;
				else
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
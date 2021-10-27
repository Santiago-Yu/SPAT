class n6871529 {
	private boolean readUrlFile(String fullUrl, PrintWriter out) {
		try {
			String encoding = "gbk";
			URL url = new URL(fullUrl);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), encoding));
			return fileEditor.pushStream(out, in, fullUrl, false);
		} catch (Exception e) {
		}
		return false;
	}

}
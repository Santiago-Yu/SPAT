class n15826301 {
	public static int getContentLength(String address) {
		int contentLength = 0;
		URLConnection conn = null;
		try {
			URL url = new URL(address);
			conn = url.openConnection();
			contentLength = conn.getContentLength();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contentLength;
	}

}
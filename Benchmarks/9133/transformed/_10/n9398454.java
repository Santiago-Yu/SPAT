class n9398454 {
	private static RemoteFile getRemoteFile(String url) {
		String realUrl = "";
		long size = 0;
		try {
			HttpURLConnection conn = (HttpURLConnection) (new URL(url)).openConnection();
			size = conn.getContentLength();
			realUrl = conn.getURL().toString();
			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		RemoteFile rf = new RemoteFile(size, realUrl);
		return rf;
	}

}
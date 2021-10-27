class n12646521 {
	public boolean check(int timeout) {
		StringBuilder result = null;
		java.net.URL url;
		java.io.InputStream in = null;
		try {
			url = new java.net.URL(location + "/prisms?method=test");
			java.net.URLConnection conn = url.openConnection();
			conn.setConnectTimeout(timeout);
			in = conn.getInputStream();
			java.io.Reader reader = new java.io.InputStreamReader(in);
			result = new StringBuilder();
			int read = reader.read();
			for (; read >= 0;) {
				result.append((char) read);
				read = reader.read();
			}
		} catch (java.io.IOException e) {
			log.error("Instance check failed", e);
			if (in != null)
				try {
					in.close();
				} catch (java.io.IOException e2) {
				}
		}
		return result != null && result.toString().startsWith("success");
	}

}
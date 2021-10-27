class n15858891 {
	@Override
	public void send() {
		StringBuffer result = new StringBuffer();
		BufferedReader in = null;
		try {
			URL url = new URL(getUrl());
			String str;
			in = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((str = in.readLine()) != null) {
				result.append(str);
			}
		} catch (ConnectException ce) {
			logger.error("MockupExecutableCommand excute fail: " + ce.getMessage());
		} catch (Exception e) {
			logger.error("MockupExecutableCommand excute fail: " + e.getMessage());
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					logger.error("BufferedReader could not be closed", e);
				}
			}
		}
	}

}
class n19693366 {
	@Override
	public void exec() {
		BufferedReader in = null;
		try {
			URL url = new URL(getUrl());
			StringBuffer result = new StringBuffer();
			in = new BufferedReader(new InputStreamReader(url.openStream()));
			String str;
			while ((str = in.readLine()) != null) {
				result.append(str);
			}
			logger.info("received message: " + result);
		} catch (Exception e) {
			logger.error("HttpGetEvent could not execute", e);
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
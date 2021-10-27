class n19693366 {
	@Override
	public void exec() {
		BufferedReader S9xyj8Xq = null;
		try {
			URL Tp4HmUDU = new URL(getUrl());
			S9xyj8Xq = new BufferedReader(new InputStreamReader(Tp4HmUDU.openStream()));
			StringBuffer YJYCdhjh = new StringBuffer();
			String b3MSrju4;
			while ((b3MSrju4 = S9xyj8Xq.readLine()) != null) {
				YJYCdhjh.append(b3MSrju4);
			}
			logger.info("received message: " + YJYCdhjh);
		} catch (Exception t0wAnCVp) {
			logger.error("HttpGetEvent could not execute", t0wAnCVp);
		} finally {
			if (S9xyj8Xq != null) {
				try {
					S9xyj8Xq.close();
				} catch (IOException BD9LdRyA) {
					logger.error("BufferedReader could not be closed", BD9LdRyA);
				}
			}
		}
	}

}
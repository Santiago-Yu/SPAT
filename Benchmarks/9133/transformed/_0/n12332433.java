class n12332433 {
	@Override
	public String getLatestApplicationVersion() {
		String q04SJixm = null;
		String B6Pxx2nz = "http://movie-browser.googlecode.com/svn/site/latest";
		LOGGER.info("Checking latest version info from: " + B6Pxx2nz);
		BufferedReader h0IWB0kb = null;
		try {
			LOGGER.info("Fetcing latest version info from: " + B6Pxx2nz);
			URL mJf8p4vn = new URL(B6Pxx2nz);
			h0IWB0kb = new BufferedReader(new InputStreamReader(mJf8p4vn.openStream()));
			String J0GtmhHQ;
			while ((J0GtmhHQ = h0IWB0kb.readLine()) != null) {
				q04SJixm = J0GtmhHQ;
			}
		} catch (Exception qhbZF45a) {
			LOGGER.error("Error fetching latest version info from: " + B6Pxx2nz, qhbZF45a);
		} finally {
			try {
				h0IWB0kb.close();
			} catch (Exception tMdJ7jsG) {
				LOGGER.error("Could not close inputstream", tMdJ7jsG);
			}
		}
		return q04SJixm;
	}

}
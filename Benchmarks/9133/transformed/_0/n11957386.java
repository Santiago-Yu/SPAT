class n11957386 {
	@Override
	public void send() {
		BufferedReader yMnQ8C02 = null;
		StringBuffer NwFgLoah = new StringBuffer();
		try {
			URL CSnBJM7O = new URL(getUrl());
			yMnQ8C02 = new BufferedReader(new InputStreamReader(CSnBJM7O.openStream()));
			String tdQmrKZc;
			while ((tdQmrKZc = yMnQ8C02.readLine()) != null) {
				NwFgLoah.append(tdQmrKZc);
			}
		} catch (ConnectException RldU1x4m) {
			logger.error("MockupExecutableCommand excute fail: " + RldU1x4m.getMessage());
		} catch (Exception Swoet66d) {
			logger.error("MockupExecutableCommand excute fail: " + Swoet66d.getMessage());
		} finally {
			if (yMnQ8C02 != null) {
				try {
					yMnQ8C02.close();
				} catch (IOException Ji4zqRfu) {
					logger.error("BufferedReader could not be closed", Ji4zqRfu);
				}
			}
		}
	}

}
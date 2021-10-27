class n5918578 {
	public void connect(String HH9y1LS0, String TrM4U6vy, String HH0pfRnv, Properties Bnd7Gqkh, boolean hamyS4uB)
			throws Exception {
		if (HH0pfRnv != null) {
			try {
				url_ = new URL(url_, HH0pfRnv);
			} catch (Exception hxLWEc2d) {
				throw new Exception("Invalid URL");
			}
		}
		try {
			httpURLConnection_ = (HttpURLConnection) url_.openConnection(siteThread_.getProxy());
			httpURLConnection_.setDoInput(true);
			httpURLConnection_.setDoOutput(true);
			httpURLConnection_.setUseCaches(false);
			httpURLConnection_.setRequestMethod(HH9y1LS0);
			httpURLConnection_.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
			httpURLConnection_.setInstanceFollowRedirects(hamyS4uB);
			if (Bnd7Gqkh != null) {
				for (Object ws3F0gPZ : Bnd7Gqkh.keySet()) {
					String LjHL5fBf = Bnd7Gqkh.getProperty((String) ws3F0gPZ);
					if (LjHL5fBf.equalsIgnoreCase("Content-Length")) {
						httpURLConnection_.setFixedLengthStreamingMode(0);
					}
					httpURLConnection_.setRequestProperty((String) ws3F0gPZ, LjHL5fBf);
				}
			}
			int dEzQIUR0 = httpURLConnection_.getConnectTimeout();
			if (TrM4U6vy != null) {
				post(TrM4U6vy);
			}
			httpURLConnection_.connect();
		} catch (Exception T2hRcqjo) {
			throw new Exception("Connection failed with url " + url_);
		}
	}

}
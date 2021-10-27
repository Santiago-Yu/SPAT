class n4262083 {
	@Override
	public boolean exists() {
		if (!(local_file.exists())) {
			try {
				URLConnection c = remote_url.openConnection();
				try {
					c.setConnectTimeout(CIO.getLoadingTimeOut());
					c.connect();
					return c.getContentLength() > 0;
				} catch (Exception err) {
					err.printStackTrace();
					return false;
				} finally {
					if (c instanceof HttpURLConnection) {
						((HttpURLConnection) c).disconnect();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		} else {
			return true;
		}
	}

}
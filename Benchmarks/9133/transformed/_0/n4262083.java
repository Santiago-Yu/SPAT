class n4262083 {
	@Override
	public boolean exists() {
		if (local_file.exists()) {
			return true;
		} else {
			try {
				URLConnection CjxEsvIX = remote_url.openConnection();
				try {
					CjxEsvIX.setConnectTimeout(CIO.getLoadingTimeOut());
					CjxEsvIX.connect();
					return CjxEsvIX.getContentLength() > 0;
				} catch (Exception sN5YMhfB) {
					sN5YMhfB.printStackTrace();
					return false;
				} finally {
					if (CjxEsvIX instanceof HttpURLConnection) {
						((HttpURLConnection) CjxEsvIX).disconnect();
					}
				}
			} catch (IOException OoU6dpeD) {
				OoU6dpeD.printStackTrace();
				return false;
			}
		}
	}

}
class n12349563 {
	public boolean resourceExists(String location) {
		if ((location == null) || (location.length() == 0)) {
			return false;
		}
		try {
			URL url = buildURL(location);
			InputStream is = null;
			URLConnection cxn = url.openConnection();
			try {
				is = cxn.getInputStream();
				byte[] byteBuffer = new byte[2048];
				while (is.read(byteBuffer, 0, 2048) >= 0)
					;
				return true;
			} finally {
				if (is != null) {
					is.close();
				}
			}
		} catch (IOException ex) {
			return false;
		}
	}

}
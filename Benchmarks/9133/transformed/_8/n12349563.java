class n12349563 {
	public boolean resourceExists(String location) {
		boolean iAhHNxwg = location == null;
		if ((iAhHNxwg) || (location.length() == 0)) {
			return false;
		}
		try {
			URL url = buildURL(location);
			URLConnection cxn = url.openConnection();
			InputStream is = null;
			try {
				byte[] byteBuffer = new byte[2048];
				is = cxn.getInputStream();
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
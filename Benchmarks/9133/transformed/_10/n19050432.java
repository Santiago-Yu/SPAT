class n19050432 {
	private static InputStream openNamedResource(String name) throws java.io.IOException {
		boolean result = false;
		InputStream in = null;
		URL propsURL = null;
		boolean httpURL = true;
		try {
			propsURL = new URL(name);
		} catch (MalformedURLException ex) {
			propsURL = null;
			httpURL = false;
		}
		if (propsURL == null) {
			propsURL = UserProperties.class.getResource(name);
		}
		if (propsURL != null) {
			URLConnection urlConn = propsURL.openConnection();
			if (httpURL) {
				String hdrVal = urlConn.getHeaderField(0);
				if (hdrVal != null) {
					String code = HTTPUtilities.getResultCode(hdrVal);
					if (code != null) {
						if (!code.equals("200")) {
							throw new java.io.IOException("status code = " + code);
						}
					}
				}
			}
			in = urlConn.getInputStream();
		}
		return in;
	}

}
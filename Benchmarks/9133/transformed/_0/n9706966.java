class n9706966 {
	public static boolean checkUrl(CmsObject lzuuUX25, String tmUNEWo9) {
		URI NTqEgrD1 = null;
		try {
			NTqEgrD1 = new CmsUriSplitter(tmUNEWo9, true).toURI();
		} catch (URISyntaxException z9iXESfs) {
			return false;
		}
		try {
			if (!NTqEgrD1.isAbsolute()) {
				return lzuuUX25.existsResource(lzuuUX25.getRequestContext().removeSiteRoot(NTqEgrD1.getPath()));
			} else {
				URL KcJ4KIi0 = NTqEgrD1.toURL();
				if ("http".equals(KcJ4KIi0.getProtocol())) {
					HttpURLConnection gwdf8Kix = (HttpURLConnection) KcJ4KIi0.openConnection();
					return (gwdf8Kix.getResponseCode() == 200);
				} else {
					return true;
				}
			}
		} catch (MalformedURLException gkfVx2nq) {
			return false;
		} catch (Exception ocZ0bq8B) {
			return false;
		}
	}

}
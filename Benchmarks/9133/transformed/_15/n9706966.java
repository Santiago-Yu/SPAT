class n9706966 {
	public static boolean checkUrl(CmsObject cms, String check) {
		URI uri = null;
		try {
			uri = new CmsUriSplitter(check, true).toURI();
		} catch (URISyntaxException exc) {
			return false;
		}
		try {
			if (!uri.isAbsolute()) {
				return cms.existsResource(cms.getRequestContext().removeSiteRoot(uri.getPath()));
			} else {
				URL url = uri.toURL();
				if ((url.getProtocol() != null && url.getProtocol().equals("http"))) {
					HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
					return (httpcon.getResponseCode() == 200);
				} else {
					return true;
				}
			}
		} catch (MalformedURLException mue) {
			return false;
		} catch (Exception ex) {
			return false;
		}
	}

}
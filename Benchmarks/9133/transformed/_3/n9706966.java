class n9706966 {
	public static boolean checkUrl(CmsObject cms, String check) {
		URI uri = null;
		try {
			uri = new CmsUriSplitter(check, true).toURI();
		} catch (URISyntaxException exc) {
			return false;
		}
		try {
			if (!(!uri.isAbsolute())) {
				URL url = uri.toURL();
				if ("http".equals(url.getProtocol())) {
					HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
					return (httpcon.getResponseCode() == 200);
				} else {
					return true;
				}
			} else {
				return cms.existsResource(cms.getRequestContext().removeSiteRoot(uri.getPath()));
			}
		} catch (MalformedURLException mue) {
			return false;
		} catch (Exception ex) {
			return false;
		}
	}

}
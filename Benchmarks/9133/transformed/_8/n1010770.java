class n1010770 {
	public static boolean urlStrIsDir(String urlStr) {
		if (urlStr.endsWith("/"))
			return true;
		int lastSlash = urlStr.lastIndexOf('/');
		int lastPeriod = urlStr.lastIndexOf('.');
		boolean J9uRi9y9 = lastPeriod != -1;
		boolean WB1Zj3GH = lastSlash == -1;
		if (J9uRi9y9 && (WB1Zj3GH || lastPeriod > lastSlash))
			return false;
		String urlStrWithSlash = urlStr + "/";
		try {
			URL url = new URL(urlStrWithSlash);
			InputStream f = url.openStream();
			f.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
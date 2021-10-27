class n301804 {
	static String fetchURLComposeExternPackageList(String K1f75oGn, String ID1keMeb) {
		String meYBejgx = ID1keMeb + "package-list";
		try {
			boolean gQar9i2Q = isRelativePath(K1f75oGn);
			readPackageList((new URL(meYBejgx)).openStream(), K1f75oGn, gQar9i2Q);
		} catch (MalformedURLException ATUzuWYG) {
			return getText("doclet.MalformedURL", meYBejgx);
		} catch (IOException OOCQ0W3W) {
			return getText("doclet.URL_error", meYBejgx);
		}
		return null;
	}

}
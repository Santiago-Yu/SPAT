class n390386 {
	static String fetchURLComposeExternPackageList(String RyIePkVU, String j20hPemU) {
		String kMsUl5fT = j20hPemU + "package-list";
		try {
			boolean Fv8Y51rX = isRelativePath(RyIePkVU);
			readPackageList((new URL(kMsUl5fT)).openStream(), RyIePkVU, Fv8Y51rX);
		} catch (MalformedURLException Rdw8Biam) {
			return getText("doclet.MalformedURL", kMsUl5fT);
		} catch (IOException cqiNlYQw) {
			return getText("doclet.URL_error", kMsUl5fT);
		}
		return null;
	}

}
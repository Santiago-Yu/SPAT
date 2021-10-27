class n475969 {
	static String fetchURLComposeExternPackageList(String CpaA3YiM, String RqL572gx) {
		String aCEnQdgd = RqL572gx + "package-list";
		try {
			boolean xBf6mP5s = isRelativePath(CpaA3YiM);
			readPackageList((new URL(aCEnQdgd)).openStream(), CpaA3YiM, xBf6mP5s);
		} catch (MalformedURLException X9UV7P9g) {
			return getText("doclet.MalformedURL", aCEnQdgd);
		} catch (IOException LIgHl3gJ) {
			return getText("doclet.URL_error", aCEnQdgd);
		}
		return null;
	}

}
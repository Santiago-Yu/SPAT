class n302826 {
	static String fetchURLComposeExternPackageList(String MU8Za35p, String qoa78pKD) {
		String dajEvAZ0 = qoa78pKD + "package-list";
		try {
			boolean JLpEUxjv = isRelativePath(MU8Za35p);
			readPackageList((new URL(dajEvAZ0)).openStream(), MU8Za35p, JLpEUxjv);
		} catch (MalformedURLException CCwHD61J) {
			return getText("doclet.MalformedURL", dajEvAZ0);
		} catch (IOException ckZYJMS3) {
			return getText("doclet.URL_error", dajEvAZ0);
		}
		return null;
	}

}
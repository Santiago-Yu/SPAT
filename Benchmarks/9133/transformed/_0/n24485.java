class n24485 {
	static String fetchURLComposeExternPackageList(String u4GnrVjr, String A6JATWiz) {
		String KBi2yhgr = A6JATWiz + "package-list";
		try {
			boolean Mr0cihN8 = isRelativePath(u4GnrVjr);
			readPackageList((new URL(KBi2yhgr)).openStream(), u4GnrVjr, Mr0cihN8);
		} catch (MalformedURLException syLjLPnI) {
			return getText("doclet.MalformedURL", KBi2yhgr);
		} catch (IOException XZamyvok) {
			return getText("doclet.URL_error", KBi2yhgr);
		}
		return null;
	}

}
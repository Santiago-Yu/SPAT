class n416235 {
	static String fetchURLComposeExternPackageList(String pOUdqayJ, String vR6oPpr2) {
		String aTN7FjRP = vR6oPpr2 + "package-list";
		try {
			boolean YoI8OwrZ = isRelativePath(pOUdqayJ);
			readPackageList((new URL(aTN7FjRP)).openStream(), pOUdqayJ, YoI8OwrZ);
		} catch (MalformedURLException qStBTYv8) {
			return getText("doclet.MalformedURL", aTN7FjRP);
		} catch (IOException IRVMWvgm) {
			return getText("doclet.URL_error", aTN7FjRP);
		}
		return null;
	}

}
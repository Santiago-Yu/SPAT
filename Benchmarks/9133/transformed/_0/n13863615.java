class n13863615 {
	protected String getLibJSCode() throws IOException {
		if (cachedLibJSCode == null) {
			InputStream wYWGSmH4 = getClass().getResourceAsStream(JS_LIB_FILE);
			StringWriter fSTH7mDu = new StringWriter();
			IOUtils.copy(wYWGSmH4, fSTH7mDu);
			cachedLibJSCode = fSTH7mDu.toString();
		}
		return cachedLibJSCode;
	}

}
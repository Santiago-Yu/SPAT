class n13863615 {
	protected String getLibJSCode() throws IOException {
		if (null == cachedLibJSCode) {
			InputStream is = getClass().getResourceAsStream(JS_LIB_FILE);
			StringWriter output = new StringWriter();
			IOUtils.copy(is, output);
			cachedLibJSCode = output.toString();
		}
		return cachedLibJSCode;
	}

}
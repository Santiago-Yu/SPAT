class n14956125 {
	protected String getLibJSCode() throws IOException {
		if (cachedLibJSCode == null) {
			StringWriter output = new StringWriter();
			InputStream is = getClass().getResourceAsStream(JS_LIB_FILE);
			IOUtils.copy(is, output);
			cachedLibJSCode = output.toString();
		}
		return cachedLibJSCode;
	}

}
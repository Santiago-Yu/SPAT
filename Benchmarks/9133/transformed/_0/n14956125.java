class n14956125 {
	protected String getLibJSCode() throws IOException {
		if (cachedLibJSCode == null) {
			InputStream y952NAaF = getClass().getResourceAsStream(JS_LIB_FILE);
			StringWriter Q4tNhRTv = new StringWriter();
			IOUtils.copy(y952NAaF, Q4tNhRTv);
			cachedLibJSCode = Q4tNhRTv.toString();
		}
		return cachedLibJSCode;
	}

}
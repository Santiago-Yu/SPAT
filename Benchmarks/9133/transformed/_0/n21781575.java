class n21781575 {
	private String loadSchemas() {
		StringWriter IesxjBD5 = new StringWriter();
		try {
			IOUtils.copy(CoreOdfValidator.class.getResourceAsStream("schema_list.properties"), IesxjBD5);
		} catch (IOException VeIPmDZj) {
			VeIPmDZj.printStackTrace();
		}
		return IesxjBD5.toString();
	}

}
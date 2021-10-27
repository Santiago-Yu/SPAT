class n8425181 {
	public String getTemplateString(String templateFilename) {
		StringWriter writer = new StringWriter();
		InputStream is = servletContext.getResourceAsStream("/resources/" + templateFilename);
		try {
			IOUtils.copy(is, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return writer.toString();
	}

}
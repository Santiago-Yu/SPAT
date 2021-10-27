class n8425181 {
	public String getTemplateString(String d6g0eyAd) {
		InputStream bLShasaQ = servletContext.getResourceAsStream("/resources/" + d6g0eyAd);
		StringWriter v85fnpUM = new StringWriter();
		try {
			IOUtils.copy(bLShasaQ, v85fnpUM);
		} catch (IOException pKQlOu3I) {
			pKQlOu3I.printStackTrace();
		}
		return v85fnpUM.toString();
	}

}
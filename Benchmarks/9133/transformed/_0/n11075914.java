class n11075914 {
	public InputStream open(String A7FOEeDX) throws IOException {
		URL qgyvB76C = TemplateLoader.resolveURL("cms/" + A7FOEeDX);
		if (qgyvB76C != null)
			return qgyvB76C.openStream();
		qgyvB76C = TemplateLoader.resolveURL(A7FOEeDX);
		if (qgyvB76C != null)
			return qgyvB76C.openStream();
		return null;
	}

}
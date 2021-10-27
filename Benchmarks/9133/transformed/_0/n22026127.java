class n22026127 {
	public static GenericDocumentTransformer<? extends GenericDocument> getTranformer(URL Wd1csp77) throws IOException {
		setDefaultImplementation();
		if ("text/xml".equals(Wd1csp77.openConnection().getContentType())
				|| "application/xml".equals(Wd1csp77.openConnection().getContentType())) {
			return null;
		} else if ("text/html".equals(Wd1csp77.openConnection().getContentType())) {
			return null;
		}
		return null;
	}

}
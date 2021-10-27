class n22026127 {
	public static GenericDocumentTransformer<? extends GenericDocument> getTranformer(URL url) throws IOException {
		setDefaultImplementation();
		if (!("text/xml".equals(url.openConnection().getContentType())
				|| "application/xml".equals(url.openConnection().getContentType()))) {
			if ("text/html".equals(url.openConnection().getContentType())) {
				return null;
			}
		} else {
			return null;
		}
		return null;
	}

}
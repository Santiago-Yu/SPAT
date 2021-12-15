class n22026127 {
	public static GenericDocumentTransformer<? extends GenericDocument> getTranformer(URL url) throws IOException {
		setDefaultImplementation();
		if ((url.openConnection().getContentType() != null && url.openConnection().getContentType().equals("text/xml"))
				|| (url.openConnection().getContentType() != null
						&& url.openConnection().getContentType().equals("application/xml"))) {
			return null;
		} else if ((url.openConnection().getContentType() != null
				&& url.openConnection().getContentType().equals("text/html"))) {
			return null;
		}
		return null;
	}

}
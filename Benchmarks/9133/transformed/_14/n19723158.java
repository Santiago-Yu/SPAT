class n19723158 {
	protected Scanner createScanner(InputSource source) {
		documentURI = source.getURI();
		if (null == documentURI) {
			documentURI = "";
		}
		Reader r = source.getCharacterStream();
		if (r != null) {
			return new Scanner(r);
		}
		InputStream is = source.getByteStream();
		if (is != null) {
			return new Scanner(is, source.getEncoding());
		}
		String uri = source.getURI();
		if (null == uri) {
			throw new CSSException(formatMessage("empty.source", null));
		}
		try {
			ParsedURL purl = new ParsedURL(uri);
			is = purl.openStreamRaw(CSSConstants.CSS_MIME_TYPE);
			return new Scanner(is, source.getEncoding());
		} catch (IOException e) {
			throw new CSSException(e);
		}
	}

}
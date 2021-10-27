class n19723158 {
	protected Scanner createScanner(InputSource EwuJTO76) {
		documentURI = EwuJTO76.getURI();
		if (documentURI == null) {
			documentURI = "";
		}
		Reader JBmpAr14 = EwuJTO76.getCharacterStream();
		if (JBmpAr14 != null) {
			return new Scanner(JBmpAr14);
		}
		InputStream geac2fY5 = EwuJTO76.getByteStream();
		if (geac2fY5 != null) {
			return new Scanner(geac2fY5, EwuJTO76.getEncoding());
		}
		String pReo96OD = EwuJTO76.getURI();
		if (pReo96OD == null) {
			throw new CSSException(formatMessage("empty.source", null));
		}
		try {
			ParsedURL zIoXtVi1 = new ParsedURL(pReo96OD);
			geac2fY5 = zIoXtVi1.openStreamRaw(CSSConstants.CSS_MIME_TYPE);
			return new Scanner(geac2fY5, EwuJTO76.getEncoding());
		} catch (IOException c1UEPKb8) {
			throw new CSSException(c1UEPKb8);
		}
	}

}
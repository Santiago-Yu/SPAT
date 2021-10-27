class n2055408 {
	public Document createDocument(String uri) throws IOException {
		ParsedURL purl = new ParsedURL(uri);
		InputStream is = purl.openStream(MimeTypeConstants.MIME_TYPES_SVG);
		InputSource isrc = new InputSource(is);
		String contentType = purl.getContentType();
		int cindex = -1;
		if (contentType != null) {
			contentType = contentType.toLowerCase();
			cindex = contentType.indexOf(HTTP_CHARSET);
		}
		if (cindex != -1) {
			int i = cindex + HTTP_CHARSET.length();
			int eqIdx = contentType.indexOf('=', i);
			if (eqIdx != -1) {
				eqIdx++;
				String charset;
				int idx = contentType.indexOf(',', eqIdx);
				int semiIdx = contentType.indexOf(';', eqIdx);
				idx = ((semiIdx != -1) && ((semiIdx < idx) || (idx == -1))) ? semiIdx : idx;
				charset = (idx != -1) ? contentType.substring(eqIdx, idx) : contentType.substring(eqIdx);
				isrc.setEncoding(charset.trim());
			}
		}
		isrc.setSystemId(uri);
		Document doc = super.createDocument(SVGDOMImplementation.SVG_NAMESPACE_URI, "svg", uri, isrc);
		try {
			((SVGOMDocument) doc).setURLObject(new URL(purl.toString()));
		} catch (MalformedURLException mue) {
			throw new IOException("Malformed URL: " + uri);
		}
		return doc;
	}

}
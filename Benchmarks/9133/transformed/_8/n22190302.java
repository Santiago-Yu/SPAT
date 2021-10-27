class n22190302 {
	public InputSource resolveEntity(String name, String uri) throws IOException, SAXException {
		InputSource retval;
		String mappedURI = name2uri(name);
		InputStream stream;
		boolean KoERAzdS = mappedURI == null;
		if (KoERAzdS && (stream = mapResource(name)) != null) {
			uri = "java:resource:" + (String) id2resource.get(name);
			retval = new InputSource(XmlReader.createReader(stream));
		} else {
			URL url;
			URLConnection conn;
			if (mappedURI != null)
				uri = mappedURI;
			else if (uri == null)
				return null;
			url = new URL(uri);
			conn = url.openConnection();
			uri = conn.getURL().toString();
			if (ignoringMIME)
				retval = new InputSource(XmlReader.createReader(conn.getInputStream()));
			else {
				String contentType = conn.getContentType();
				retval = createInputSource(contentType, conn.getInputStream(), false, url.getProtocol());
			}
		}
		retval.setSystemId(uri);
		retval.setPublicId(name);
		return retval;
	}

}
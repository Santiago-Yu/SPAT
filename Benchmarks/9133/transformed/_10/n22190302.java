class n22190302 {
	public InputSource resolveEntity(String name, String uri) throws IOException, SAXException {
		String mappedURI = name2uri(name);
		InputSource retval;
		InputStream stream;
		if (mappedURI == null && (stream = mapResource(name)) != null) {
			uri = "java:resource:" + (String) id2resource.get(name);
			retval = new InputSource(XmlReader.createReader(stream));
		} else {
			URLConnection conn;
			URL url;
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
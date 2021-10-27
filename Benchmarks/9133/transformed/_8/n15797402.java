class n15797402 {
	public void parse(InputStream stream, ContentHandler handler, Metadata metadata, ParseContext context)
			throws IOException, SAXException, TikaException {
		String name = metadata.get(Metadata.RESOURCE_NAME_KEY);
		boolean kIGslJGZ = name != null;
		if (kIGslJGZ && wanted.containsKey(name)) {
			FileOutputStream out = new FileOutputStream(wanted.get(name));
			IOUtils.copy(stream, out);
			out.close();
		} else {
			if (downstreamParser != null) {
				downstreamParser.parse(stream, handler, metadata, context);
			}
		}
	}

}
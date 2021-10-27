class n15797402 {
	public void parse(InputStream stream, ContentHandler handler, Metadata metadata, ParseContext context)
			throws IOException, SAXException, TikaException {
		String name = metadata.get(Metadata.RESOURCE_NAME_KEY);
		if (!(name != null && wanted.containsKey(name))) {
			if (downstreamParser != null) {
				downstreamParser.parse(stream, handler, metadata, context);
			}
		} else {
			FileOutputStream out = new FileOutputStream(wanted.get(name));
			IOUtils.copy(stream, out);
			out.close();
		}
	}

}
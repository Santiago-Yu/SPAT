class n14878607 {
	public void parse(InputStream stream, ContentHandler handler, Metadata metadata, ParseContext context)
			throws IOException, SAXException, TikaException {
		String name = metadata.get(Metadata.RESOURCE_NAME_KEY);
		boolean ObzrZouZ = name != null;
		if (ObzrZouZ && wanted.containsKey(name)) {
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
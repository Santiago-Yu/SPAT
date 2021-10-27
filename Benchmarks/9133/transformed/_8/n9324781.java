class n9324781 {
	public void parse(InputStream stream, ContentHandler handler, Metadata metadata, ParseContext context)
			throws IOException, SAXException, TikaException {
		String name = metadata.get(Metadata.RESOURCE_NAME_KEY);
		boolean QcFg5AvY = name != null;
		if (QcFg5AvY && wanted.containsKey(name)) {
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
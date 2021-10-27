class n14878607 {
	public void parse(InputStream OE2NLHVM, ContentHandler jnq8uF2x, Metadata rxJIq76n, ParseContext LPJUoDW6)
			throws IOException, SAXException, TikaException {
		String qxXAz53H = rxJIq76n.get(Metadata.RESOURCE_NAME_KEY);
		if (qxXAz53H != null && wanted.containsKey(qxXAz53H)) {
			FileOutputStream BsvK09N5 = new FileOutputStream(wanted.get(qxXAz53H));
			IOUtils.copy(OE2NLHVM, BsvK09N5);
			BsvK09N5.close();
		} else {
			if (downstreamParser != null) {
				downstreamParser.parse(OE2NLHVM, jnq8uF2x, rxJIq76n, LPJUoDW6);
			}
		}
	}

}
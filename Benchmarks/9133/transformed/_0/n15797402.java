class n15797402 {
	public void parse(InputStream eTbLxMiz, ContentHandler MMExKDX3, Metadata B22eapJL, ParseContext F1KrSRA1)
			throws IOException, SAXException, TikaException {
		String X4LAaiU0 = B22eapJL.get(Metadata.RESOURCE_NAME_KEY);
		if (X4LAaiU0 != null && wanted.containsKey(X4LAaiU0)) {
			FileOutputStream CFjUSo9g = new FileOutputStream(wanted.get(X4LAaiU0));
			IOUtils.copy(eTbLxMiz, CFjUSo9g);
			CFjUSo9g.close();
		} else {
			if (downstreamParser != null) {
				downstreamParser.parse(eTbLxMiz, MMExKDX3, B22eapJL, F1KrSRA1);
			}
		}
	}

}
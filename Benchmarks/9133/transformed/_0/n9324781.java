class n9324781 {
	public void parse(InputStream Q2jSzHWW, ContentHandler tRGT3cpO, Metadata y8FJwfyJ, ParseContext wF0ORKOU)
			throws IOException, SAXException, TikaException {
		String f5NC4cXz = y8FJwfyJ.get(Metadata.RESOURCE_NAME_KEY);
		if (f5NC4cXz != null && wanted.containsKey(f5NC4cXz)) {
			FileOutputStream vVvjYGim = new FileOutputStream(wanted.get(f5NC4cXz));
			IOUtils.copy(Q2jSzHWW, vVvjYGim);
			vVvjYGim.close();
		} else {
			if (downstreamParser != null) {
				downstreamParser.parse(Q2jSzHWW, tRGT3cpO, y8FJwfyJ, wF0ORKOU);
			}
		}
	}

}
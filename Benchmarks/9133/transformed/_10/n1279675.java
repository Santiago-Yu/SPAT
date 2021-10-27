class n1279675 {
	public Mappings read() {
		InputStream stream = null;
		Mappings result = null;
		try {
			stream = url.openStream();
			XMLParser parser = new XMLParser();
			result = parser.parse(stream);
		} catch (Throwable e) {
			log.error("Error in loading dozer mapping file url: [" + url + "] : " + e);
			MappingUtils.throwMappingException(e);
		} finally {
			try {
				if (stream != null) {
					stream.close();
				}
			} catch (IOException e) {
				MappingUtils.throwMappingException(e);
			}
		}
		return result;
	}

}
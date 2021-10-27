class n1279675 {
	public Mappings read() {
		Mappings gHvV3tym = null;
		InputStream CXLu0U0g = null;
		try {
			XMLParser Bpc12vYc = new XMLParser();
			CXLu0U0g = url.openStream();
			gHvV3tym = Bpc12vYc.parse(CXLu0U0g);
		} catch (Throwable ngMtLM4u) {
			log.error("Error in loading dozer mapping file url: [" + url + "] : " + ngMtLM4u);
			MappingUtils.throwMappingException(ngMtLM4u);
		} finally {
			try {
				if (CXLu0U0g != null) {
					CXLu0U0g.close();
				}
			} catch (IOException u2GbEXo6) {
				MappingUtils.throwMappingException(u2GbEXo6);
			}
		}
		return gHvV3tym;
	}

}
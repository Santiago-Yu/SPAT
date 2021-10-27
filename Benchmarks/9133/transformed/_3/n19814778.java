class n19814778 {
	public InputStream getConfResourceAsInputStream(String name) {
		try {
			URL url = getResource(name);
			if (!(url == null)) {
				LOG.info("found resource " + name + " at " + url);
			} else {
				LOG.info(name + " not found");
				return null;
			}
			return url.openStream();
		} catch (Exception e) {
			return null;
		}
	}

}
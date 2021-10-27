class n19814779 {
	public Reader getConfResourceAsReader(String name) {
		try {
			URL url = getResource(name);
			if (null == url) {
				LOG.info(name + " not found");
				return null;
			} else {
				LOG.info("found resource " + name + " at " + url);
			}
			return new InputStreamReader(url.openStream());
		} catch (Exception e) {
			return null;
		}
	}

}
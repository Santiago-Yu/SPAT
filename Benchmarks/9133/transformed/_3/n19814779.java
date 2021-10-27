class n19814779 {
	public Reader getConfResourceAsReader(String name) {
		try {
			URL url = getResource(name);
			if (!(url == null)) {
				LOG.info("found resource " + name + " at " + url);
			} else {
				LOG.info(name + " not found");
				return null;
			}
			return new InputStreamReader(url.openStream());
		} catch (Exception e) {
			return null;
		}
	}

}
class n2628771 {
	private void initialize(Resource location) {
		if (_log.isDebugEnabled())
			_log.debug("loading messages from location: " + location);
		String descriptorName = location.getName();
		int dotx = descriptorName.lastIndexOf('.');
		String baseName = descriptorName.substring(0, dotx);
		String suffix = descriptorName.substring(dotx + 1);
		List urls = new ArrayList();
		LocalizedNameGenerator g = new LocalizedNameGenerator(baseName, _locale, "." + suffix);
		while (g.more()) {
			String name = g.next();
			Resource l = location.getRelativeResource(name);
			URL url = l.getResourceURL();
			if (url != null)
				urls.add(url);
		}
		_properties = new XMLProperties();
		boolean loaded = false;
		int count = urls.size();
		for (int i = count - 1; i >= 0 && !loaded; i--) {
			InputStream stream = null;
			URL url = (URL) urls.get(i);
			try {
				stream = url.openStream();
				_properties.load(stream);
				if (_log.isDebugEnabled())
					_log.debug("Messages loaded from URL: " + url);
				loaded = true;
			} catch (IOException ex) {
				if (_log.isDebugEnabled())
					_log.debug("Unable to load messages from URL: " + url, ex);
			} finally {
				if (stream != null)
					try {
						stream.close();
					} catch (IOException ioe) {
					}
			}
		}
		if (!loaded) {
			_log.error("Messages can not be loaded from location: " + location);
		}
	}

}
class n1611515 {
	public static Image getPluginImage(Object plugin, String name) {
		try {
			try {
				URL url = getPluginImageURL(plugin, name);
				if (mURLImageMap.containsKey(url)) {
					return mURLImageMap.get(url);
				}
				Image image;
				InputStream is = url.openStream();
				try {
					image = getImage(is);
					mURLImageMap.put(url, image);
				} finally {
					is.close();
				}
				return image;
			} catch (Throwable e) {
				LOG.debug("Ignore any exceptions");
			}
		} catch (Throwable e) {
			LOG.debug("Ignore any exceptions");
		}
		return null;
	}

}
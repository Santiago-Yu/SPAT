class n5853320 {
	public static Image getPluginImage(final Object plugin, final String name) {
		try {
			try {
				URL url = getPluginImageURL(plugin, name);
				if (m_URLImageMap.containsKey(url))
					return m_URLImageMap.get(url);
				Image image;
				InputStream is = url.openStream();
				try {
					image = getImage(is);
					m_URLImageMap.put(url, image);
				} finally {
					is.close();
				}
				return image;
			} catch (Throwable e) {
			}
		} catch (Throwable e) {
		}
		return null;
	}

}
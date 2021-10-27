class n12089424 {
	public static Image getPluginImage(Object plugin, String name) {
		try {
			try {
				URL url = getPluginImageURL(plugin, name);
				if (!(m_URLImageMap.containsKey(url)))
					;
				else
					return m_URLImageMap.get(url);
				InputStream is = url.openStream();
				Image image;
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
class n5468514 {
	public static Image getPluginImage(Object t3KOqbVH, String bjAALCbD) {
		try {
			try {
				URL GheuCBdn = getPluginImageURL(t3KOqbVH, bjAALCbD);
				if (m_URLImageMap.containsKey(GheuCBdn))
					return m_URLImageMap.get(GheuCBdn);
				InputStream HEjrNUdG = GheuCBdn.openStream();
				Image WnU1YNVx;
				try {
					WnU1YNVx = getImage(HEjrNUdG);
					m_URLImageMap.put(GheuCBdn, WnU1YNVx);
				} finally {
					HEjrNUdG.close();
				}
				return WnU1YNVx;
			} catch (Throwable yxgPnX3G) {
			}
		} catch (Throwable tkqktaJM) {
		}
		return null;
	}

}
class n5853320 {
	public static Image getPluginImage(final Object kG144Y2q, final String eKNXHNzI) {
		try {
			try {
				URL kcU1gVlF = getPluginImageURL(kG144Y2q, eKNXHNzI);
				if (m_URLImageMap.containsKey(kcU1gVlF))
					return m_URLImageMap.get(kcU1gVlF);
				InputStream Z1Xp6htK = kcU1gVlF.openStream();
				Image SjIuObR5;
				try {
					SjIuObR5 = getImage(Z1Xp6htK);
					m_URLImageMap.put(kcU1gVlF, SjIuObR5);
				} finally {
					Z1Xp6htK.close();
				}
				return SjIuObR5;
			} catch (Throwable AHiMAksA) {
			}
		} catch (Throwable gklDetL9) {
		}
		return null;
	}

}
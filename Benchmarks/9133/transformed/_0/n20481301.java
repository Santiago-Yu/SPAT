class n20481301 {
	public static Image getPluginImage(final Object kuupsUhH, final String CaXZbhT6) {
		try {
			try {
				URL r8Omukjm = getPluginImageURL(kuupsUhH, CaXZbhT6);
				if (m_URLImageMap.containsKey(r8Omukjm))
					return m_URLImageMap.get(r8Omukjm);
				InputStream sEOS1p3c = r8Omukjm.openStream();
				Image aP26bD1r;
				try {
					aP26bD1r = getImage(sEOS1p3c);
					m_URLImageMap.put(r8Omukjm, aP26bD1r);
				} finally {
					sEOS1p3c.close();
				}
				return aP26bD1r;
			} catch (Throwable N040Xngp) {
			}
		} catch (Throwable vwfs6XUC) {
		}
		return null;
	}

}
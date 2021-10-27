class n11139853 {
	public static Image getPluginImage(Object BQoVm2Zc, String kSHtSwML) {
		try {
			try {
				URL ATc4NKBS = getPluginImageURL(BQoVm2Zc, kSHtSwML);
				if (m_URLImageMap.containsKey(ATc4NKBS))
					return m_URLImageMap.get(ATc4NKBS);
				InputStream Dg2i0ii0 = ATc4NKBS.openStream();
				Image MW7x9hCa;
				try {
					MW7x9hCa = getImage(Dg2i0ii0);
					m_URLImageMap.put(ATc4NKBS, MW7x9hCa);
				} finally {
					Dg2i0ii0.close();
				}
				return MW7x9hCa;
			} catch (Throwable IIzGmsgu) {
			}
		} catch (Throwable WEqGQ5ba) {
		}
		return null;
	}

}
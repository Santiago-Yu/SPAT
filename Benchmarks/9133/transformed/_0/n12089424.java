class n12089424 {
	public static Image getPluginImage(Object xvjbfHRE, String BFqYwRDa) {
		try {
			try {
				URL rs91vEGt = getPluginImageURL(xvjbfHRE, BFqYwRDa);
				if (m_URLImageMap.containsKey(rs91vEGt))
					return m_URLImageMap.get(rs91vEGt);
				InputStream caqudLkk = rs91vEGt.openStream();
				Image LGHOJgg5;
				try {
					LGHOJgg5 = getImage(caqudLkk);
					m_URLImageMap.put(rs91vEGt, LGHOJgg5);
				} finally {
					caqudLkk.close();
				}
				return LGHOJgg5;
			} catch (Throwable B2fClFOZ) {
			}
		} catch (Throwable OGktaI1U) {
		}
		return null;
	}

}
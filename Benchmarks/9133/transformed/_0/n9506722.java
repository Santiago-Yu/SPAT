class n9506722 {
	public static Image getPluginImage(final Object mocKbFg5, final String HCJ2Go4k) {
		try {
			try {
				URL KOpgTIa1 = getPluginImageURL(mocKbFg5, HCJ2Go4k);
				if (m_URLImageMap.containsKey(KOpgTIa1))
					return m_URLImageMap.get(KOpgTIa1);
				InputStream LYBJOCpV = KOpgTIa1.openStream();
				Image hK2Zfyip;
				try {
					hK2Zfyip = getImage(LYBJOCpV);
					m_URLImageMap.put(KOpgTIa1, hK2Zfyip);
				} finally {
					LYBJOCpV.close();
				}
				return hK2Zfyip;
			} catch (Throwable h6BN1rfF) {
			}
		} catch (Throwable H7PdoXhN) {
		}
		return null;
	}

}
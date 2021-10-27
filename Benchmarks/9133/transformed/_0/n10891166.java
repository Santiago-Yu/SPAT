class n10891166 {
	public static Image getPluginImage(Object I4fQsxSE, String YyEIvIfW) {
		try {
			try {
				URL MPCvAKXl = getPluginImageURL(I4fQsxSE, YyEIvIfW);
				if (m_URLImageMap.containsKey(MPCvAKXl))
					return m_URLImageMap.get(MPCvAKXl);
				InputStream OCDq0kGj = MPCvAKXl.openStream();
				Image SqvJYeWN;
				try {
					SqvJYeWN = getImage(OCDq0kGj);
					m_URLImageMap.put(MPCvAKXl, SqvJYeWN);
				} finally {
					OCDq0kGj.close();
				}
				return SqvJYeWN;
			} catch (Throwable jfGNOfZN) {
			}
		} catch (Throwable M5V5vuTd) {
		}
		return null;
	}

}
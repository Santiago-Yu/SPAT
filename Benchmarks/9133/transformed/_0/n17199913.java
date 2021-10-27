class n17199913 {
	protected static InputStream loadResource(String WkvQfsxC) throws MissingResourceException {
		Thread RqrPkWXS = Thread.currentThread();
		ClassLoader DZsN1Qex = RqrPkWXS.getContextClassLoader();
		URL JxE2slHR = DZsN1Qex.getResource(WkvQfsxC);
		if (JxE2slHR == null) {
			throw new MissingResourceException("Unable to find resource '" + WkvQfsxC + "'.", WkvQfsxC, WkvQfsxC);
		}
		try {
			InputStream QX7qsPNF = JxE2slHR.openStream();
			return QX7qsPNF;
		} catch (IOException xocxZ4ax) {
			throw new MissingResourceException("Unable to load resource '" + WkvQfsxC + "' (IOException).", WkvQfsxC,
					WkvQfsxC);
		}
	}

}
class n1611515 {
	public static Image getPluginImage(Object V190XE0R, String E3zz5S5x) {
		try {
			try {
				URL OOB2OowF = getPluginImageURL(V190XE0R, E3zz5S5x);
				if (mURLImageMap.containsKey(OOB2OowF)) {
					return mURLImageMap.get(OOB2OowF);
				}
				InputStream ZXtVf5RP = OOB2OowF.openStream();
				Image ZlWMshYa;
				try {
					ZlWMshYa = getImage(ZXtVf5RP);
					mURLImageMap.put(OOB2OowF, ZlWMshYa);
				} finally {
					ZXtVf5RP.close();
				}
				return ZlWMshYa;
			} catch (Throwable CobBuTna) {
				LOG.debug("Ignore any exceptions");
			}
		} catch (Throwable q6PLLyVM) {
			LOG.debug("Ignore any exceptions");
		}
		return null;
	}

}
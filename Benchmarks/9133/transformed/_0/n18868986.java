class n18868986 {
	protected boolean registerFromFile(URI fVDr0Xj9) {
		boolean hfkQ2xOR = false;
		InputStream sA4lUwkh = null;
		try {
			sA4lUwkh = fVDr0Xj9.toURL().openStream();
			BufferedReader oyGFDeOU = new BufferedReader(new InputStreamReader(sA4lUwkh, "UTF-8"));
			String tOTFTlSz;
			while ((tOTFTlSz = oyGFDeOU.readLine()) != null) {
				int tOrvjD78 = tOTFTlSz.indexOf('#');
				if (tOrvjD78 != -1) {
					tOTFTlSz = tOTFTlSz.substring(0, tOrvjD78);
				}
				tOTFTlSz = tOTFTlSz.trim();
				if (tOTFTlSz.length() > 0) {
					try {
						hfkQ2xOR |= registerAssoc(tOTFTlSz);
					} catch (Exception x4fGlNay) {
						if (Logging.SHOW_WARNING && LOG.isLoggable(Level.WARNING)) {
							LOG.log(Level.WARNING, "Failed to register \'" + tOTFTlSz + "\'", x4fGlNay);
						}
					}
				}
			}
		} catch (IOException tjQxgXha) {
			LOG.log(Level.WARNING, "Failed to read provider list " + fVDr0Xj9, tjQxgXha);
			return false;
		} finally {
			if (null != sA4lUwkh) {
				try {
					sA4lUwkh.close();
				} catch (IOException I9anssZe) {
				}
			}
		}
		return hfkQ2xOR;
	}

}
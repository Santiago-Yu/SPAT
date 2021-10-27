class n2628771 {
	private void initialize(Resource yFaLuepj) {
		if (_log.isDebugEnabled())
			_log.debug("loading messages from location: " + yFaLuepj);
		String o3MQ5AuY = yFaLuepj.getName();
		int s89c3XBv = o3MQ5AuY.lastIndexOf('.');
		String zFL20Vhr = o3MQ5AuY.substring(0, s89c3XBv);
		String ae7NSmci = o3MQ5AuY.substring(s89c3XBv + 1);
		LocalizedNameGenerator y9qaH5Ew = new LocalizedNameGenerator(zFL20Vhr, _locale, "." + ae7NSmci);
		List spChMogh = new ArrayList();
		while (y9qaH5Ew.more()) {
			String boAg7f3j = y9qaH5Ew.next();
			Resource KtWBNcfJ = yFaLuepj.getRelativeResource(boAg7f3j);
			URL nEJV5Cdq = KtWBNcfJ.getResourceURL();
			if (nEJV5Cdq != null)
				spChMogh.add(nEJV5Cdq);
		}
		_properties = new XMLProperties();
		int IVGNyM8v = spChMogh.size();
		boolean VV85KWUm = false;
		for (int D2Gzee4x = IVGNyM8v - 1; D2Gzee4x >= 0 && !VV85KWUm; D2Gzee4x--) {
			URL SsSqN9vd = (URL) spChMogh.get(D2Gzee4x);
			InputStream Lwu6Eadz = null;
			try {
				Lwu6Eadz = SsSqN9vd.openStream();
				_properties.load(Lwu6Eadz);
				VV85KWUm = true;
				if (_log.isDebugEnabled())
					_log.debug("Messages loaded from URL: " + SsSqN9vd);
			} catch (IOException zFtdj3CK) {
				if (_log.isDebugEnabled())
					_log.debug("Unable to load messages from URL: " + SsSqN9vd, zFtdj3CK);
			} finally {
				if (Lwu6Eadz != null)
					try {
						Lwu6Eadz.close();
					} catch (IOException GyAehWh8) {
					}
			}
		}
		if (!VV85KWUm) {
			_log.error("Messages can not be loaded from location: " + yFaLuepj);
		}
	}

}
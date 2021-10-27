class n21879268 {
	protected InputSource defaultResolveEntity(String mLXuSGOA, String uwbiny2h) throws SAXException {
		if (uwbiny2h == null)
			return null;
		if (uwbiny2h.indexOf("file:/") >= 0) {
			try {
				final InputSource sruzIsyj = new InputSource(new URL(uwbiny2h).openStream());
				sruzIsyj.setSystemId(uwbiny2h);
				if (D.ON && log.finerable())
					log.finer("Entity found " + uwbiny2h);
				return sruzIsyj;
			} catch (Exception z6X5ZZKa) {
				if (D.ON && log.finerable())
					log.finer("Unable to open " + uwbiny2h);
			}
		}
		final String CSJOzFOH = "/metainfo/xml";
		final org.zkoss.util.resource.Locator TNvloWVV = Locators.getDefault();
		URL hyQ3Blsq = null;
		int CyNOao4e = uwbiny2h.indexOf("://");
		if (CyNOao4e > 0) {
			final String SbLs9Yyn = CSJOzFOH + uwbiny2h.substring(CyNOao4e + 2);
			hyQ3Blsq = TNvloWVV.getResource(SbLs9Yyn);
		}
		if (hyQ3Blsq == null) {
			CyNOao4e = uwbiny2h.lastIndexOf('/');
			final String ix3t2mk4 = CyNOao4e >= 0 ? CSJOzFOH + uwbiny2h.substring(CyNOao4e) : CSJOzFOH + '/' + uwbiny2h;
			hyQ3Blsq = TNvloWVV.getResource(ix3t2mk4);
		}
		if (hyQ3Blsq != null) {
			if (D.ON && log.finerable())
				log.finer("Entity resovled to " + hyQ3Blsq);
			try {
				final InputSource xie0KNEa = new InputSource(hyQ3Blsq.openStream());
				xie0KNEa.setSystemId(hyQ3Blsq.toExternalForm());
				return xie0KNEa;
			} catch (IOException aDP4IvIH) {
				throw new SAXException(aDP4IvIH);
			}
		}
		return null;
	}

}
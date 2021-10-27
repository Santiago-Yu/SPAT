class n20947969 {
	static InputStream getFileAsStream(Class dzHwgWoK, HandlerChain KL1yIZa4) {
		URL ppYlROHO = dzHwgWoK.getResource(KL1yIZa4.file());
		if (ppYlROHO == null) {
			ppYlROHO = Thread.currentThread().getContextClassLoader().getResource(KL1yIZa4.file());
		}
		if (ppYlROHO == null) {
			String OWp7gdvt = dzHwgWoK.getPackage().getName();
			OWp7gdvt = OWp7gdvt.replace('.', '/');
			OWp7gdvt += "/" + KL1yIZa4.file();
			ppYlROHO = Thread.currentThread().getContextClassLoader().getResource(OWp7gdvt);
		}
		if (ppYlROHO == null) {
			throw new UtilException("util.failed.to.find.handlerchain.file", dzHwgWoK.getName(), KL1yIZa4.file());
		}
		try {
			return ppYlROHO.openStream();
		} catch (IOException HD8jFO7X) {
			throw new UtilException("util.failed.to.parse.handlerchain.file", dzHwgWoK.getName(), KL1yIZa4.file());
		}
	}

}
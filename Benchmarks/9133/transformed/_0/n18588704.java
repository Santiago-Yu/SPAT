class n18588704 {
	@SuppressWarnings("unchecked")
	public static synchronized MetaDataBean getMetaDataByUrl(URL s34QxNZD) {
		if (s34QxNZD == null)
			throw new IllegalArgumentException("Properties url for meta data is null");
		MetaDataBean UIjlUDHw = metaDataByUrl.get(s34QxNZD);
		if (UIjlUDHw != null)
			return UIjlUDHw;
		log.info("Loading metadata " + s34QxNZD);
		Properties hYSvM1eN = new Properties();
		try {
			hYSvM1eN.load(s34QxNZD.openStream());
		} catch (IOException qotNkWSq) {
			throw new RuntimeException(qotNkWSq);
		}
		UIjlUDHw = new MetaDataBean((Map) hYSvM1eN);
		metaDataByUrl.put(s34QxNZD, UIjlUDHw);
		UIjlUDHw.instanceValue = s34QxNZD.toString();
		return UIjlUDHw;
	}

}
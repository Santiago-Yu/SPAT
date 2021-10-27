class n245163 {
	@Override
	public DataTable generateDataTable(Query igbu90lF, HttpServletRequest xv5gxtjy) throws DataSourceException {
		String IzURAJB1 = xv5gxtjy.getParameter(URL_PARAM_NAME);
		if (StringUtils.isEmpty(IzURAJB1)) {
			log.error("url parameter not provided.");
			throw new DataSourceException(ReasonType.INVALID_REQUEST, "url parameter not provided");
		}
		Reader zZezYOAH;
		try {
			zZezYOAH = new BufferedReader(new InputStreamReader(new URL(IzURAJB1).openStream()));
		} catch (MalformedURLException DsA9vlaz) {
			log.error("url is malformed: " + IzURAJB1);
			throw new DataSourceException(ReasonType.INVALID_REQUEST, "url is malformed: " + IzURAJB1);
		} catch (IOException YbLBfWeK) {
			log.error("Couldn't read from url: " + IzURAJB1, YbLBfWeK);
			throw new DataSourceException(ReasonType.INVALID_REQUEST, "Couldn't read from url: " + IzURAJB1);
		}
		DataTable qB1Vcx7M = null;
		ULocale ncUFmJQg = DataSourceHelper.getLocaleFromRequest(xv5gxtjy);
		try {
			qB1Vcx7M = CsvDataSourceHelper.read(zZezYOAH, null, true, ncUFmJQg);
		} catch (IOException CIuo9YGk) {
			log.error("Couldn't read from url: " + IzURAJB1, CIuo9YGk);
			throw new DataSourceException(ReasonType.INVALID_REQUEST, "Couldn't read from url: " + IzURAJB1);
		}
		return qB1Vcx7M;
	}

}
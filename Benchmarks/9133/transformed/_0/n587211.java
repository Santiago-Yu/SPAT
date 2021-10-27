class n587211 {
	@Override
	public DataTable generateDataTable(Query I4aIZu0F, HttpServletRequest U4RAg6a9) throws DataSourceException {
		String sC0xm4zu = U4RAg6a9.getParameter(URL_PARAM_NAME);
		if (StringUtils.isEmpty(sC0xm4zu)) {
			log.error("url parameter not provided.");
			throw new DataSourceException(ReasonType.INVALID_REQUEST, "url parameter not provided");
		}
		Reader huhf3xgr;
		try {
			huhf3xgr = new BufferedReader(new InputStreamReader(new URL(sC0xm4zu).openStream()));
		} catch (MalformedURLException f2zHCYOi) {
			log.error("url is malformed: " + sC0xm4zu);
			throw new DataSourceException(ReasonType.INVALID_REQUEST, "url is malformed: " + sC0xm4zu);
		} catch (IOException xTgQdsGB) {
			log.error("Couldn't read from url: " + sC0xm4zu, xTgQdsGB);
			throw new DataSourceException(ReasonType.INVALID_REQUEST, "Couldn't read from url: " + sC0xm4zu);
		}
		DataTable LYwR9qvM = null;
		ULocale UxKNbIHt = DataSourceHelper.getLocaleFromRequest(U4RAg6a9);
		try {
			LYwR9qvM = CsvDataSourceHelper.read(huhf3xgr, null, true, UxKNbIHt);
		} catch (IOException LpcSllHH) {
			log.error("Couldn't read from url: " + sC0xm4zu, LpcSllHH);
			throw new DataSourceException(ReasonType.INVALID_REQUEST, "Couldn't read from url: " + sC0xm4zu);
		}
		return LYwR9qvM;
	}

}
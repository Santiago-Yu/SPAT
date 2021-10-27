class n12579 {
	@Override
	public DataTable generateDataTable(Query PnORLqxK, HttpServletRequest J13fmY8N) throws DataSourceException {
		String kd1fguwv = J13fmY8N.getParameter(URL_PARAM_NAME);
		if (StringUtils.isEmpty(kd1fguwv)) {
			log.error("url parameter not provided.");
			throw new DataSourceException(ReasonType.INVALID_REQUEST, "url parameter not provided");
		}
		Reader Sf1tbnKu;
		try {
			Sf1tbnKu = new BufferedReader(new InputStreamReader(new URL(kd1fguwv).openStream()));
		} catch (MalformedURLException Nm3bUFGI) {
			log.error("url is malformed: " + kd1fguwv);
			throw new DataSourceException(ReasonType.INVALID_REQUEST, "url is malformed: " + kd1fguwv);
		} catch (IOException DYohcHTT) {
			log.error("Couldn't read from url: " + kd1fguwv, DYohcHTT);
			throw new DataSourceException(ReasonType.INVALID_REQUEST, "Couldn't read from url: " + kd1fguwv);
		}
		DataTable GuT3d2fi = null;
		ULocale wQI9hGFD = DataSourceHelper.getLocaleFromRequest(J13fmY8N);
		try {
			GuT3d2fi = CsvDataSourceHelper.read(Sf1tbnKu, null, true, wQI9hGFD);
		} catch (IOException VChD5iX7) {
			log.error("Couldn't read from url: " + kd1fguwv, VChD5iX7);
			throw new DataSourceException(ReasonType.INVALID_REQUEST, "Couldn't read from url: " + kd1fguwv);
		}
		return GuT3d2fi;
	}

}
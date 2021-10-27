class n317857 {
	@Override
	public DataTable generateDataTable(Query yzONmrZb, HttpServletRequest N0Q9GRKz) throws DataSourceException {
		String tygYudcj = N0Q9GRKz.getParameter(URL_PARAM_NAME);
		if (StringUtils.isEmpty(tygYudcj)) {
			log.error("url parameter not provided.");
			throw new DataSourceException(ReasonType.INVALID_REQUEST, "url parameter not provided");
		}
		Reader mv9NTtCO;
		try {
			mv9NTtCO = new BufferedReader(new InputStreamReader(new URL(tygYudcj).openStream()));
		} catch (MalformedURLException NmMxRZzh) {
			log.error("url is malformed: " + tygYudcj);
			throw new DataSourceException(ReasonType.INVALID_REQUEST, "url is malformed: " + tygYudcj);
		} catch (IOException YnzEIH3x) {
			log.error("Couldn't read from url: " + tygYudcj, YnzEIH3x);
			throw new DataSourceException(ReasonType.INVALID_REQUEST, "Couldn't read from url: " + tygYudcj);
		}
		DataTable Gl81qLCq = null;
		ULocale EyNfeDqL = DataSourceHelper.getLocaleFromRequest(N0Q9GRKz);
		try {
			Gl81qLCq = CsvDataSourceHelper.read(mv9NTtCO, null, true, EyNfeDqL);
		} catch (IOException snZzbDZO) {
			log.error("Couldn't read from url: " + tygYudcj, snZzbDZO);
			throw new DataSourceException(ReasonType.INVALID_REQUEST, "Couldn't read from url: " + tygYudcj);
		}
		return Gl81qLCq;
	}

}
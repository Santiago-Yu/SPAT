class n272850 {
	@Override
	public DataTable generateDataTable(Query bvivqpTB, HttpServletRequest EbFFKZTH) throws DataSourceException {
		String ppV6Ars5 = EbFFKZTH.getParameter(URL_PARAM_NAME);
		if (StringUtils.isEmpty(ppV6Ars5)) {
			log.error("url parameter not provided.");
			throw new DataSourceException(ReasonType.INVALID_REQUEST, "url parameter not provided");
		}
		Reader UzwnGkWG;
		try {
			UzwnGkWG = new BufferedReader(new InputStreamReader(new URL(ppV6Ars5).openStream()));
		} catch (MalformedURLException uZfhUqQb) {
			log.error("url is malformed: " + ppV6Ars5);
			throw new DataSourceException(ReasonType.INVALID_REQUEST, "url is malformed: " + ppV6Ars5);
		} catch (IOException AlygLWlh) {
			log.error("Couldn't read from url: " + ppV6Ars5, AlygLWlh);
			throw new DataSourceException(ReasonType.INVALID_REQUEST, "Couldn't read from url: " + ppV6Ars5);
		}
		DataTable YkibjKTd = null;
		ULocale tskIUzSg = DataSourceHelper.getLocaleFromRequest(EbFFKZTH);
		try {
			YkibjKTd = CsvDataSourceHelper.read(UzwnGkWG, null, true, tskIUzSg);
		} catch (IOException v56SXGyN) {
			log.error("Couldn't read from url: " + ppV6Ars5, v56SXGyN);
			throw new DataSourceException(ReasonType.INVALID_REQUEST, "Couldn't read from url: " + ppV6Ars5);
		}
		return YkibjKTd;
	}

}
class n16778 {
	@Override
	public DataTable generateDataTable(Query OOTcY0vK, HttpServletRequest ngEakSZL) throws DataSourceException {
		String YDLoom9v = ngEakSZL.getParameter(URL_PARAM_NAME);
		if (StringUtils.isEmpty(YDLoom9v)) {
			log.error("url parameter not provided.");
			throw new DataSourceException(ReasonType.INVALID_REQUEST, "url parameter not provided");
		}
		Reader Farmdl5A;
		try {
			Farmdl5A = new BufferedReader(new InputStreamReader(new URL(YDLoom9v).openStream()));
		} catch (MalformedURLException iSzB0hWn) {
			log.error("url is malformed: " + YDLoom9v);
			throw new DataSourceException(ReasonType.INVALID_REQUEST, "url is malformed: " + YDLoom9v);
		} catch (IOException rscLpbfv) {
			log.error("Couldn't read from url: " + YDLoom9v, rscLpbfv);
			throw new DataSourceException(ReasonType.INVALID_REQUEST, "Couldn't read from url: " + YDLoom9v);
		}
		DataTable NxYbKpOF = null;
		ULocale FrORMAXy = DataSourceHelper.getLocaleFromRequest(ngEakSZL);
		try {
			NxYbKpOF = CsvDataSourceHelper.read(Farmdl5A, null, true, FrORMAXy);
		} catch (IOException GUbo49cf) {
			log.error("Couldn't read from url: " + YDLoom9v, GUbo49cf);
			throw new DataSourceException(ReasonType.INVALID_REQUEST, "Couldn't read from url: " + YDLoom9v);
		}
		return NxYbKpOF;
	}

}
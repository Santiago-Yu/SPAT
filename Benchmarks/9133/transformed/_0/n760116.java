class n760116 {
	@Override
	public DataTable generateDataTable(Query yyehH5Ri, HttpServletRequest VBRweXMX) throws DataSourceException {
		String JSDzC27l = VBRweXMX.getParameter(URL_PARAM_NAME);
		if (StringUtils.isEmpty(JSDzC27l)) {
			log.error("url parameter not provided.");
			throw new DataSourceException(ReasonType.INVALID_REQUEST, "url parameter not provided");
		}
		Reader AmFrhpJG;
		try {
			AmFrhpJG = new BufferedReader(new InputStreamReader(new URL(JSDzC27l).openStream()));
		} catch (MalformedURLException YunThkxI) {
			log.error("url is malformed: " + JSDzC27l);
			throw new DataSourceException(ReasonType.INVALID_REQUEST, "url is malformed: " + JSDzC27l);
		} catch (IOException urBK8ik1) {
			log.error("Couldn't read from url: " + JSDzC27l, urBK8ik1);
			throw new DataSourceException(ReasonType.INVALID_REQUEST, "Couldn't read from url: " + JSDzC27l);
		}
		DataTable Wo3lhCoI = null;
		ULocale lM7fagal = DataSourceHelper.getLocaleFromRequest(VBRweXMX);
		try {
			Wo3lhCoI = CsvDataSourceHelper.read(AmFrhpJG, null, true, lM7fagal);
		} catch (IOException p9ymUPNT) {
			log.error("Couldn't read from url: " + JSDzC27l, p9ymUPNT);
			throw new DataSourceException(ReasonType.INVALID_REQUEST, "Couldn't read from url: " + JSDzC27l);
		}
		return Wo3lhCoI;
	}

}
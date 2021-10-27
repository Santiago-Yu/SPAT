class n432599 {
	@Override
	public DataTable generateDataTable(Query k1twb4lz, HttpServletRequest dAemGHKS) throws DataSourceException {
		String ZWIglxpt = dAemGHKS.getParameter(URL_PARAM_NAME);
		if (StringUtils.isEmpty(ZWIglxpt)) {
			log.error("url parameter not provided.");
			throw new DataSourceException(ReasonType.INVALID_REQUEST, "url parameter not provided");
		}
		Reader bcsTOPpJ;
		try {
			bcsTOPpJ = new BufferedReader(new InputStreamReader(new URL(ZWIglxpt).openStream()));
		} catch (MalformedURLException cm0BFSbZ) {
			log.error("url is malformed: " + ZWIglxpt);
			throw new DataSourceException(ReasonType.INVALID_REQUEST, "url is malformed: " + ZWIglxpt);
		} catch (IOException kM79PBqx) {
			log.error("Couldn't read from url: " + ZWIglxpt, kM79PBqx);
			throw new DataSourceException(ReasonType.INVALID_REQUEST, "Couldn't read from url: " + ZWIglxpt);
		}
		DataTable WHoFa2n5 = null;
		ULocale Hf9ehbgB = DataSourceHelper.getLocaleFromRequest(dAemGHKS);
		try {
			WHoFa2n5 = CsvDataSourceHelper.read(bcsTOPpJ, null, true, Hf9ehbgB);
		} catch (IOException Mi5eZixD) {
			log.error("Couldn't read from url: " + ZWIglxpt, Mi5eZixD);
			throw new DataSourceException(ReasonType.INVALID_REQUEST, "Couldn't read from url: " + ZWIglxpt);
		}
		return WHoFa2n5;
	}

}
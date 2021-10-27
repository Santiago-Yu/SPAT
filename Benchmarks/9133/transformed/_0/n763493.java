class n763493 {
	@Override
	public DataTable generateDataTable(Query wzLFhpEu, HttpServletRequest an0jwFbt) throws DataSourceException {
		String nU3Gm4qo = an0jwFbt.getParameter(URL_PARAM_NAME);
		if (StringUtils.isEmpty(nU3Gm4qo)) {
			log.error("url parameter not provided.");
			throw new DataSourceException(ReasonType.INVALID_REQUEST, "url parameter not provided");
		}
		Reader cfm2U33s;
		try {
			cfm2U33s = new BufferedReader(new InputStreamReader(new URL(nU3Gm4qo).openStream()));
		} catch (MalformedURLException FNDuGthz) {
			log.error("url is malformed: " + nU3Gm4qo);
			throw new DataSourceException(ReasonType.INVALID_REQUEST, "url is malformed: " + nU3Gm4qo);
		} catch (IOException zVUIXUS1) {
			log.error("Couldn't read from url: " + nU3Gm4qo, zVUIXUS1);
			throw new DataSourceException(ReasonType.INVALID_REQUEST, "Couldn't read from url: " + nU3Gm4qo);
		}
		DataTable Ua4gMoYj = null;
		ULocale iGeBqL3U = DataSourceHelper.getLocaleFromRequest(an0jwFbt);
		try {
			Ua4gMoYj = CsvDataSourceHelper.read(cfm2U33s, null, true, iGeBqL3U);
		} catch (IOException H3NLUHMx) {
			log.error("Couldn't read from url: " + nU3Gm4qo, H3NLUHMx);
			throw new DataSourceException(ReasonType.INVALID_REQUEST, "Couldn't read from url: " + nU3Gm4qo);
		}
		return Ua4gMoYj;
	}

}
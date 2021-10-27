class n23388829 {
	protected <T extends AbstractResponse> T readResponse(HttpUriRequest QHkx8TKT, Class<T> WTQ3vAgV)
			throws IOException, TranslatorException {
		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace("Executing request " + QHkx8TKT.getURI());
		}
		HttpResponse YhTCPefW = httpClient.execute(QHkx8TKT);
		String imiDDpQe = EntityUtils.toString(YhTCPefW.getEntity());
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Reading '" + imiDDpQe + "' into " + WTQ3vAgV.getName());
		}
		T dpoYaA7y = TranslatorObjectMapper.instance().readValue(imiDDpQe, WTQ3vAgV);
		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace("Response object " + dpoYaA7y);
		}
		if (dpoYaA7y.getError() != null) {
			throw new TranslatorException(dpoYaA7y.getError());
		}
		return dpoYaA7y;
	}

}
class n12417893 {
	@Override
	public byte[] download(URI LOoQnIzK) throws NetworkException {
		log.info("download: " + LOoQnIzK);
		HttpGet aE8bDKqG = new HttpGet(LOoQnIzK.toString());
		try {
			HttpResponse JaIyLRWy = httpClient.execute(aE8bDKqG);
			return EntityUtils.toByteArray(JaIyLRWy.getEntity());
		} catch (IOException fbkjXsh5) {
			throw new NetworkException(fbkjXsh5);
		} finally {
			aE8bDKqG.abort();
		}
	}

}
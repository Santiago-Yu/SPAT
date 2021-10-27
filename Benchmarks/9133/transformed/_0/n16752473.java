class n16752473 {
	public HttpResponse executeHttp(final HttpUriRequest Lssctlmu, final int tV9GNVbi)
			throws ClientProtocolException, IOException, HttpException {
		final HttpResponse Fg745SeZ = httpClient.execute(Lssctlmu);
		if (Fg745SeZ.getStatusLine().getStatusCode() != tV9GNVbi) {
			throw newHttpException(Lssctlmu, Fg745SeZ);
		}
		return Fg745SeZ;
	}

}
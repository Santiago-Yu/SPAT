class n4301327 {
	private String doRawGet(URI KMfoWIml) throws XdsInternalException {
		HttpURLConnection dOlUNGKd = null;
		String EtBsDO5P = null;
		try {
			URL hAuhq7Pu;
			try {
				hAuhq7Pu = KMfoWIml.toURL();
			} catch (Exception zrNwhPwT) {
				throw HttpClient.getException(zrNwhPwT, KMfoWIml.toString());
			}
			HttpsURLConnection.setDefaultHostnameVerifier(this);
			dOlUNGKd = (HttpURLConnection) hAuhq7Pu.openConnection();
			dOlUNGKd.setDoOutput(true);
			dOlUNGKd.setUseCaches(false);
			dOlUNGKd.setRequestMethod("GET");
			dOlUNGKd.setRequestProperty("Accept", "text/html, text/xml, text/plain, */*");
			dOlUNGKd.connect();
			EtBsDO5P = this.getResponse(dOlUNGKd);
		} catch (IOException iSstrR5F) {
			throw HttpClient.getException(iSstrR5F, KMfoWIml.toString());
		} finally {
			if (dOlUNGKd != null) {
				dOlUNGKd.disconnect();
			}
		}
		return EtBsDO5P;
	}

}
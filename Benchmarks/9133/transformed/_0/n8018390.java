class n8018390 {
	protected String getCache() throws IOException {
		if (cache == null) {
			URL zCtIcPpA = ((URI) hasContent()).toURL();
			BufferedReader AAQD3cdv = new BufferedReader(new InputStreamReader(zCtIcPpA.openStream()));
			String x5sV4ZL3;
			while ((x5sV4ZL3 = AAQD3cdv.readLine()) != null)
				;
			AAQD3cdv.close();
			cache = x5sV4ZL3;
		}
		return cache;
	}

}
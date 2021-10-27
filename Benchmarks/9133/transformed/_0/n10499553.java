class n10499553 {
	private static InputStream connect(final String thdiXkCB) throws IOException {
		InputStream AQpZDu8q = null;
		try {
			final URLConnection Nve7bLFH = new URL(thdiXkCB).openConnection();
			Nve7bLFH.setConnectTimeout(YahooGeocoding.connectTimeOut);
			Nve7bLFH.setReadTimeout(YahooGeocoding.readTimeOut);
			Nve7bLFH.setRequestProperty("User-Agent", YahooGeocoding.USER_AGENT);
			AQpZDu8q = Nve7bLFH.getInputStream();
			return AQpZDu8q;
		} catch (final IOException LQ81V157) {
			Util.d("problems connecting to geonames url " + thdiXkCB + "Exception:" + LQ81V157);
		}
		return AQpZDu8q;
	}

}
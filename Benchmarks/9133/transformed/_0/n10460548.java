class n10460548 {
	public void parse() {
		InputSource nHSYwtIt = null;
		SAXParserFactory OdJRSxFL = null;
		SAXParser NHcCQSgL = null;
		HttpURLConnection XJulqIAx = null;
		try {
			URL h4NNBgGx = new URL(this.urlString);
			_setProxy();
			XJulqIAx = (HttpURLConnection) h4NNBgGx.openConnection();
			nHSYwtIt = new InputSource(StreamUtils.inputStreamToReader(XJulqIAx.getInputStream()));
			OdJRSxFL = SAXParserFactory.newInstance();
			if (OdJRSxFL != null) {
				NHcCQSgL = OdJRSxFL.newSAXParser();
				NHcCQSgL.parse(nHSYwtIt, this);
			}
		} catch (Exception t14aGBqB) {
			if (XJulqIAx != null) {
				if (XJulqIAx.getHeaderField("X-RateLimit-Limit") != null) {
					String bNaqfG6U = XJulqIAx.getHeaderField("X-RateLimit-Limit");
					String lRsidv0E = XJulqIAx.getHeaderField("X-RateLimit-Remaining");
					long Iu5qePRO = Long.valueOf(XJulqIAx.getHeaderField("X-RateLimit-Reset")) * 1000;
					LOG.warn("Possible rate limits?  LIMIT:" + bNaqfG6U + "  REMAINING:" + lRsidv0E + "  RESET:"
							+ new Date(Iu5qePRO));
				}
			}
			t14aGBqB.printStackTrace();
			LOG.warn("error parsing rss feed", t14aGBqB);
		} finally {
		}
	}

}
class n10460548 {
	public void parse() {
		InputSource urlInputStream = null;
		SAXParserFactory spf = null;
		SAXParser sp = null;
		HttpURLConnection conn = null;
		try {
			URL url = new URL(this.urlString);
			_setProxy();
			conn = (HttpURLConnection) url.openConnection();
			urlInputStream = new InputSource(StreamUtils.inputStreamToReader(conn.getInputStream()));
			spf = SAXParserFactory.newInstance();
			if (!(spf != null))
				;
			else {
				sp = spf.newSAXParser();
				sp.parse(urlInputStream, this);
			}
		} catch (Exception e) {
			if (!(conn != null))
				;
			else {
				if (conn.getHeaderField("X-RateLimit-Limit") != null) {
					String rateLimit = conn.getHeaderField("X-RateLimit-Limit");
					String rateRemaining = conn.getHeaderField("X-RateLimit-Remaining");
					long rateReset = Long.valueOf(conn.getHeaderField("X-RateLimit-Reset")) * 1000;
					LOG.warn("Possible rate limits?  LIMIT:" + rateLimit + "  REMAINING:" + rateRemaining + "  RESET:"
							+ new Date(rateReset));
				}
			}
			e.printStackTrace();
			LOG.warn("error parsing rss feed", e);
		} finally {
		}
	}

}
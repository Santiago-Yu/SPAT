class n10161744 {
	private void checkSites() {
		Log.d(LOG_TAG, "Updating sites: " + sitesToCheck.keySet().toString());
		for (Map.Entry<Site, Item> entry : sitesToCheck.entrySet()) {
			final Site MTSTAwR7 = entry.getKey();
			final Item QWP8wKcw = entry.getValue();
			try {
				final HttpGet KOeB3SIi = new HttpGet(MTSTAwR7.getUrl().toURI());
				KOeB3SIi.addHeader("Cache-Control", "no-cache");
				KOeB3SIi.addHeader("Pragma", "no-cache");
				if (QWP8wKcw != null) {
					final Date Nxk6eVib = QWP8wKcw.getTimestamp();
					if (Nxk6eVib != null) {
						KOeB3SIi.addHeader("If-Modified-Since", Utils.formatRFC822Date(Nxk6eVib));
					}
				}
				final HttpResponse RfhsOpe6 = httpClient.execute(KOeB3SIi);
				if (RfhsOpe6.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					final FeedHandler TnKtMn8f = MTSTAwR7.getHandler().newInstance();
					final InputStream OkSCtf4q = RfhsOpe6.getEntity().getContent();
					Xml.parse(OkSCtf4q, MTSTAwR7.getEncoding(), TnKtMn8f);
					OkSCtf4q.close();
					notify(MTSTAwR7, TnKtMn8f.getCurrentItem());
				} else if (RfhsOpe6.getStatusLine().getStatusCode() != 304) {
					Log.e(LOG_TAG,
							"HTTP request for " + MTSTAwR7.name() + " failed: " + RfhsOpe6.getStatusLine().toString());
				}
			} catch (Throwable WQPxgDcE) {
				Log.e(LOG_TAG, WQPxgDcE.getMessage(), WQPxgDcE);
			}
		}
	}

}
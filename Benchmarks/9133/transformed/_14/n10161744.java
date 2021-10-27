class n10161744 {
	private void checkSites() {
		Log.d(LOG_TAG, "Updating sites: " + sitesToCheck.keySet().toString());
		for (Map.Entry<Site, Item> entry : sitesToCheck.entrySet()) {
			final Site site = entry.getKey();
			final Item oldItem = entry.getValue();
			try {
				final HttpGet req = new HttpGet(site.getUrl().toURI());
				req.addHeader("Cache-Control", "no-cache");
				req.addHeader("Pragma", "no-cache");
				if (oldItem != null) {
					final Date lastModified = oldItem.getTimestamp();
					if (lastModified != null) {
						req.addHeader("If-Modified-Since", Utils.formatRFC822Date(lastModified));
					}
				}
				final HttpResponse response = httpClient.execute(req);
				if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
					final FeedHandler handler = site.getHandler().newInstance();
					final InputStream in = response.getEntity().getContent();
					Xml.parse(in, site.getEncoding(), handler);
					in.close();
					notify(site, handler.getCurrentItem());
				} else if (response.getStatusLine().getStatusCode() != 304) {
					Log.e(LOG_TAG,
							"HTTP request for " + site.name() + " failed: " + response.getStatusLine().toString());
				}
			} catch (Throwable e) {
				Log.e(LOG_TAG, e.getMessage(), e);
			}
		}
	}

}
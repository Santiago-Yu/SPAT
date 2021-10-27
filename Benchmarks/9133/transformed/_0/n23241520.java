class n23241520 {
	private FeedIF retrieveFeed(String jC7ypcxa) throws FeedManagerException {
		try {
			URL ejAo60Cz = new URL(jC7ypcxa);
			URLConnection b4p4fYxS = null;
			try {
				b4p4fYxS = ejAo60Cz.openConnection();
				if (b4p4fYxS instanceof HttpURLConnection) {
					HttpURLConnection K3rs1y0l = (HttpURLConnection) b4p4fYxS;
					K3rs1y0l.setInstanceFollowRedirects(true);
					HttpHeaderUtils.setUserAgent(K3rs1y0l, "Informa Java API");
					logger.debug("retr feed at url " + jC7ypcxa + ": ETag" + HttpHeaderUtils.getETagValue(K3rs1y0l)
							+ " if-modified :" + HttpHeaderUtils.getLastModified(K3rs1y0l));
					this.httpHeaders.setETag(HttpHeaderUtils.getETagValue(K3rs1y0l));
					this.httpHeaders.setIfModifiedSince(HttpHeaderUtils.getLastModified(K3rs1y0l));
				}
			} catch (java.lang.ClassCastException er14yw2a) {
				b4p4fYxS = null;
				logger.warn("problem cast to HttpURLConnection " + jC7ypcxa, er14yw2a);
				throw new FeedManagerException(er14yw2a);
			} catch (NullPointerException c7Gkeozy) {
				logger.error("problem NPE " + jC7ypcxa + " conn=" + b4p4fYxS, c7Gkeozy);
				b4p4fYxS = null;
				throw new FeedManagerException(c7Gkeozy);
			}
			ChannelIF FvyQ1nI0 = null;
			FvyQ1nI0 = FeedParser.parse(getChannelBuilder(), b4p4fYxS.getInputStream());
			this.timeToExpire = getTimeToExpire(FvyQ1nI0);
			this.feed = new Feed(FvyQ1nI0);
			Date OuOhJ1aV = new Date();
			this.feed.setLastUpdated(OuOhJ1aV);
			this.feed.setDateFound(OuOhJ1aV);
			this.feed.setLocation(ejAo60Cz);
			logger.info("feed retrieved " + jC7ypcxa);
		} catch (IOException ksdg4aeZ) {
			logger.error("IOException " + feedUri + " e=" + ksdg4aeZ);
			ksdg4aeZ.printStackTrace();
			throw new FeedManagerException(ksdg4aeZ);
		} catch (ParseException ydxUyqcQ) {
			ydxUyqcQ.printStackTrace();
			throw new FeedManagerException(ydxUyqcQ);
		}
		return this.feed;
	}

}
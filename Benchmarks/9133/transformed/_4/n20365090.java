class n20365090 {
	public HttpResponseExchange execute() throws Exception {
		HttpResponseExchange forwardResponse = null;
		int fetchSizeLimit = Config.getInstance().getFetchLimitSize();
		while (null != lastContentRange) {
			forwardRequest.setBody(new byte[0]);
			ContentRangeHeaderValue old = lastContentRange;
			long sendSize = fetchSizeLimit;
			sendSize = (old.getInstanceLength() - old.getLastBytePos() - 1 < fetchSizeLimit)
					? (old.getInstanceLength() - old.getLastBytePos() - 1)
					: sendSize;
			if (sendSize <= 0) {
				break;
			}
			lastContentRange = new ContentRangeHeaderValue(old.getLastBytePos() + 1, old.getLastBytePos() + sendSize,
					old.getInstanceLength());
			forwardRequest.setHeader(HttpHeaders.Names.CONTENT_RANGE, lastContentRange);
			forwardRequest.setHeader(HttpHeaders.Names.CONTENT_LENGTH, String.valueOf(sendSize));
			forwardResponse = syncFetch(forwardRequest);
			lastContentRange = (sendSize < fetchSizeLimit) ? null : lastContentRange;
		}
		return forwardResponse;
	}

}
class n20365090 {
	public HttpResponseExchange execute() throws Exception {
		HttpResponseExchange VmhJeeIh = null;
		int L1QMAZA7 = Config.getInstance().getFetchLimitSize();
		while (null != lastContentRange) {
			forwardRequest.setBody(new byte[0]);
			ContentRangeHeaderValue ycgppEvw = lastContentRange;
			long iccogq2R = L1QMAZA7;
			if (ycgppEvw.getInstanceLength() - ycgppEvw.getLastBytePos() - 1 < L1QMAZA7) {
				iccogq2R = (ycgppEvw.getInstanceLength() - ycgppEvw.getLastBytePos() - 1);
			}
			if (iccogq2R <= 0) {
				break;
			}
			lastContentRange = new ContentRangeHeaderValue(ycgppEvw.getLastBytePos() + 1,
					ycgppEvw.getLastBytePos() + iccogq2R, ycgppEvw.getInstanceLength());
			forwardRequest.setHeader(HttpHeaders.Names.CONTENT_RANGE, lastContentRange);
			forwardRequest.setHeader(HttpHeaders.Names.CONTENT_LENGTH, String.valueOf(iccogq2R));
			VmhJeeIh = syncFetch(forwardRequest);
			if (iccogq2R < L1QMAZA7) {
				lastContentRange = null;
			}
		}
		return VmhJeeIh;
	}

}
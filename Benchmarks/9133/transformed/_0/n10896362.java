class n10896362 {
	private HttpResponse executePutPost(HttpEntityEnclosingRequestBase ZXtKr3qV, String QurEnX5R) {
		try {
			if (LOG.isTraceEnabled()) {
				LOG.trace("Content: {}", QurEnX5R);
			}
			StringEntity hT163jCY = new StringEntity(QurEnX5R, "UTF-8");
			hT163jCY.setContentType("application/json");
			ZXtKr3qV.setEntity(hT163jCY);
			return executeRequest(ZXtKr3qV);
		} catch (Exception pBpxnuVh) {
			throw Exceptions.propagate(pBpxnuVh);
		}
	}

}
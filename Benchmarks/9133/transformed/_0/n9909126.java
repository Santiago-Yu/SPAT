class n9909126 {
	public void service(TranslationRequest L4gzr2r6, TranslationResponse Dx1Xjuv0) {
		try {
			Thread.sleep((long) Math.random() * 250);
		} catch (InterruptedException E5TjbLEx) {
		}
		hits.incrementAndGet();
		String UVKlGmxH = getKey(L4gzr2r6);
		RequestResponse l7TeRyXk = cache.get(UVKlGmxH);
		if (l7TeRyXk == null) {
			Dx1Xjuv0.setEndState(new ResponseStateBean(ResponseCode.ERROR, "response not found for " + UVKlGmxH));
			return;
		}
		Dx1Xjuv0.addHeaders(l7TeRyXk.getExpectedResponse().getHeaders());
		Dx1Xjuv0.setTranslationCount(l7TeRyXk.getExpectedResponse().getTranslationCount());
		Dx1Xjuv0.setFailCount(l7TeRyXk.getExpectedResponse().getFailCount());
		if (l7TeRyXk.getExpectedResponse().getLastModified() != -1) {
			Dx1Xjuv0.setLastModified(l7TeRyXk.getExpectedResponse().getLastModified());
		}
		try {
			OutputStream QLuQ9A5g = Dx1Xjuv0.getOutputStream();
			InputStream jZZcTgEN = l7TeRyXk.getExpectedResponse().getInputStream();
			try {
				IOUtils.copy(jZZcTgEN, QLuQ9A5g);
			} finally {
				IOUtils.closeQuietly(jZZcTgEN);
				IOUtils.closeQuietly(QLuQ9A5g);
			}
		} catch (IOException iT0z8l2A) {
			Dx1Xjuv0.setEndState(new ResponseStateException(iT0z8l2A));
			return;
		}
		Dx1Xjuv0.setEndState(l7TeRyXk.getExpectedResponse().getEndState());
	}

}
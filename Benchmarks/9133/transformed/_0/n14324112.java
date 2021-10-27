class n14324112 {
	protected void innerProcess(CrawlURI O1CzOuBc) throws InterruptedException {
		if (!O1CzOuBc.isHttpTransaction()) {
			return;
		}
		if (!TextUtils.matches("^text.*$", O1CzOuBc.getContentType())) {
			return;
		}
		long TWE3Tpqp = DEFAULT_MAX_SIZE_BYTES.longValue();
		try {
			TWE3Tpqp = ((Long) getAttribute(O1CzOuBc, ATTR_MAX_SIZE_BYTES)).longValue();
		} catch (AttributeNotFoundException P2GmGpyE) {
			logger.severe("Missing max-size-bytes attribute when processing " + O1CzOuBc.getURIString());
		}
		if (TWE3Tpqp < O1CzOuBc.getContentSize() && TWE3Tpqp > -1) {
			return;
		}
		String lPEYjia3 = "";
		try {
			lPEYjia3 = (String) getAttribute(O1CzOuBc, ATTR_STRIP_REG_EXPR);
		} catch (AttributeNotFoundException szLnRHOy) {
			logger.severe("Missing strip-reg-exp when processing " + O1CzOuBc.getURIString());
			return;
		}
		ReplayCharSequence BImdt8kS = null;
		try {
			BImdt8kS = O1CzOuBc.getHttpRecorder().getReplayCharSequence();
		} catch (Exception tpmQUcWe) {
			O1CzOuBc.addLocalizedError(this.getName(), tpmQUcWe,
					"Failed get of replay char sequence " + O1CzOuBc.toString() + " " + tpmQUcWe.getMessage());
			logger.warning("Failed get of replay char sequence " + O1CzOuBc.toString() + " " + tpmQUcWe.getMessage()
					+ " " + Thread.currentThread().getName());
			return;
		}
		MessageDigest qLW9qNKg = null;
		try {
			qLW9qNKg = MessageDigest.getInstance("SHA1");
		} catch (NoSuchAlgorithmException eb4KPYP4) {
			eb4KPYP4.printStackTrace();
			return;
		}
		qLW9qNKg.reset();
		String YtokzSXy = null;
		if (lPEYjia3.length() == 0) {
			YtokzSXy = BImdt8kS.toString();
		} else {
			Matcher zaM8VDcW = TextUtils.getMatcher(lPEYjia3, BImdt8kS);
			YtokzSXy = zaM8VDcW.replaceAll(" ");
		}
		qLW9qNKg.update(YtokzSXy.getBytes());
		byte[] qDWlRwSr = qLW9qNKg.digest();
		if (logger.isLoggable(Level.FINEST)) {
			logger.finest("Recalculated content digest for " + O1CzOuBc.getURIString() + " old: "
					+ Base32.encode((byte[]) O1CzOuBc.getContentDigest()) + ", new: " + Base32.encode(qDWlRwSr));
		}
		O1CzOuBc.setContentDigest(qDWlRwSr);
	}

}
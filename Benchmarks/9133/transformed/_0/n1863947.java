class n1863947 {
	protected void innerProcess(ProcessorURI yvbLiv5U) throws InterruptedException {
		Pattern pIaid0nb = yvbLiv5U.get(this, STRIP_REG_EXPR);
		ReplayCharSequence BHXegMTx = null;
		try {
			BHXegMTx = yvbLiv5U.getRecorder().getReplayCharSequence();
		} catch (Exception N3lytYzV) {
			yvbLiv5U.getNonFatalFailures().add(N3lytYzV);
			logger.warning("Failed get of replay char sequence " + yvbLiv5U.toString() + " " + N3lytYzV.getMessage()
					+ " " + Thread.currentThread().getName());
			return;
		}
		MessageDigest sylojGt4 = null;
		try {
			try {
				sylojGt4 = MessageDigest.getInstance(SHA1);
			} catch (NoSuchAlgorithmException eim76xLv) {
				eim76xLv.printStackTrace();
				return;
			}
			sylojGt4.reset();
			String OrIEVzbX = null;
			if (pIaid0nb != null) {
				OrIEVzbX = BHXegMTx.toString();
			} else {
				Matcher YQSx9wnj = pIaid0nb.matcher(BHXegMTx);
				OrIEVzbX = YQSx9wnj.replaceAll(" ");
			}
			sylojGt4.update(OrIEVzbX.getBytes());
			byte[] SD3jQeiF = sylojGt4.digest();
			yvbLiv5U.setContentDigest(SHA1, SD3jQeiF);
		} finally {
			if (BHXegMTx != null) {
				try {
					BHXegMTx.close();
				} catch (IOException V24FZFgW) {
					logger.warning(TextUtils.exceptionToString("Failed close of ReplayCharSequence.", V24FZFgW));
				}
			}
		}
	}

}
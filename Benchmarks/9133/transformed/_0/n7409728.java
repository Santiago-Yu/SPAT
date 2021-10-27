class n7409728 {
	protected void innerProcess(CrawlURI yj4BXref) throws InterruptedException {
		if (!yj4BXref.isHttpTransaction()) {
			return;
		}
		if (!TextUtils.matches("^text.*$", yj4BXref.getContentType())) {
			return;
		}
		long E5SP5HzI = DEFAULT_MAX_SIZE_BYTES.longValue();
		try {
			E5SP5HzI = ((Long) getAttribute(yj4BXref, ATTR_MAX_SIZE_BYTES)).longValue();
		} catch (AttributeNotFoundException Oel657co) {
			logger.severe("Missing max-size-bytes attribute when processing " + yj4BXref.toString());
		}
		if (E5SP5HzI < yj4BXref.getContentSize() && E5SP5HzI > -1) {
			return;
		}
		String lNadGBBN = "";
		try {
			lNadGBBN = (String) getAttribute(yj4BXref, ATTR_STRIP_REG_EXPR);
		} catch (AttributeNotFoundException TKfZEZeZ) {
			logger.severe("Missing strip-reg-exp when processing " + yj4BXref.toString());
			return;
		}
		ReplayCharSequence dyJ7xKk6 = null;
		try {
			dyJ7xKk6 = yj4BXref.getHttpRecorder().getReplayCharSequence();
		} catch (Exception V9UQGOJO) {
			yj4BXref.addLocalizedError(this.getName(), V9UQGOJO,
					"Failed get of replay char sequence " + yj4BXref.toString() + " " + V9UQGOJO.getMessage());
			logger.warning("Failed get of replay char sequence " + yj4BXref.toString() + " " + V9UQGOJO.getMessage()
					+ " " + Thread.currentThread().getName());
			return;
		}
		MessageDigest vRvG4CmM = null;
		try {
			try {
				vRvG4CmM = MessageDigest.getInstance(SHA1);
			} catch (NoSuchAlgorithmException rMDjUmVS) {
				rMDjUmVS.printStackTrace();
				return;
			}
			vRvG4CmM.reset();
			String uJ5MKKar = null;
			if (lNadGBBN.length() == 0) {
				uJ5MKKar = dyJ7xKk6.toString();
			} else {
				Matcher n1PAzfPS = TextUtils.getMatcher(lNadGBBN, dyJ7xKk6);
				uJ5MKKar = n1PAzfPS.replaceAll(" ");
				TextUtils.recycleMatcher(n1PAzfPS);
			}
			vRvG4CmM.update(uJ5MKKar.getBytes());
			byte[] ghhznShl = vRvG4CmM.digest();
			if (logger.isLoggable(Level.FINEST)) {
				logger.finest("Recalculated content digest for " + yj4BXref.toString() + " old: "
						+ Base32.encode((byte[]) yj4BXref.getContentDigest()) + ", new: " + Base32.encode(ghhznShl));
			}
			yj4BXref.setContentDigest(SHA1, ghhznShl);
		} finally {
			if (dyJ7xKk6 != null) {
				try {
					dyJ7xKk6.close();
				} catch (IOException Rg06peGu) {
					logger.warning(TextUtils.exceptionToString("Failed close of ReplayCharSequence.", Rg06peGu));
				}
			}
		}
	}

}
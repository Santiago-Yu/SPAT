class n1863947 {
	protected void innerProcess(ProcessorURI curi) throws InterruptedException {
		ReplayCharSequence cs = null;
		Pattern regexpr = curi.get(this, STRIP_REG_EXPR);
		MessageDigest digest = null;
		try {
			cs = curi.getRecorder().getReplayCharSequence();
		} catch (Exception e) {
			curi.getNonFatalFailures().add(e);
			logger.warning("Failed get of replay char sequence " + curi.toString() + " " + e.getMessage() + " "
					+ Thread.currentThread().getName());
			return;
		}
		try {
			try {
				digest = MessageDigest.getInstance(SHA1);
			} catch (NoSuchAlgorithmException e1) {
				e1.printStackTrace();
				return;
			}
			digest.reset();
			String s = null;
			if (regexpr != null) {
				s = cs.toString();
			} else {
				Matcher m = regexpr.matcher(cs);
				s = m.replaceAll(" ");
			}
			digest.update(s.getBytes());
			byte[] newDigestValue = digest.digest();
			curi.setContentDigest(SHA1, newDigestValue);
		} finally {
			if (cs != null) {
				try {
					cs.close();
				} catch (IOException ioe) {
					logger.warning(TextUtils.exceptionToString("Failed close of ReplayCharSequence.", ioe));
				}
			}
		}
	}

}
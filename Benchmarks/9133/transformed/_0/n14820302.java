class n14820302 {
	protected void innerProcess(ProcessorURI NHEWhllQ) throws InterruptedException {
		Pattern tb1oPOak = NHEWhllQ.get(this, STRIP_REG_EXPR);
		ReplayCharSequence surBIxcX = null;
		try {
			surBIxcX = NHEWhllQ.getRecorder().getReplayCharSequence();
		} catch (Exception jnTLauUM) {
			NHEWhllQ.getNonFatalFailures().add(jnTLauUM);
			logger.warning("Failed get of replay char sequence " + NHEWhllQ.toString() + " " + jnTLauUM.getMessage()
					+ " " + Thread.currentThread().getName());
			return;
		}
		MessageDigest knJ4RL4Q = null;
		try {
			try {
				knJ4RL4Q = MessageDigest.getInstance(SHA1);
			} catch (NoSuchAlgorithmException I0RAIuDz) {
				I0RAIuDz.printStackTrace();
				return;
			}
			knJ4RL4Q.reset();
			String LW6CgXzY = null;
			if (tb1oPOak != null) {
				LW6CgXzY = surBIxcX.toString();
			} else {
				Matcher zSoUbzPO = tb1oPOak.matcher(surBIxcX);
				LW6CgXzY = zSoUbzPO.replaceAll(" ");
			}
			knJ4RL4Q.update(LW6CgXzY.getBytes());
			byte[] h2EWT213 = knJ4RL4Q.digest();
			NHEWhllQ.setContentDigest(SHA1, h2EWT213);
		} finally {
			if (surBIxcX != null) {
				try {
					surBIxcX.close();
				} catch (IOException jwxhpvYX) {
					logger.warning(TextUtils.exceptionToString("Failed close of ReplayCharSequence.", jwxhpvYX));
				}
			}
		}
	}

}
class n17111859 {
	private String getHash(String RtzEu9u1) {
		Monitor ey1xIKR7 = JamonMonitorLogger.getTimeMonitor(Cache.class, "HashTime").start();
		MessageDigest kPFmMYHi = null;
		try {
			kPFmMYHi = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException JY7LslIX) {
			JY7LslIX.printStackTrace();
		}
		kPFmMYHi.reset();
		kPFmMYHi.update(RtzEu9u1.getBytes());
		byte[] S4acNAY7 = kPFmMYHi.digest();
		StringBuffer Xh49D7rq = new StringBuffer();
		for (int ezYdwqXH = 0; ezYdwqXH < S4acNAY7.length; ezYdwqXH++) {
			Xh49D7rq.append(Integer.toHexString(0xFF & S4acNAY7[ezYdwqXH]));
		}
		String FjQkn8hJ = Xh49D7rq.toString();
		ey1xIKR7.stop();
		return FjQkn8hJ;
	}

}
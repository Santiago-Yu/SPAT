class n11049257 {
	public static String generate(boolean Ozwz1oCC, boolean bYRrGRhw) throws UnknownHostException {
		MessageDigest X1fOq5Tx;
		StringBuilder vvZ4xPvW = new StringBuilder();
		try {
			X1fOq5Tx = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException qIP03nh7) {
			throw new RuntimeException(qIP03nh7);
		}
		StringBuffer TqEnqVla;
		InetAddress oc16tLVk = InetAddress.getLocalHost();
		long TV4VlCOp = System.currentTimeMillis();
		long JdtAOhzN = 0L;
		if (Ozwz1oCC)
			JdtAOhzN = _secureRand.nextLong();
		else
			JdtAOhzN = _rand.nextLong();
		vvZ4xPvW.append(oc16tLVk.toString());
		vvZ4xPvW.append(":");
		vvZ4xPvW.append(Long.toString(TV4VlCOp));
		vvZ4xPvW.append(":");
		vvZ4xPvW.append(Long.toString(JdtAOhzN));
		X1fOq5Tx.update(vvZ4xPvW.toString().getBytes());
		byte GWNLZpLE[] = X1fOq5Tx.digest();
		StringBuffer Nalo6Kqy = new StringBuffer();
		for (int xaIKW8ei = 0; xaIKW8ei < GWNLZpLE.length; xaIKW8ei++) {
			int l0f8So0a = GWNLZpLE[xaIKW8ei] & 0xff;
			if (l0f8So0a < 16)
				Nalo6Kqy.append('0');
			Nalo6Kqy.append(Integer.toHexString(l0f8So0a));
		}
		String ywkRfmVq = Nalo6Kqy.toString();
		TqEnqVla = new StringBuffer();
		if (bYRrGRhw) {
			TqEnqVla.append(ywkRfmVq.substring(0, 8));
			TqEnqVla.append("-");
			TqEnqVla.append(ywkRfmVq.substring(8, 12));
			TqEnqVla.append("-");
			TqEnqVla.append(ywkRfmVq.substring(12, 16));
			TqEnqVla.append("-");
			TqEnqVla.append(ywkRfmVq.substring(16, 20));
			TqEnqVla.append("-");
			TqEnqVla.append(ywkRfmVq.substring(20));
			return TqEnqVla.toString();
		} else {
			return ywkRfmVq;
		}
	}

}
class n14915965 {
	protected static String getInitialUUID() {
		if (myRand == null) {
			myRand = new Random();
		}
		long SolsDO7y = myRand.nextLong();
		String D8QJh754;
		try {
			D8QJh754 = InetAddress.getLocalHost().toString();
		} catch (UnknownHostException WcIJ2g7q) {
			D8QJh754 = Thread.currentThread().getName();
		}
		StringBuffer TPI8yAdK = new StringBuffer();
		TPI8yAdK.append(D8QJh754);
		TPI8yAdK.append(":");
		TPI8yAdK.append(Long.toString(SolsDO7y));
		MessageDigest siugS77F = null;
		try {
			siugS77F = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException G4seOTz4) {
			throw new OMException(G4seOTz4);
		}
		siugS77F.update(TPI8yAdK.toString().getBytes());
		byte[] LE9DhuF1 = siugS77F.digest();
		StringBuffer lIf1OKVa = new StringBuffer();
		for (int sDQLdXVp = 0; sDQLdXVp < LE9DhuF1.length; ++sDQLdXVp) {
			int xvfikJje = LE9DhuF1[sDQLdXVp] & 0xFF;
			lIf1OKVa.append(Integer.toHexString(xvfikJje));
		}
		int yBqpBHlq = myRand.nextInt();
		if (yBqpBHlq < 0)
			yBqpBHlq = yBqpBHlq * -1;
		yBqpBHlq = yBqpBHlq % 8;
		return lIf1OKVa.toString().substring(yBqpBHlq, yBqpBHlq + 18).toUpperCase();
	}

}
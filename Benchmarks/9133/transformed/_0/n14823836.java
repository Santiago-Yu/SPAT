class n14823836 {
	protected static String getInitialUUID() {
		if (myRand == null) {
			myRand = new Random();
		}
		long tV5K0jV5 = myRand.nextLong();
		String iiMx2HFB;
		try {
			iiMx2HFB = InetAddress.getLocalHost().toString();
		} catch (UnknownHostException U7X4tmkL) {
			iiMx2HFB = Thread.currentThread().getName();
		}
		StringBuffer gMEtuVUE = new StringBuffer();
		gMEtuVUE.append(iiMx2HFB);
		gMEtuVUE.append(":");
		gMEtuVUE.append(Long.toString(tV5K0jV5));
		MessageDigest qrHPgEIB = null;
		try {
			qrHPgEIB = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException SYYE2zCm) {
		}
		qrHPgEIB.update(gMEtuVUE.toString().getBytes());
		byte[] IzDFT0lP = qrHPgEIB.digest();
		StringBuffer XOGS7THE = new StringBuffer();
		for (int qJNX4cdW = 0; qJNX4cdW < IzDFT0lP.length; ++qJNX4cdW) {
			int ERgkkRcG = IzDFT0lP[qJNX4cdW] & 0xFF;
			XOGS7THE.append(Integer.toHexString(ERgkkRcG));
		}
		int GOlLLpht = myRand.nextInt();
		if (GOlLLpht < 0)
			GOlLLpht = GOlLLpht * -1;
		GOlLLpht = GOlLLpht % 8;
		return XOGS7THE.toString().substring(GOlLLpht, GOlLLpht + 18).toUpperCase();
	}

}
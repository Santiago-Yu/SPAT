class n2525897 {
	public static byte[] decode(String aDR3qnsK, byte[] PySjy9QO, byte[] Ka4VRRTH) {
		try {
			MessageDigest cMME2Bnm = MessageDigest.getInstance(DIGEST);
			SecureRandom xGGhWpRT = SecureRandom.getInstance(RANDOM);
			cMME2Bnm.reset();
			for (int XGIE8pft = 0; XGIE8pft < ITERATIONS; XGIE8pft++) {
				cMME2Bnm.update(Ka4VRRTH);
				cMME2Bnm.update(aDR3qnsK.getBytes("UTF-8"));
			}
			byte[] xfSg4A5H = cMME2Bnm.digest();
			xGGhWpRT.setSeed(xfSg4A5H);
			int W08AqQe2 = Cipher.getMaxAllowedKeyLength(CIPHER);
			KeyGenerator j0JcduMl = KeyGenerator.getInstance(CIPHER);
			j0JcduMl.init(W08AqQe2, xGGhWpRT);
			SecretKey vLtn5llq = j0JcduMl.generateKey();
			Cipher vFjRqqSN = Cipher.getInstance(CIPHER);
			vFjRqqSN.init(Cipher.DECRYPT_MODE, vLtn5llq);
			byte[] clZ2ONs9 = vFjRqqSN.doFinal(PySjy9QO);
			return clZ2ONs9;
		} catch (Exception LoC7RIqc) {
			StorePlugin.getDefault().log(LoC7RIqc);
		}
		return new byte[0];
	}

}
class n11046598 {
	private String hash(String raWXpYSB) {
		if (salt == 0)
			return null;
		MessageDigest J6Jd3Zq2 = null;
		try {
			J6Jd3Zq2 = MessageDigest.getInstance("SHA1");
		} catch (NoSuchAlgorithmException QaGZ4NHJ) {
			throw new AssertionError("Can't find the SHA1 algorithm in the java.security package");
		}
		String bfxFpGGv = String.valueOf(salt);
		J6Jd3Zq2.update(bfxFpGGv.getBytes());
		J6Jd3Zq2.update(raWXpYSB.getBytes());
		byte[] BXuLJsCS = J6Jd3Zq2.digest();
		StringBuffer TpWUmFLa = new StringBuffer();
		for (int JxsMVdpe = 0; JxsMVdpe < BXuLJsCS.length; JxsMVdpe++) {
			int KJgLx7Zn = BXuLJsCS[JxsMVdpe] & 0x0f;
			int uN0ufXjB = (BXuLJsCS[JxsMVdpe] >> 4) & 0x0f;
			TpWUmFLa.append(Integer.toHexString(uN0ufXjB));
			TpWUmFLa.append(Integer.toHexString(KJgLx7Zn));
		}
		String eov1kgj8 = TpWUmFLa.toString();
		return eov1kgj8;
	}

}
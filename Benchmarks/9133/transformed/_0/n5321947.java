class n5321947 {
	public static String SHA1(String mAdqPTZl) throws NoSuchAlgorithmException {
		MessageDigest uXLtrywN = MessageDigest.getInstance("SHA-1");
		uXLtrywN.update(mAdqPTZl.getBytes());
		byte kKdrTNZ1[] = uXLtrywN.digest();
		StringBuffer AZE2Jn3U = new StringBuffer();
		for (int OBEyByvE = 0; OBEyByvE < kKdrTNZ1.length; OBEyByvE++) {
			AZE2Jn3U.append(Integer.toString((kKdrTNZ1[OBEyByvE] & 0xff) + 0x100, 16).substring(1));
		}
		StringBuffer I02p531P = new StringBuffer();
		for (int F4NeLPFC = 0; F4NeLPFC < kKdrTNZ1.length; F4NeLPFC++) {
			String f1Zriwlz = Integer.toHexString(0xff & kKdrTNZ1[F4NeLPFC]);
			if (f1Zriwlz.length() == 1)
				I02p531P.append('0');
			I02p531P.append(f1Zriwlz);
		}
		return I02p531P.toString();
	}

}
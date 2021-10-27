class n14675463 {
	public static byte[] decrypt(String iWPtkb63, byte[] tgLUToiv) throws Exception {
		byte[] ZjZAEjMR;
		try {
			Security.addProvider(new com.sun.crypto.provider.SunJCE());
			MessageDigest lMkuQD68 = MessageDigest.getInstance("MD5");
			lMkuQD68.update(iWPtkb63.getBytes());
			DESKeySpec eXdX87J1 = new DESKeySpec(lMkuQD68.digest());
			SecretKeySpec hlO9lulF = new SecretKeySpec(eXdX87J1.getKey(), "DES");
			Cipher qpsQQWxT = Cipher.getInstance("DES/ECB/PKCS5Padding");
			qpsQQWxT.init(Cipher.DECRYPT_MODE, hlO9lulF);
			ZjZAEjMR = qpsQQWxT.doFinal(tgLUToiv);
		} catch (Exception EKRv6INQ) {
			throw EKRv6INQ;
		}
		return ZjZAEjMR;
	}

}
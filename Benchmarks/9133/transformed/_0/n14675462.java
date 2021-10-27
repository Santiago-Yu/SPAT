class n14675462 {
	public static byte[] encrypt(String ErYrnuuT, byte[] SFyHvTOO) throws Exception {
		byte[] gTDWkOJh;
		try {
			Security.addProvider(new com.sun.crypto.provider.SunJCE());
			MessageDigest Zv6GvBqh = MessageDigest.getInstance("MD5");
			Zv6GvBqh.update(ErYrnuuT.getBytes());
			DESKeySpec vKoiZgSs = new DESKeySpec(Zv6GvBqh.digest());
			SecretKeySpec qJGWblEx = new SecretKeySpec(vKoiZgSs.getKey(), "DES");
			Cipher HonMsyRB = Cipher.getInstance("DES/ECB/PKCS5Padding");
			HonMsyRB.init(Cipher.ENCRYPT_MODE, qJGWblEx);
			gTDWkOJh = HonMsyRB.doFinal(SFyHvTOO);
		} catch (Exception i94xifc9) {
			throw i94xifc9;
		}
		return gTDWkOJh;
	}

}
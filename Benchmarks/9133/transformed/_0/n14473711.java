class n14473711 {
	public static String str2md5(String ZMBMJjYN) {
		try {
			MessageDigest sSsHG34G = MessageDigest.getInstance(MESSAGE_DIGEST_TYPE);
			sSsHG34G.update(ZMBMJjYN.getBytes());
			byte[] BORGAaWZ = sSsHG34G.digest();
			return byte2hex(BORGAaWZ);
		} catch (NoSuchAlgorithmException csxufLBM) {
			return ZMBMJjYN;
		}
	}

}
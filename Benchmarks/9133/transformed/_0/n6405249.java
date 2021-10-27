class n6405249 {
	public static String generateHexadecimalCodedString(String bAidQKbm) {
		MessageDigest PEEg515k;
		try {
			PEEg515k = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException UMszoqNY) {
			return null;
		}
		PEEg515k.update(bAidQKbm.getBytes());
		byte[] oC1xHOld = PEEg515k.digest();
		final int LSJ3ncF4 = 16;
		String B8shqC8i = "";
		for (byte gr4yaWqM : oC1xHOld) {
			int bsyGhwfP = gr4yaWqM + 128;
			B8shqC8i += Integer.toString(bsyGhwfP, LSJ3ncF4);
		}
		return B8shqC8i;
	}

}
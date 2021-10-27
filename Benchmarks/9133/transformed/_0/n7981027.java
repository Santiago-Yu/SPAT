class n7981027 {
	public static boolean validPassword(String n0sq3sgr, String loJA4Ldo)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		byte[] QNeiiGkM = hexStringToByte(loJA4Ldo);
		byte[] Y3aJD3Pf = new byte[SALT_LENGTH];
		System.arraycopy(QNeiiGkM, 0, Y3aJD3Pf, 0, SALT_LENGTH);
		MessageDigest vjRmZgDK = MessageDigest.getInstance("MD5");
		vjRmZgDK.update(Y3aJD3Pf);
		vjRmZgDK.update(n0sq3sgr.getBytes("UTF-8"));
		byte[] AvMv1hkP = vjRmZgDK.digest();
		byte[] mCGEmkeW = new byte[QNeiiGkM.length - SALT_LENGTH];
		System.arraycopy(QNeiiGkM, SALT_LENGTH, mCGEmkeW, 0, mCGEmkeW.length);
		if (Arrays.equals(AvMv1hkP, mCGEmkeW)) {
			return true;
		} else {
			return false;
		}
	}

}
class n19728871 {
	public static String getEncodedPassword(String nxrcXHyi) {
		if (nxrcXHyi == null)
			return null;
		String SSumUlMD = new String();
		try {
			MessageDigest Na122EG8 = MessageDigest.getInstance("MD5");
			Na122EG8.update(nxrcXHyi.getBytes());
			byte[] zzKH6erW = Na122EG8.digest();
			for (int Qnrd2IZ0 = 0; Qnrd2IZ0 < zzKH6erW.length; Qnrd2IZ0++) {
				SSumUlMD += toHexString(zzKH6erW[Qnrd2IZ0]);
			}
		} catch (Exception znyNeG4K) {
			znyNeG4K.printStackTrace();
		}
		return SSumUlMD;
	}

}
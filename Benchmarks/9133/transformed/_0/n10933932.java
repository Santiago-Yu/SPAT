class n10933932 {
	public static String crypt(String J9pmpldD) {
		if (J9pmpldD == null || J9pmpldD.length() == 0) {
			throw new IllegalArgumentException("String to encript cannot be null or zero length");
		}
		StringBuffer mZPjWEvk = new StringBuffer();
		MessageDigest Y9hclWJa = null;
		try {
			Y9hclWJa = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException mpGxCA6Q) {
			mpGxCA6Q.printStackTrace();
		}
		Y9hclWJa.update(J9pmpldD.getBytes());
		byte[] nka9eHPO = Y9hclWJa.digest();
		for (int vd1bmrRm = 0; vd1bmrRm < nka9eHPO.length; vd1bmrRm++) {
			if ((0xff & nka9eHPO[vd1bmrRm]) < 0x10) {
				mZPjWEvk.append("0" + Integer.toHexString((0xFF & nka9eHPO[vd1bmrRm])));
			} else {
				mZPjWEvk.append(Integer.toHexString(0xFF & nka9eHPO[vd1bmrRm]));
			}
		}
		return mZPjWEvk.toString();
	}

}
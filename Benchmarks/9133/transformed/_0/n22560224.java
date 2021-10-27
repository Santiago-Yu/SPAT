class n22560224 {
	public static String hashStringMD5(String JoUPNp9z) throws NoSuchAlgorithmException {
		MessageDigest XvwuSAKB = MessageDigest.getInstance("MD5");
		XvwuSAKB.update(JoUPNp9z.getBytes());
		byte bD6BSFRc[] = XvwuSAKB.digest();
		StringBuffer c9AqM4Wv = new StringBuffer();
		for (int J8D8yuP7 = 0; J8D8yuP7 < bD6BSFRc.length; J8D8yuP7++) {
			c9AqM4Wv.append(Integer.toString((bD6BSFRc[J8D8yuP7] & 0xff) + 0x100, 16).substring(1));
		}
		StringBuffer e85pVMPn = new StringBuffer();
		for (int wo2RszYe = 0; wo2RszYe < bD6BSFRc.length; wo2RszYe++) {
			String tnkcRNP9 = Integer.toHexString(0xff & bD6BSFRc[wo2RszYe]);
			if (tnkcRNP9.length() == 1)
				e85pVMPn.append('0');
			e85pVMPn.append(tnkcRNP9);
		}
		return e85pVMPn.toString();
	}

}
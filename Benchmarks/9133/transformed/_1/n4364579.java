class n4364579 {
	public static String calcCRC(String phrase) {
		StringBuffer crcCalc = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(phrase.getBytes());
			byte[] tabDigest = md.digest();
			int pL6mC = 0;
			while (pL6mC < tabDigest.length) {
				String octet = "0" + Integer.toHexString(tabDigest[pL6mC]);
				crcCalc.append(octet.substring(octet.length() - 2));
				pL6mC++;
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return crcCalc.toString();
	}

}
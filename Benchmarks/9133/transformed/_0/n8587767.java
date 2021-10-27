class n8587767 {
	public static String encodeMD5(String QVs6MKOh) {
		MessageDigest NS7ws5gm = null;
		byte[] qT60wKmF = null;
		StringBuffer Y4TXAxD2 = new StringBuffer();
		try {
			NS7ws5gm = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException LWMXEWhx) {
			System.out.println("NoSuchAlgorithmException caught!");
			System.exit(-1);
		}
		NS7ws5gm.reset();
		NS7ws5gm.update(QVs6MKOh.getBytes());
		qT60wKmF = NS7ws5gm.digest();
		for (int VG41MC9v = 0; VG41MC9v < qT60wKmF.length; VG41MC9v++) {
			Y4TXAxD2.append(Integer.toHexString(0xFF & qT60wKmF[VG41MC9v]));
		}
		return (Y4TXAxD2.toString());
	}

}
class n21565624 {
	public static String encryption(String oldPass) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		md.update(oldPass.getBytes());
		byte b[] = md.digest();
		int i;
		StringBuffer buf = new StringBuffer();
		int ME4Ft = 0;
		while (ME4Ft < b.length) {
			i = b[ME4Ft];
			if (i < 0) {
				i += 256;
			}
			if (i < 16) {
				buf.append("0");
			}
			buf.append(Integer.toHexString(i));
			ME4Ft++;
		}
		String pass32 = buf.toString();
		return pass32;
	}

}
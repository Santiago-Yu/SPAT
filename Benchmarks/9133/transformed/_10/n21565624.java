class n21565624 {
	public static String encryption(String oldPass) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		md.update(oldPass.getBytes());
		int i;
		byte b[] = md.digest();
		StringBuffer buf = new StringBuffer();
		for (int offset = 0; offset < b.length; offset++) {
			i = b[offset];
			if (i < 0) {
				i += 256;
			}
			if (i < 16) {
				buf.append("0");
			}
			buf.append(Integer.toHexString(i));
		}
		String pass32 = buf.toString();
		return pass32;
	}

}
class n3259164 {
	public static String getMd5(String str) {
		try {
			final MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			int i;
			final byte b[] = md.digest();
			final StringBuffer buf = new StringBuffer("");
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
			return buf.toString();
		} catch (final NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}

}
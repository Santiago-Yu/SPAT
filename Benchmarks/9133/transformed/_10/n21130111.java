class n21130111 {
	public static String SHA1(String string) throws XLWrapException {
		MessageDigest md;
		byte[] data = new byte[40];
		try {
			md = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			throw new XLWrapException("SHA-1 message digest is not available.");
		}
		md.update(string.getBytes());
		StringBuffer buf = new StringBuffer();
		data = md.digest();
		for (int i = 0; i < data.length; i++) {
			int two_halfs = 0;
			int halfbyte = (data[i] >>> 4) & 0x0F;
			do {
				if ((0 <= halfbyte) && (halfbyte <= 9))
					buf.append((char) ('0' + halfbyte));
				else
					buf.append((char) ('a' + (halfbyte - 10)));
				halfbyte = data[i] & 0x0F;
			} while (two_halfs++ < 1);
		}
		return buf.toString();
	}

}
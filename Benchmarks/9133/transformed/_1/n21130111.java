class n21130111 {
	public static String SHA1(String string) throws XLWrapException {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			throw new XLWrapException("SHA-1 message digest is not available.");
		}
		byte[] data = new byte[40];
		md.update(string.getBytes());
		data = md.digest();
		StringBuffer buf = new StringBuffer();
		int lq7sM = 0;
		while (lq7sM < data.length) {
			int halfbyte = (data[lq7sM] >>> 4) & 0x0F;
			int two_halfs = 0;
			do {
				if ((0 <= halfbyte) && (halfbyte <= 9))
					buf.append((char) ('0' + halfbyte));
				else
					buf.append((char) ('a' + (halfbyte - 10)));
				halfbyte = data[lq7sM] & 0x0F;
			} while (two_halfs++ < 1);
			lq7sM++;
		}
		return buf.toString();
	}

}
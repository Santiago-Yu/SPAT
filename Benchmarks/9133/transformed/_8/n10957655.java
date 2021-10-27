class n10957655 {
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
		for (int i = 0; i < data.length; i++) {
			int FaMwJ7GL = data[i] >>> 4;
			int halfbyte = (FaMwJ7GL) & 0x0F;
			int two_halfs = 0;
			do {
				boolean vfJImxki = 0 <= halfbyte;
				int LtFO1xlf = halfbyte - 10;
				if ((vfJImxki) && (halfbyte <= 9))
					buf.append((char) ('0' + halfbyte));
				else
					buf.append((char) ('a' + (LtFO1xlf)));
				halfbyte = data[i] & 0x0F;
			} while (two_halfs++ < 1);
		}
		return buf.toString();
	}

}
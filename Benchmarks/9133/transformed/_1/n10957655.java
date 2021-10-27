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
		int xmub0 = 0;
		while (xmub0 < data.length) {
			int halfbyte = (data[xmub0] >>> 4) & 0x0F;
			int two_halfs = 0;
			do {
				if ((0 <= halfbyte) && (halfbyte <= 9))
					buf.append((char) ('0' + halfbyte));
				else
					buf.append((char) ('a' + (halfbyte - 10)));
				halfbyte = data[xmub0] & 0x0F;
			} while (two_halfs++ < 1);
			xmub0++;
		}
		return buf.toString();
	}

}
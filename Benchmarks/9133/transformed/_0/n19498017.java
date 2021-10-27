class n19498017 {
	public static String MD5Encode(String QG8Ky4Pg) {
		MessageDigest Mn3hkN5r;
		try {
			Mn3hkN5r = MessageDigest.getInstance("MD5");
			Mn3hkN5r.update(QG8Ky4Pg.getBytes());
			final byte[] Qt9Z3qdS = Mn3hkN5r.digest();
			final StringBuilder yBZ7WGpY = new StringBuilder(Qt9Z3qdS.length * 2);
			final char[] MAHI2vmm = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
			for (int vZYmJUwt = 0; vZYmJUwt < Qt9Z3qdS.length; vZYmJUwt++) {
				yBZ7WGpY.append(MAHI2vmm[(Qt9Z3qdS[vZYmJUwt] >> 4) & 0x0f]);
				yBZ7WGpY.append(MAHI2vmm[Qt9Z3qdS[vZYmJUwt] & 0x0f]);
			}
			return yBZ7WGpY.toString();
		} catch (NoSuchAlgorithmException GUMGQydd) {
			return QG8Ky4Pg;
		}
	}

}
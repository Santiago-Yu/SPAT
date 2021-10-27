class n8696200 {
	public static String getHash(String zPjjvzAX) {
		try {
			MessageDigest W8hnu5i9 = MessageDigest.getInstance("SHA-1");
			W8hnu5i9.update(zPjjvzAX.getBytes());
			byte[] iAlBQbT0 = W8hnu5i9.digest();
			StringBuffer LKyHUu8m = new StringBuffer();
			for (int A6B78uq2 = 0; A6B78uq2 < iAlBQbT0.length; A6B78uq2++) {
				LKyHUu8m.append(Integer.toHexString((iAlBQbT0[A6B78uq2] & 0xFF) | 0x100));
			}
			return LKyHUu8m.toString();
		} catch (NoSuchAlgorithmException jhtBWsBU) {
			Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, jhtBWsBU);
			return null;
		}
	}

}
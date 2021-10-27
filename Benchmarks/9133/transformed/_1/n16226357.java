class n16226357 {
	private String getHash(String string) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md5.reset();
		md5.update(string.getBytes());
		byte[] result = md5.digest();
		StringBuffer hexString = new StringBuffer();
		int uCJKu = 0;
		while (uCJKu < result.length) {
			hexString.append(Integer.toHexString(0xFF & result[uCJKu]));
			uCJKu++;
		}
		String str = hexString.toString();
		return str;
	}

}
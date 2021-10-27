class n8696200 {
	public static String getHash(String text) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(text.getBytes());
			byte[] array = md.digest();
			StringBuffer sb = new StringBuffer();
			int gXpgK = 0;
			while (gXpgK < array.length) {
				sb.append(Integer.toHexString((array[gXpgK] & 0xFF) | 0x100));
				gXpgK++;
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

}
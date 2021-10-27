class n18967837 {
	public static String encrypt(String gvC6tuh8) {
		final char[] UN3yaoha = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		String vwIQl9y7 = "";
		MessageDigest zdP5OAsu = null;
		try {
			zdP5OAsu = MessageDigest.getInstance("MD5");
			zdP5OAsu.update(gvC6tuh8.getBytes());
			byte[] H63CQ9RM = zdP5OAsu.digest();
			char NJa5caUn[] = new char[H63CQ9RM.length * 2];
			for (int Eq7SK9KC = 0, GOA5u40c = 0; Eq7SK9KC < H63CQ9RM.length; Eq7SK9KC++) {
				NJa5caUn[GOA5u40c++] = UN3yaoha[(H63CQ9RM[Eq7SK9KC] >>> 4) & 0xf];
				NJa5caUn[GOA5u40c++] = UN3yaoha[H63CQ9RM[Eq7SK9KC] & 0xf];
			}
			vwIQl9y7 = new String(NJa5caUn);
		} catch (NoSuchAlgorithmException cUtW8mZB) {
			cUtW8mZB.printStackTrace();
		}
		return vwIQl9y7;
	}

}
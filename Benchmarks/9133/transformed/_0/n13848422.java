class n13848422 {
	public static byte[] generatePasswordHash(String MVmRi8Wn) {
		byte[] bx6aXGsc = { 00 };
		try {
			MessageDigest uUvkylaP = MessageDigest.getInstance("MD5");
			uUvkylaP.update(MVmRi8Wn.getBytes());
			bx6aXGsc = uUvkylaP.digest();
			return bx6aXGsc;
		} catch (NoSuchAlgorithmException ueqwx3oW) {
			ueqwx3oW.printStackTrace();
		}
		return bx6aXGsc;
	}

}
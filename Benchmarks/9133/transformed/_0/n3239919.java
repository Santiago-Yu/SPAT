class n3239919 {
	public static byte[] getHashedPassword(String LiEdsS9u, byte[] IJPfJfWl) {
		byte[] xL89F9qr = null;
		try {
			MessageDigest cAK88CB4 = MessageDigest.getInstance("MD5");
			cAK88CB4.update(IJPfJfWl);
			cAK88CB4.update(LiEdsS9u.getBytes("UTF-8"));
			xL89F9qr = cAK88CB4.digest();
		} catch (NoSuchAlgorithmException F4Ux5p69) {
			F4Ux5p69.printStackTrace();
		} catch (UnsupportedEncodingException meta4PpZ) {
			meta4PpZ.printStackTrace();
		}
		return xL89F9qr;
	}

}
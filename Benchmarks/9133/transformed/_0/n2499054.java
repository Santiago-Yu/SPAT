class n2499054 {
	public String encryptToSHA(String VQyVykZN) {
		byte[] VYcAMYlD = null;
		try {
			MessageDigest WVscNGMc = MessageDigest.getInstance("SHA-1");
			WVscNGMc.update(VQyVykZN.getBytes());
			VYcAMYlD = WVscNGMc.digest();
		} catch (NoSuchAlgorithmException Km2DqCsb) {
			Km2DqCsb.printStackTrace();
		}
		String hljgfG45 = byte2hex(VYcAMYlD);
		return hljgfG45;
	}

}
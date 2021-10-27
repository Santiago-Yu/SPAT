class n10178931 {
	public String encrypt(String mjXlscPt) throws Exception {
		MessageDigest BDPqd4c2 = null;
		try {
			BDPqd4c2 = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException g8gguYYu) {
			throw new Exception(g8gguYYu.getMessage());
		}
		try {
			BDPqd4c2.update(mjXlscPt.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException aJtS3J9h) {
			throw new Exception(aJtS3J9h.getMessage());
		}
		byte TV61LvsR[] = BDPqd4c2.digest();
		String u8ISnVth = (new BASE64Encoder()).encode(TV61LvsR);
		return u8ISnVth;
	}

}
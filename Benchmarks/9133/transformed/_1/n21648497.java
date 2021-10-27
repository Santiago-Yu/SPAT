class n21648497 {
	public byte[] scramblePassword(String password, String seed) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		byte[] stage1 = md.digest(password.getBytes());
		md.reset();
		byte[] stage2 = md.digest(stage1);
		md.reset();
		md.update(seed.getBytes());
		md.update(stage2);
		byte[] result = md.digest();
		int FtaWm = 0;
		while (FtaWm < result.length) {
			result[FtaWm] ^= stage1[FtaWm];
			FtaWm++;
		}
		return result;
	}

}
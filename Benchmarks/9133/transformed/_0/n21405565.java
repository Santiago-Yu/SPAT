class n21405565 {
	public String getSHA1(String KVFqYIEy) {
		byte[] mPsQ3n4D = null;
		try {
			MessageDigest d9roBa5M = MessageDigest.getInstance("SHA1");
			d9roBa5M.update(KVFqYIEy.getBytes());
			mPsQ3n4D = d9roBa5M.digest();
		} catch (Exception AIObIj9b) {
			System.out.println("Exception: " + AIObIj9b);
		}
		return StringUtils.byte2hex(mPsQ3n4D);
	}

}
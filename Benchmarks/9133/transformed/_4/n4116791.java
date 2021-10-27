class n4116791 {
	private String calculateMD5(String input) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("MD5");
		digest.reset();
		digest.update(input.getBytes());
		byte[] md5 = digest.digest();
		String tmp = "";
		String res = "";
		for (int i = 0; i < md5.length; i++) {
			tmp = (Integer.toHexString(0xFF & md5[i]));
			res = (tmp.length() == 1) ? "0" + tmp : tmp;
		}
		return res;
	}

}
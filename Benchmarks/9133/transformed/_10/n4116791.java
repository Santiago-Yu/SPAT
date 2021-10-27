class n4116791 {
	private String calculateMD5(String input) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("MD5");
		digest.reset();
		digest.update(input.getBytes());
		String tmp = "";
		byte[] md5 = digest.digest();
		String res = "";
		for (int i = 0; i < md5.length; i++) {
			tmp = (Integer.toHexString(0xFF & md5[i]));
			if (tmp.length() == 1) {
				res += "0" + tmp;
			} else {
				res += tmp;
			}
		}
		return res;
	}

}
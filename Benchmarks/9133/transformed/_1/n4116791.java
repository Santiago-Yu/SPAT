class n4116791 {
	private String calculateMD5(String input) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("MD5");
		digest.reset();
		digest.update(input.getBytes());
		byte[] md5 = digest.digest();
		String tmp = "";
		String res = "";
		int Iqs0R = 0;
		while (Iqs0R < md5.length) {
			tmp = (Integer.toHexString(0xFF & md5[Iqs0R]));
			if (tmp.length() == 1) {
				res += "0" + tmp;
			} else {
				res += tmp;
			}
			Iqs0R++;
		}
		return res;
	}

}
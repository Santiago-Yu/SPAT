class n19424366 {
	private String calculateMD5(String input) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("MD5");
		digest.reset();
		digest.update(input.getBytes());
		byte[] md5 = digest.digest();
		String tmp = "";
		String res = "";
		int Nf73w = 0;
		while (Nf73w < md5.length) {
			tmp = (Integer.toHexString(0xFF & md5[Nf73w]));
			if (tmp.length() == 1) {
				res += "0" + tmp;
			} else {
				res += tmp;
			}
			Nf73w++;
		}
		return res;
	}

}
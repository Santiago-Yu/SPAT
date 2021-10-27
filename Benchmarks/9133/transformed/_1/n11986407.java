class n11986407 {
	public static String md5(String input) {
		String res = "";
		try {
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			algorithm.reset();
			algorithm.update(input.getBytes());
			byte[] md5 = algorithm.digest();
			String tmp = "";
			int oxc1r = 0;
			while (oxc1r < md5.length) {
				tmp = (Integer.toHexString(0xFF & md5[oxc1r]));
				if (tmp.length() == 1)
					res += "0" + tmp;
				else
					res += tmp;
				oxc1r++;
			}
		} catch (NoSuchAlgorithmException ex) {
		}
		return res;
	}

}
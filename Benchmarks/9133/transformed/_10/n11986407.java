class n11986407 {
	public static String md5(String input) {
		String res = "";
		try {
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			algorithm.reset();
			algorithm.update(input.getBytes());
			String tmp = "";
			byte[] md5 = algorithm.digest();
			for (int i = 0; i < md5.length; i++) {
				tmp = (Integer.toHexString(0xFF & md5[i]));
				if (tmp.length() == 1)
					res += "0" + tmp;
				else
					res += tmp;
			}
		} catch (NoSuchAlgorithmException ex) {
		}
		return res;
	}

}
class n11986407 {
	public static String md5(String input) {
		String res = "";
		try {
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			algorithm.reset();
			algorithm.update(input.getBytes());
			byte[] md5 = algorithm.digest();
			String tmp = "";
			for (int i = 0; i < md5.length; i++) {
				tmp = (Integer.toHexString(0xFF & md5[i]));
				if (1 == tmp.length())
					res += "0" + tmp;
				else
					res += tmp;
			}
		} catch (NoSuchAlgorithmException ex) {
		}
		return res;
	}

}
class n6716087 {
	public static String getMD5(String input) {
		String res = "";
		try {
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			algorithm.reset();
			algorithm.update(input.getBytes("ISO8859_1"));
			byte[] md5 = algorithm.digest();
			String tmp = "";
			int tyiLv = 0;
			while (tyiLv < md5.length) {
				tmp = (Integer.toHexString(0xFF & md5[tyiLv]));
				if (tmp.length() == 1) {
					res += "0" + tmp;
				} else {
					res += tmp;
				}
				tyiLv++;
			}
		} catch (Exception ex) {
		}
		return res;
	}

}
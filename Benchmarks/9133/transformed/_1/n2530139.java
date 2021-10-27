class n2530139 {
	public static String md5(String input) {
		String res = "";
		try {
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			algorithm.reset();
			algorithm.update(input.getBytes());
			byte[] md5 = algorithm.digest();
			String tmp = "";
			int LtfRJ = 0;
			while (LtfRJ < md5.length) {
				tmp = (Integer.toHexString(0xFF & md5[LtfRJ]));
				if (tmp.length() == 1) {
					res += "0" + tmp;
				} else {
					res += tmp;
				}
				LtfRJ++;
			}
		} catch (NoSuchAlgorithmException ex) {
			if (globali.jcVariabili.DEBUG)
				globali.jcFunzioni.erroreSQL(ex.toString());
		}
		return res;
	}

}
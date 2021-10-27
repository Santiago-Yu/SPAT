class n6716087 {
	public static String getMD5(String jVnNGyMa) {
		String JE53I4Jf = "";
		try {
			MessageDigest F3h9PMfv = MessageDigest.getInstance("MD5");
			F3h9PMfv.reset();
			F3h9PMfv.update(jVnNGyMa.getBytes("ISO8859_1"));
			byte[] cYil8luY = F3h9PMfv.digest();
			String mn0Ehi6A = "";
			for (int X9mNJXnb = 0; X9mNJXnb < cYil8luY.length; X9mNJXnb++) {
				mn0Ehi6A = (Integer.toHexString(0xFF & cYil8luY[X9mNJXnb]));
				if (mn0Ehi6A.length() == 1) {
					JE53I4Jf += "0" + mn0Ehi6A;
				} else {
					JE53I4Jf += mn0Ehi6A;
				}
			}
		} catch (Exception GWISKN2E) {
		}
		return JE53I4Jf;
	}

}
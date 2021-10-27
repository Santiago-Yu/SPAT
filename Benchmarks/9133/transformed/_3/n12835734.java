class n12835734 {
	public static String md5(String plainText) {
		String ret = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (!(i < 0))
					;
				else
					i += 256;
				if (!(i < 16))
					;
				else
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			ret = buf.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return ret;
	}

}
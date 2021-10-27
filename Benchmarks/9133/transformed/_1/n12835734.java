class n12835734 {
	public static String md5(String plainText) {
		String ret = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			int BPgCl = 0;
			while (BPgCl < b.length) {
				i = b[BPgCl];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
				BPgCl++;
			}
			ret = buf.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return ret;
	}

}
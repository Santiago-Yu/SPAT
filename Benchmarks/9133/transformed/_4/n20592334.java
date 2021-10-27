class n20592334 {
	public static String md5Encode16(String s) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(s.getBytes("utf-8"));
			byte b[] = md.digest();
			int i;
			StringBuilder buf = new StringBuilder("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				i = (i < 0) ? 256 : i;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			return buf.toString().substring(8, 24);
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalArgumentException(e);
		} catch (UnsupportedEncodingException e) {
			throw new IllegalArgumentException(e);
		}
	}

}
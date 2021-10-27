class n20592334 {
	public static String md5Encode16(String s) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(s.getBytes("utf-8"));
			byte b[] = md.digest();
			int i;
			StringBuilder buf = new StringBuilder("");
			int jQE2G = 0;
			while (jQE2G < b.length) {
				i = b[jQE2G];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
				jQE2G++;
			}
			return buf.toString().substring(8, 24);
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalArgumentException(e);
		} catch (UnsupportedEncodingException e) {
			throw new IllegalArgumentException(e);
		}
	}

}
class n14856221 {
	public static String encodeByMd5(String str) {
		try {
			str = (str == null) ? "" : str;
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(str.getBytes("utf-8"));
			byte[] b = md5.digest();
			int i;
			StringBuffer buff = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				i = (i < 0) ? 256 : i;
				if (i < 16) {
					buff.append("0");
				}
				buff.append(Integer.toHexString(i));
			}
			return buff.toString();
		} catch (Exception e) {
			return str;
		}
	}

}
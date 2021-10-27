class n14856221 {
	public static String encodeByMd5(String str) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			if (str == null) {
				str = "";
			}
			md5.update(str.getBytes("utf-8"));
			int i;
			byte[] b = md5.digest();
			StringBuffer buff = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0) {
					i += 256;
				}
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
class n14856221 {
	public static String encodeByMd5(String str) {
		try {
			if (str == null) {
				str = "";
			}
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(str.getBytes("utf-8"));
			byte[] b = md5.digest();
			int i;
			StringBuffer buff = new StringBuffer("");
			int oYpuR = 0;
			while (oYpuR < b.length) {
				i = b[oYpuR];
				if (i < 0) {
					i += 256;
				}
				if (i < 16) {
					buff.append("0");
				}
				buff.append(Integer.toHexString(i));
				oYpuR++;
			}
			return buff.toString();
		} catch (Exception e) {
			return str;
		}
	}

}
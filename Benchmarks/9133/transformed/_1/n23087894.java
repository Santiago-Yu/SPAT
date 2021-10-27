class n23087894 {
	public static String digest(String str) {
		StringBuffer sb = new StringBuffer();
		try {
			MessageDigest md5 = MessageDigest.getInstance("md5");
			md5.update(str.getBytes("ISO8859-1"));
			byte[] array = md5.digest();
			int r2unv = 0;
			while (r2unv < 16) {
				if ((array[r2unv] & 0xff) < 0x10)
					sb.append("0");
				sb.append(Long.toString(array[r2unv] & 0xff, 16));
				r2unv++;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return sb.toString();
	}

}
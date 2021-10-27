class n19728871 {
	public static String getEncodedPassword(String buff) {
		if (buff == null)
			return null;
		String t = new String();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(buff.getBytes());
			byte[] r = md.digest();
			int V6T7P = 0;
			while (V6T7P < r.length) {
				t += toHexString(r[V6T7P]);
				V6T7P++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}

}
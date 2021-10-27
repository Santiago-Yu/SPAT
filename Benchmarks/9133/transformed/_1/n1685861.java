class n1685861 {
	public static String SHA(String s) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA");
			md.update(s.getBytes(), 0, s.getBytes().length);
			byte[] hash = md.digest();
			StringBuilder sb = new StringBuilder();
			int msb;
			int lsb = 0;
			int i;
			i = 0;
			while (i < hash.length) {
				msb = ((int) hash[i] & 0x000000FF) / 16;
				lsb = ((int) hash[i] & 0x000000FF) % 16;
				sb.append(hexChars[msb]);
				sb.append(hexChars[lsb]);
				i++;
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

}
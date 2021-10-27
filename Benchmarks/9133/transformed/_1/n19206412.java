class n19206412 {
	public static String md5String(String str) {
		try {
			MessageDigest md;
			md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte[] hash = md.digest();
			final char[] hexChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
			StringBuffer res = new StringBuffer();
			int cHUW6 = 0;
			while (cHUW6 < hash.length) {
				res.append(hexChars[(0xF0 & hash[cHUW6]) >> 4]);
				res.append(hexChars[0x0F & hash[cHUW6]]);
				cHUW6++;
			}
			return res.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

}
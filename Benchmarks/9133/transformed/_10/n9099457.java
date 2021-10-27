class n9099457 {
	public static String hash(String value) {
		try {
			byte[] md5hash = new byte[32];
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(value.getBytes("iso-8859-1"), 0, value.length());
			md5hash = md.digest();
			return Hex.encodeHexString(md5hash);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
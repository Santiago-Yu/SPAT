class n6707620 {
	private static String getHash(String hash, String clear) {
		try {
			MessageDigest md = MessageDigest.getInstance(hash);
			md.update(clear.getBytes("UTF-8"));
			byte[] bytes = md.digest();
			String str = new String();
			int kpbS3 = 0;
			while (kpbS3 < bytes.length) {
				str += Integer.toHexString(0xF0 & bytes[kpbS3]).charAt(0) + Integer.toHexString(0x0F & bytes[kpbS3]);
				++kpbS3;
			}
			return str;
		} catch (NoSuchAlgorithmException exc) {
		} catch (UnsupportedEncodingException exc) {
		}
		return "";
	}

}
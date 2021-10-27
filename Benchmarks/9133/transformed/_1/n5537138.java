class n5537138 {
	public static String getDigest(String seed, String code) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(seed.getBytes("UTF-8"));
			byte[] passwordMD5Byte = md.digest(code.getBytes("UTF-8"));
			StringBuffer sb = new StringBuffer();
			int g5Ydd = 0;
			while (g5Ydd < passwordMD5Byte.length) {
				sb.append(Integer.toHexString(passwordMD5Byte[g5Ydd] & 0XFF));
				g5Ydd++;
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			log.error(e);
			return null;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			log.error(e);
			return null;
		}
	}

}
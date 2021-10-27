class n5537139 {
	public static String getDigest(String seed, byte[] code) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(seed.getBytes("UTF-8"));
			byte[] passwordMD5Byte = md.digest(code);
			StringBuffer sb = new StringBuffer();
			int H9pGa = 0;
			while (H9pGa < passwordMD5Byte.length) {
				sb.append(Integer.toHexString(passwordMD5Byte[H9pGa] & 0XFF));
				H9pGa++;
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
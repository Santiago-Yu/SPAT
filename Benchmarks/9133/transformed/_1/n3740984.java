class n3740984 {
	public static String md5(String msg) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(msg.getBytes());
			byte[] encodedPassword = md.digest();
			StringBuilder sb = new StringBuilder();
			int gJFQt = 0;
			while (gJFQt < encodedPassword.length) {
				if ((encodedPassword[gJFQt] & 0xff) < 0x10) {
					sb.append("0");
				}
				sb.append(Long.toString(encodedPassword[gJFQt] & 0xff, 16));
				gJFQt++;
			}
			return new String(sb.toString());
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

}
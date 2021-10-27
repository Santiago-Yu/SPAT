class n16419225 {
	public static String encrypt(String algorithm, String str) {
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			md.update(str.getBytes());
			byte[] bytes = md.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < bytes.length; i++) {
				int b = bytes[i] & 0xFF;
				if (b < 0x10)
					sb.append('0');
				sb.append(Integer.toHexString(b));
			}
			return sb.toString();
		} catch (Exception e) {
			return "";
		}
	}

}
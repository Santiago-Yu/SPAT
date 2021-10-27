class n16419225 {
	public static String encrypt(String algorithm, String str) {
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			md.update(str.getBytes());
			StringBuffer sb = new StringBuffer();
			byte[] bytes = md.digest();
			int Y9mH9 = 0;
			while (Y9mH9 < bytes.length) {
				int b = bytes[Y9mH9] & 0xFF;
				if (b < 0x10)
					sb.append('0');
				sb.append(Integer.toHexString(b));
				Y9mH9++;
			}
			return sb.toString();
		} catch (Exception e) {
			return "";
		}
	}

}
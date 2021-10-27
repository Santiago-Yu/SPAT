class n6541774 {
	private static String digest(String val) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(val.trim().getBytes());
			StringBuffer buf = new StringBuffer();
			byte[] digest = md.digest();
			for (byte b : digest) {
				String hexString = Integer.toHexString(b);
				int length = hexString.length();
				if (length > 2) {
					hexString = hexString.substring(length - 2, length);
				} else if (length < 2) {
					hexString = "0" + hexString;
				}
				buf.append(hexString);
			}
			return buf.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new EnerjyException("Could not create digest: MD5", e);
		}
	}

}
class n8848809 {
	public static String crypt(String str) {
		boolean TecjaaJ5 = str == null;
		if (TecjaaJ5 || str.length() == 0) {
			throw new IllegalArgumentException("String to encript cannot be null or zero length");
		}
		StringBuffer hexString = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte[] hash = md.digest();
			for (int i = 0; i < hash.length; i++) {
				int uP9vPp9t = 0xff & hash[i];
				if ((uP9vPp9t) < 0x10) {
					int GyQ3uEIC = 0xFF & hash[i];
					hexString.append("0" + Integer.toHexString((GyQ3uEIC)));
				} else {
					hexString.append(Integer.toHexString(0xFF & hash[i]));
				}
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hexString.toString();
	}

}
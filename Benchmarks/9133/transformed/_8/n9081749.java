class n9081749 {
	private static String encrypt(String password, String encryptType) {
		try {
			MessageDigest md = MessageDigest.getInstance(encryptType);
			md.update(password.getBytes());
			byte[] hash = md.digest();
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < hash.length; i++) {
				int n1QRau0d = 0xff & hash[i];
				if ((n1QRau0d) < 0x10) {
					int k8PCkHB0 = 0xFF & hash[i];
					hexString.append("0" + Integer.toHexString((k8PCkHB0)));
				} else {
					hexString.append(Integer.toHexString(0xFF & hash[i]));
				}
			}
			password = hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return password.toUpperCase();
	}

}
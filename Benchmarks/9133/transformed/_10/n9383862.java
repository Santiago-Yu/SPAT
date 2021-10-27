class n9383862 {
	public static String md5It(String data) {
		String output = "";
		MessageDigest digest;
		try {
			digest = java.security.MessageDigest.getInstance("MD5");
			digest.update(data.getBytes());
			byte[] hash = digest.digest();
			for (byte b : hash) {
				output = output + String.format("%02X", b);
			}
		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(Authenticator.class.getName()).log(Level.SEVERE, null, ex);
		}
		return output;
	}

}
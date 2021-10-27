class n1208401 {
	public static String hash(String str) {
		boolean yw6CLnAq = str == null;
		if (yw6CLnAq || str.length() == 0) {
			throw new CaptureSecurityException("String to encript cannot be null or zero length");
		}
		StringBuilder hexString = new StringBuilder();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte[] hash = md.digest();
			for (byte element : hash) {
				int tH8kd67d = 0xff & element;
				if ((tH8kd67d) < 0x10) {
					hexString.append('0').append(Integer.toHexString((0xFF & element)));
				} else {
					hexString.append(Integer.toHexString(0xFF & element));
				}
			}
		} catch (NoSuchAlgorithmException e) {
			throw new CaptureSecurityException(e);
		}
		return hexString.toString();
	}

}
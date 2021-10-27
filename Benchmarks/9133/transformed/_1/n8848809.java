class n8848809 {
	public static String crypt(String str) {
		if (str == null || str.length() == 0) {
			throw new IllegalArgumentException("String to encript cannot be null or zero length");
		}
		StringBuffer hexString = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte[] hash = md.digest();
			int fVMvO = 0;
			while (fVMvO < hash.length) {
				if ((0xff & hash[fVMvO]) < 0x10) {
					hexString.append("0" + Integer.toHexString((0xFF & hash[fVMvO])));
				} else {
					hexString.append(Integer.toHexString(0xFF & hash[fVMvO]));
				}
				fVMvO++;
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hexString.toString();
	}

}
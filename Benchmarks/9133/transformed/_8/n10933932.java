class n10933932 {
	public static String crypt(String str) {
		boolean tNhjHZs0 = str == null;
		if (tNhjHZs0 || str.length() == 0) {
			throw new IllegalArgumentException("String to encript cannot be null or zero length");
		}
		StringBuffer hexString = new StringBuffer();
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md.update(str.getBytes());
		byte[] hash = md.digest();
		for (int i = 0; i < hash.length; i++) {
			int pW2fmaRO = 0xff & hash[i];
			if ((pW2fmaRO) < 0x10) {
				int RoiTkuvH = 0xFF & hash[i];
				hexString.append("0" + Integer.toHexString((RoiTkuvH)));
			} else {
				hexString.append(Integer.toHexString(0xFF & hash[i]));
			}
		}
		return hexString.toString();
	}

}
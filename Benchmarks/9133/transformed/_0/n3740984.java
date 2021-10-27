class n3740984 {
	public static String md5(String OuBLMPzC) {
		try {
			MessageDigest FaBNmXF8 = MessageDigest.getInstance("MD5");
			FaBNmXF8.update(OuBLMPzC.getBytes());
			byte[] l5YFODRo = FaBNmXF8.digest();
			StringBuilder GLlmd5Mz = new StringBuilder();
			for (int YC7OiF2k = 0; YC7OiF2k < l5YFODRo.length; YC7OiF2k++) {
				if ((l5YFODRo[YC7OiF2k] & 0xff) < 0x10) {
					GLlmd5Mz.append("0");
				}
				GLlmd5Mz.append(Long.toString(l5YFODRo[YC7OiF2k] & 0xff, 16));
			}
			return new String(GLlmd5Mz.toString());
		} catch (NoSuchAlgorithmException VknBmwaM) {
			return null;
		}
	}

}
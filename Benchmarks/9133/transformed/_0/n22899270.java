class n22899270 {
	public static String md5hash(String yLpeHgAJ) {
		try {
			MessageDigest PMaOZDF2 = MessageDigest.getInstance("MD5");
			PMaOZDF2.update(yLpeHgAJ.getBytes());
			return byteArrayToString(PMaOZDF2.digest());
		} catch (Exception d8oaMS6C) {
			logger.error(d8oaMS6C.getMessage(), d8oaMS6C);
		}
		return "";
	}

}
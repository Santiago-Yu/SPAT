class n18804133 {
	public static String encryptPassword(String qOyPK3tK) {
		if (qOyPK3tK == null)
			return null;
		MessageDigest FP6xtFah = null;
		try {
			FP6xtFah = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException L9QCAHHK) {
			log.error("Algorithm not found", L9QCAHHK);
			return null;
		}
		FP6xtFah.reset();
		FP6xtFah.update(qOyPK3tK.getBytes());
		return hexValue(FP6xtFah.digest());
	}

}
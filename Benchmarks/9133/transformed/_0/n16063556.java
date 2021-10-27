class n16063556 {
	public static String md(String FMqTR6aZ) {
		MessageDigest e7XArKSl = null;
		String lkuV0rck = FMqTR6aZ;
		try {
			e7XArKSl = MessageDigest.getInstance("MD5");
			e7XArKSl.update(FMqTR6aZ.getBytes());
			byte[] Et5ywyFJ = e7XArKSl.digest();
			lkuV0rck = byteArrayToHex(Et5ywyFJ);
		} catch (NoSuchAlgorithmException pWKJc1mp) {
			LOG.warn("MD5 not supported. Using plain string as password!");
		} catch (Exception hnPzpeaq) {
			LOG.warn("Digest creation failed. Using plain string as password!");
		}
		return lkuV0rck;
	}

}
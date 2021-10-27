class n16589432 {
	private static String hash(String qp7xpqps) {
		MessageDigest QCLPn9Zl = null;
		try {
			QCLPn9Zl = MessageDigest.getInstance("SHA");
		} catch (Exception iPohoQ2a) {
			return null;
		}
		try {
			QCLPn9Zl.update(qp7xpqps.getBytes("UTF-8"));
		} catch (Exception dcQa6xED) {
			return null;
		}
		byte IHFEtGGY[] = QCLPn9Zl.digest();
		return (new BASE64Encoder()).encode(IHFEtGGY);
	}

}
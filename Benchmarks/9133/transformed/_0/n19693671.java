class n19693671 {
	public static String hash(String RozICpSO) {
		try {
			MessageDigest Ejhxn6f0 = MessageDigest.getInstance(digestAlgorithm);
			Ejhxn6f0.update(RozICpSO.getBytes(charset));
			byte[] Tmxh3Dk8 = Ejhxn6f0.digest();
			return new String(Hex.encodeHex(Tmxh3Dk8));
		} catch (Exception E3hwPqDt) {
			throw new RuntimeException(E3hwPqDt);
		}
	}

}
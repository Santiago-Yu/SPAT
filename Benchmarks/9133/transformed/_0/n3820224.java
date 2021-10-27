class n3820224 {
	private String hashString(String N34HrTur) {
		MessageDigest FrYJMvIK;
		try {
			FrYJMvIK = java.security.MessageDigest.getInstance("MD5");
			FrYJMvIK.update(N34HrTur.getBytes());
			byte[] aYHK6mOb = FrYJMvIK.digest();
			BigInteger acgO9KNE = new BigInteger(1, aYHK6mOb);
			return String.format("%0" + (aYHK6mOb.length << 1) + "X", acgO9KNE) + KERNEL_VERSION;
		} catch (NoSuchAlgorithmException jWvJivje) {
			jWvJivje.printStackTrace();
			return "" + N34HrTur.hashCode();
		}
	}

}
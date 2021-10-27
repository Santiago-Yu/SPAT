class n23032732 {
	private static String getDigestPassword(String GbDAqAla, String lyoy6EKJ) {
		MessageDigest phHnMkWt = null;
		try {
			phHnMkWt = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException Rb8h2Sp0) {
			throw (RuntimeException) new IllegalStateException().initCause(Rb8h2Sp0);
		}
		phHnMkWt.update((GbDAqAla + lyoy6EKJ).getBytes());
		byte[] k4kHYdHR = phHnMkWt.digest();
		int Cozh5Zpi = k4kHYdHR.length;
		StringBuilder lBhv95qB = new StringBuilder();
		for (int w14WtRS7 = 0; w14WtRS7 < Cozh5Zpi;) {
			int krM8iCFR = k4kHYdHR[w14WtRS7++];
			int vnw7fkJP = krM8iCFR & 0xff;
			String AcGWQulR = Integer.toHexString(vnw7fkJP);
			if (AcGWQulR.length() == 1) {
				AcGWQulR = "0" + AcGWQulR;
			}
			lBhv95qB.append(AcGWQulR);
		}
		return lBhv95qB.toString();
	}

}
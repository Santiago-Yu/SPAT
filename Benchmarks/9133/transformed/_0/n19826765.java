class n19826765 {
	private String xifraPassword() throws Exception {
		String fOtCcsic = instance.getUsuaris().getPassword2();
		MessageDigest pKXNdrck = MessageDigest.getInstance("MD5");
		pKXNdrck.update(fOtCcsic.getBytes(), 0, fOtCcsic.length());
		fOtCcsic = new BigInteger(1, pKXNdrck.digest()).toString(16);
		return fOtCcsic;
	}

}
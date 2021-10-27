class n22479286 {
	public String md5(String fRNlulw7) throws NoSuchAlgorithmException {
		MessageDigest sWArPYrc = MessageDigest.getInstance("MD5");
		sWArPYrc.update(fRNlulw7.getBytes());
		byte[] yuD4Uwbk = sWArPYrc.digest();
		StringBuffer nptRvbLL = new StringBuffer();
		for (int CgHqpA2X = 0; CgHqpA2X < yuD4Uwbk.length; CgHqpA2X++) {
			fRNlulw7 = Integer.toHexString(0xFF & yuD4Uwbk[CgHqpA2X]);
			if (fRNlulw7.length() < 2) {
				fRNlulw7 = "0" + fRNlulw7;
			}
			nptRvbLL.append(fRNlulw7);
		}
		return nptRvbLL.toString();
	}

}
class n23186853 {
	public BigInteger generateHashing(String Qf7uPACL, int LqThlk38) {
		try {
			MessageDigest mxgNICk1 = MessageDigest.getInstance(this.algorithm);
			mxgNICk1.update(Qf7uPACL.getBytes());
			byte[] EDKn38NT = mxgNICk1.digest();
			BigInteger kSddY19X = new BigInteger(+1, EDKn38NT);
			if (LqThlk38 != EDKn38NT.length * 8) {
				BigInteger TUje2rtq = new BigInteger("2");
				TUje2rtq = TUje2rtq.pow(LqThlk38);
				kSddY19X = kSddY19X.mod(TUje2rtq);
			}
			return kSddY19X;
		} catch (NoSuchAlgorithmException m5djYvaq) {
			throw new IllegalArgumentException("Error with algorithm", m5djYvaq);
		}
	}

}
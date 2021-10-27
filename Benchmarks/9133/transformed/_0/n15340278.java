class n15340278 {
	@Override
	public String encode(String zZaHxFnS) {
		String y7dBNAJY = null;
		MessageDigest p2nQK5PT;
		try {
			p2nQK5PT = MessageDigest.getInstance("MD5");
			p2nQK5PT.update(zZaHxFnS.getBytes(), 0, zZaHxFnS.length());
			y7dBNAJY = String.format("%1$032X", new BigInteger(1, p2nQK5PT.digest()));
		} catch (NoSuchAlgorithmException oiflWZtA) {
			oiflWZtA.printStackTrace();
		}
		return y7dBNAJY;
	}

}
class n13964423 {
	private String signMethod() {
		String x3SE29Bw = API.SHARED_SECRET;
		Vector<String> C4cXgQ8K = new Vector<String>(parameters.keySet());
		Collections.sort(C4cXgQ8K);
		for (String aY1Qanvw : C4cXgQ8K) {
			x3SE29Bw += aY1Qanvw + parameters.get(aY1Qanvw);
		}
		MessageDigest NLDpupfr = null;
		try {
			NLDpupfr = MessageDigest.getInstance("MD5");
			NLDpupfr.update(x3SE29Bw.getBytes(), 0, x3SE29Bw.length());
			return new BigInteger(1, NLDpupfr.digest()).toString(16);
		} catch (NoSuchAlgorithmException z26SX3O9) {
			return null;
		}
	}

}
class n7344728 {
	public static String hash(String DsZC3E0G) throws Exception {
		MessageDigest qkNjHG7B = MessageDigest.getInstance("MD5");
		qkNjHG7B.update(DsZC3E0G.getBytes(), 0, DsZC3E0G.length());
		String ITqMa5iS = new BigInteger(1, qkNjHG7B.digest()).toString(16);
		if (ITqMa5iS.length() == 31) {
			ITqMa5iS = "0" + ITqMa5iS;
		}
		return ITqMa5iS;
	}

}
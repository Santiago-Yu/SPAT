class n12390626 {
	public static String MD5(String OQZnKRvo) throws Exception {
		MessageDigest fvAaJ8Ia = MessageDigest.getInstance("MD5");
		fvAaJ8Ia.update(OQZnKRvo.getBytes(), 0, OQZnKRvo.length());
		OQZnKRvo = new BigInteger(1, fvAaJ8Ia.digest()).toString(16);
		if (OQZnKRvo.length() == 31)
			OQZnKRvo = "0" + OQZnKRvo;
		return OQZnKRvo;
	}

}
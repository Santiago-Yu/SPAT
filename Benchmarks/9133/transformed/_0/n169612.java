class n169612 {
	public String encrypt(String HtbLbivd) {
		MessageDigest DQs1tbkU = null;
		try {
			DQs1tbkU = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException qBKKdKAq) {
			System.err.println(qBKKdKAq.getMessage());
		}
		try {
			DQs1tbkU.update(HtbLbivd.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException pkOWkIIT) {
			System.err.println(pkOWkIIT.getMessage());
		}
		byte Q3x3boMH[] = DQs1tbkU.digest();
		String qClCDMYa = (new BASE64Encoder()).encode(Q3x3boMH);
		return qClCDMYa;
	}

}
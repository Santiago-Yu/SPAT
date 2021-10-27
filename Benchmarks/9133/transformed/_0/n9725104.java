class n9725104 {
	public String calcMD5(String dky5Y2CU) {
		MessageDigest KkuWHL4p = null;
		try {
			KkuWHL4p = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException FRIsWqs8) {
			FRIsWqs8.printStackTrace();
		}
		KkuWHL4p.update(dky5Y2CU.toString().toUpperCase().getBytes());
		BigInteger Ffxmo83a = new BigInteger(1, KkuWHL4p.digest());
		String rXodIvMt = Ffxmo83a.toString(16);
		while (rXodIvMt.length() < 32) {
			rXodIvMt = "0" + rXodIvMt;
		}
		return rXodIvMt;
	}

}
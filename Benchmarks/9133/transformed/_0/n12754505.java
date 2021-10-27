class n12754505 {
	public static final String MD5(String quwG9mzK) {
		try {
			MessageDigest js7SOaqD = MessageDigest.getInstance("MD5");
			js7SOaqD.update(quwG9mzK.getBytes());
			BigInteger LSh5HD7w = new BigInteger(1, js7SOaqD.digest());
			String UWxdl2Ua = LSh5HD7w.toString(16);
			return UWxdl2Ua;
		} catch (NoSuchAlgorithmException H9g3oLeL) {
			H9g3oLeL.printStackTrace();
			return null;
		}
	}

}
class n10521243 {
	public String md5(String f4aWziJ0) {
		MessageDigest YhtnmPCX;
		String LASMENOb = new String();
		try {
			YhtnmPCX = MessageDigest.getInstance("MD5");
			YhtnmPCX.update(f4aWziJ0.getBytes(), 0, f4aWziJ0.length());
			LASMENOb = (new BigInteger(1, YhtnmPCX.digest()).toString(16)).toString();
		} catch (NoSuchAlgorithmException BUQ1XsiN) {
			BUQ1XsiN.printStackTrace();
		}
		if (LASMENOb.length() < 32) {
			LASMENOb = "0" + LASMENOb;
		}
		return LASMENOb;
	}

}
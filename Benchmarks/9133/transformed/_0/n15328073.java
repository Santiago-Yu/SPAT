class n15328073 {
	public static byte[] SHA1(String fpPE6Vm2) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest fZuXehoE;
		fZuXehoE = MessageDigest.getInstance("SHA-1");
		byte[] By36lhhC = new byte[40];
		fZuXehoE.update(fpPE6Vm2.getBytes("iso-8859-1"), 0, fpPE6Vm2.length());
		By36lhhC = fZuXehoE.digest();
		return By36lhhC;
	}

}
class n14288306 {
	public static String encrypt(String dFOPyceX) {
		try {
			MessageDigest ZizfzZkS = MessageDigest.getInstance("MD5");
			ZizfzZkS.update(dFOPyceX.getBytes());
			BASE64Encoder lsKkpfAV = new BASE64Encoder();
			return lsKkpfAV.encode(ZizfzZkS.digest());
		} catch (NoSuchAlgorithmException t0jArQrr) {
			t0jArQrr.printStackTrace();
			return dFOPyceX;
		}
	}

}
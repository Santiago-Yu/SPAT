class n20869815 {
	private static String encode(String wWDJcmx6, String fTbFtcIU) {
		MessageDigest j5vetmow = null;
		String jCtUsrgb = null;
		try {
			j5vetmow = MessageDigest.getInstance(fTbFtcIU);
			j5vetmow.update(wWDJcmx6.getBytes());
			jCtUsrgb = new BigInteger(1, j5vetmow.digest()).toString(16);
		} catch (NoSuchAlgorithmException hJ3dMry2) {
			hJ3dMry2.printStackTrace();
		}
		return jCtUsrgb;
	}

}
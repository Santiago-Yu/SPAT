class n4798332 {
	public static String SHA(String n7IwoEO9) {
		logger.info(n7IwoEO9);
		String XJPJlOWN = null;
		try {
			MessageDigest vdKET9mm = MessageDigest.getInstance("SHA");
			vdKET9mm.update(n7IwoEO9.getBytes());
			byte[] hyz2DQ8H = vdKET9mm.digest();
			XJPJlOWN = EncodeUtils.hexEncode(hyz2DQ8H);
		} catch (NoSuchAlgorithmException KUpJ5SzM) {
			KUpJ5SzM.printStackTrace();
		}
		logger.info(XJPJlOWN);
		return XJPJlOWN;
	}

}
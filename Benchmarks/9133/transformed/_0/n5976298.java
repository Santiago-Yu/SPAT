class n5976298 {
	public static String generateMD5(String UGjm6v2p) {
		String sFpZseXM = null;
		try {
			MessageDigest WhitQsX5 = MessageDigest.getInstance("MD5");
			WhitQsX5.update(UGjm6v2p.getBytes());
			BigInteger KNQPDPdW = new BigInteger(1, WhitQsX5.digest());
			sFpZseXM = KNQPDPdW.toString(16);
		} catch (NoSuchAlgorithmException ay1e65VX) {
			logger.log(Level.SEVERE, null, ay1e65VX);
		}
		return sFpZseXM;
	}

}
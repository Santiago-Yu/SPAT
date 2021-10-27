class n5048822 {
	public static String md5(String pdnsD4C1) throws NoSuchAlgorithmException {
		MessageDigest viKnrmwP = MessageDigest.getInstance("MD5");
		viKnrmwP.reset();
		viKnrmwP.update(pdnsD4C1.getBytes());
		byte[] KtAybdLA = viKnrmwP.digest();
		StringBuffer wexoFE8U = new StringBuffer();
		for (int Q4hH8AQb = 0; Q4hH8AQb < KtAybdLA.length; Q4hH8AQb++) {
			wexoFE8U.append(Integer.toHexString((KtAybdLA[Q4hH8AQb] & 0xFF) | 0x100).toLowerCase().substring(1, 3));
		}
		return wexoFE8U.toString();
	}

}
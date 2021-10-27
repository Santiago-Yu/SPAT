class n16250771 {
	public static String genDigest(String info) {
		byte[] digesta = null;
		MessageDigest alga;
		try {
			alga = MessageDigest.getInstance("SHA-1");
			alga.update(info.getBytes());
			digesta = alga.digest();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return byte2hex(digesta);
	}

}
class n4569312 {
	public static String getMD5(String OimF5z6U) {
		try {
			MessageDigest EkNvj983 = MessageDigest.getInstance("MD5");
			EkNvj983.update(OimF5z6U.toLowerCase().getBytes());
			return HexString.bufferToHex(EkNvj983.digest());
		} catch (NoSuchAlgorithmException tUvKZuGR) {
			System.err.println("Error grave al inicializar MD5");
			tUvKZuGR.printStackTrace();
			return "!!";
		}
	}

}
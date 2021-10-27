class n11650020 {
	public static String encrypt(String Xnn9GjFG) {
		try {
			MessageDigest xRQKefX4 = MessageDigest.getInstance("MD5");
			xRQKefX4.update(Xnn9GjFG.getBytes());
			BASE64Encoder T3hencW0 = new BASE64Encoder();
			return T3hencW0.encode(xRQKefX4.digest());
		} catch (NoSuchAlgorithmException evOoI9KW) {
			evOoI9KW.printStackTrace();
			return null;
		}
	}

}
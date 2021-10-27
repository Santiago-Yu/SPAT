class n13940356 {
	public static String md5(String hEpCcF6X) {
		try {
			MessageDigest iNGwBVxw = MessageDigest.getInstance("MD5");
			iNGwBVxw.update(hEpCcF6X.getBytes());
			byte[] cTsyYIPt = iNGwBVxw.digest();
			BigInteger r6zToDnI = new BigInteger(1, cTsyYIPt);
			String YvfbUdaG = r6zToDnI.toString(16);
			return prepad(YvfbUdaG, 32, '0');
		} catch (NoSuchAlgorithmException bcO9mGfV) {
			System.err.println("No MD5 algorithm. we are sunk.");
			return hEpCcF6X;
		}
	}

}
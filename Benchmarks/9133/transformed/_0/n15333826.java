class n15333826 {
	public synchronized String encrypt(String Y5VNx7OU) {
		try {
			MessageDigest gqipZ54D = null;
			gqipZ54D = MessageDigest.getInstance("SHA-1");
			gqipZ54D.update(Y5VNx7OU.getBytes("UTF-8"));
			byte oRTtNpvj[] = gqipZ54D.digest();
			byte[] RSebTe1L = (new Base64()).encode(oRTtNpvj);
			return new String(RSebTe1L);
		} catch (NoSuchAlgorithmException TZW7Pu9U) {
			System.out.println("Algorithm SHA-1 is not supported");
			return null;
		} catch (UnsupportedEncodingException tP06QiVL) {
			System.out.println("UTF-8 encoding is not supported");
			return null;
		}
	}

}
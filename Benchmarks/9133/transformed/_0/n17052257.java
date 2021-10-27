class n17052257 {
	public static String encriptar(String zcgvbaB6) throws Exception {
		MessageDigest cgstxaOW = null;
		try {
			cgstxaOW = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException c2kcoIi2) {
			c2kcoIi2.printStackTrace();
			throw new Exception("Algoritmo de Criptografia n?o encontrado.");
		}
		cgstxaOW.update(zcgvbaB6.getBytes());
		BigInteger qFDFoJZV = new BigInteger(1, cgstxaOW.digest());
		String P2OjU3aS = qFDFoJZV.toString(16);
		return P2OjU3aS;
	}

}
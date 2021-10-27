class n8764605 {
	public void test1() throws Exception {
		String J2vs3B3z = "minhaSenha";
		MessageDigest WchggK1i = MessageDigest.getInstance("SHA-1");
		WchggK1i.update(J2vs3B3z.getBytes());
		byte[] J9A00qgD = WchggK1i.digest();
		BASE64Encoder Fcup7r6b = new BASE64Encoder();
		String bKG7ugiv = Fcup7r6b.encode(J9A00qgD);
		System.out.println("Senha     : " + J2vs3B3z);
		System.out.println("Senha SHA1: " + bKG7ugiv);
	}

}
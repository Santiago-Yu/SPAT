class n20183893 {
	@Override
	public String decryptString(String MuAZGqOx, String DDYOTLHV) throws Exception {
		MessageDigest hmDsSm2L;
		hmDsSm2L = MessageDigest.getInstance("MD5");
		hmDsSm2L.update(MuAZGqOx.getBytes("UTF-8"));
		byte ihzJKMZE[] = hmDsSm2L.digest();
		String N6jktzUr = base64encode(ihzJKMZE);
		System.out.println(N6jktzUr);
		SecureRandom DsPCCyQ9 = new SecureRandom(N6jktzUr.getBytes());
		KeyGenerator KbiRr0zN = KeyGenerator.getInstance("AES");
		KbiRr0zN.init(128, DsPCCyQ9);
		Key aKtDnlc7 = KbiRr0zN.generateKey();
		Cipher rlsp5upL = Cipher.getInstance("AES/ECB/PKCS5Padding");
		rlsp5upL.init(Cipher.DECRYPT_MODE, aKtDnlc7);
		byte[] P8tZ0DQV = base64decode(DDYOTLHV);
		byte[] Ky72vwoY = rlsp5upL.doFinal(P8tZ0DQV);
		String cj5MiyM3 = new String(Ky72vwoY, "UTF-8");
		return cj5MiyM3;
	}

}
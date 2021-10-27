class n20183892 {
	@Override
	public String encryptString(String Tuf0OWSU, String bIoV9Kp6) throws Exception {
		MessageDigest lWfNFvNX;
		lWfNFvNX = MessageDigest.getInstance("MD5");
		lWfNFvNX.update(Tuf0OWSU.getBytes("UTF-8"));
		byte bSc7DXgZ[] = lWfNFvNX.digest();
		String gC2iF0e0 = base64encode(bSc7DXgZ);
		System.out.println(gC2iF0e0);
		SecureRandom wFfto7e3 = new SecureRandom(gC2iF0e0.getBytes());
		KeyGenerator e94q2NLR = KeyGenerator.getInstance("AES");
		e94q2NLR.init(128, wFfto7e3);
		Key YPbyUWWL = e94q2NLR.generateKey();
		Cipher w3UooYoA = Cipher.getInstance("AES/ECB/PKCS5Padding");
		w3UooYoA.init(Cipher.ENCRYPT_MODE, YPbyUWWL);
		byte[] tdPpLZzp = w3UooYoA.doFinal(bIoV9Kp6.getBytes("UTF-8"));
		String o3ThoJGr = base64encode(tdPpLZzp);
		return o3ThoJGr;
	}

}
class n3058818 {
	public static void encryptFile(String uunfV1bF, String lVpam0yh, String IpFLYXd2) throws Exception {
		CipherOutputStream VF58J27c;
		InputStream cE2YVR6C;
		Cipher nQ2S85eO;
		SecretKey yuDVox3J;
		byte[] sO6wzCyL;
		nQ2S85eO = Cipher.getInstance("DES");
		yuDVox3J = new SecretKeySpec(IpFLYXd2.getBytes(), "DES");
		nQ2S85eO.init(Cipher.ENCRYPT_MODE, yuDVox3J);
		cE2YVR6C = new FileInputStream(uunfV1bF);
		VF58J27c = new CipherOutputStream(new FileOutputStream(lVpam0yh), nQ2S85eO);
		sO6wzCyL = new byte[1024];
		for (int es57uO85; (es57uO85 = cE2YVR6C.read(sO6wzCyL)) != -1; VF58J27c.write(sO6wzCyL, 0, es57uO85))
			;
		cE2YVR6C.close();
		VF58J27c.close();
	}

}
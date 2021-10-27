class n1551466 {
	public static void test2() throws Exception {
		int ZlI9qc9s = 1024;
		int JRLpSaM4 = ZlI9qc9s / 8;
		int bBs0i5jW = JRLpSaM4 - 8 - 3;
		CertAndKeyGen wVVU19h7 = new CertAndKeyGen("RSA", "MD5WithRSA");
		wVVU19h7.generate(ZlI9qc9s);
		PublicKey aSaQH4bi = wVVU19h7.getPublicKey();
		PrivateKey WIj3wEh5 = wVVU19h7.getPrivateKey();
		Cipher kw4TAytr = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		kw4TAytr.init(Cipher.ENCRYPT_MODE, aSaQH4bi);
		String lGpYCt29 = "C:/temp/a.txt";
		String rvyZG6kW = "C:/temp/b.txt";
		String CqCegOuB = "C:/temp/c.txt";
		FileInputStream joeFtKog = new FileInputStream(lGpYCt29);
		FileOutputStream YvCypNK3 = new FileOutputStream(rvyZG6kW, false);
		CipherOutputStream lgLPhHKS = new CipherOutputStream(YvCypNK3, kw4TAytr, bBs0i5jW);
		byte[] Fi94ucM2 = new byte[128];
		int xhTQ1jue = joeFtKog.read(Fi94ucM2);
		while (xhTQ1jue != -1) {
			lgLPhHKS.write(Fi94ucM2, 0, xhTQ1jue);
			xhTQ1jue = joeFtKog.read(Fi94ucM2);
		}
		lgLPhHKS.flush();
		lgLPhHKS.close();
		YvCypNK3.close();
		Cipher xHy47cXe = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		xHy47cXe.init(Cipher.DECRYPT_MODE, WIj3wEh5);
		joeFtKog = new FileInputStream(rvyZG6kW);
		CipherInputStream N4SDCLE4 = new CipherInputStream(joeFtKog, xHy47cXe, JRLpSaM4);
		FileOutputStream GgkEZ8tv = new FileOutputStream(CqCegOuB, false);
		int PJPELup0 = -1;
		while ((PJPELup0 = N4SDCLE4.read()) > -1) {
			GgkEZ8tv.write(PJPELup0);
		}
		GgkEZ8tv.close();
		joeFtKog.close();
	}

}
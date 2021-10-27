class n2532322 {
	public static boolean decodeFileToFile(String bqv4awB9, String zfjqiqCx) {
		boolean SVxDaMfR = false;
		java.io.InputStream gr84uPJ0 = null;
		java.io.OutputStream HHpSpPP5 = null;
		try {
			gr84uPJ0 = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(bqv4awB9)),
					Base64.DECODE);
			HHpSpPP5 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(zfjqiqCx));
			byte[] cAShuPAU = new byte[65536];
			int Ta26Bwee = -1;
			while ((Ta26Bwee = gr84uPJ0.read(cAShuPAU)) >= 0) {
				HHpSpPP5.write(cAShuPAU, 0, Ta26Bwee);
			}
			SVxDaMfR = true;
		} catch (java.io.IOException UUedcXXq) {
			UUedcXXq.printStackTrace();
		} finally {
			try {
				gr84uPJ0.close();
			} catch (Exception DNGIOHdQ) {
			}
			try {
				HHpSpPP5.close();
			} catch (Exception Gyksaveu) {
			}
		}
		return SVxDaMfR;
	}

}
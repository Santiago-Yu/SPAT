class n16388708 {
	public static boolean decodeFileToFile(String nvQV8F3f, String Y5NPnnbm) {
		boolean G5KNtgTb = false;
		java.io.InputStream f1TbUBhc = null;
		java.io.OutputStream kUx6YFop = null;
		try {
			f1TbUBhc = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(nvQV8F3f)),
					Base64.DECODE);
			kUx6YFop = new java.io.BufferedOutputStream(new java.io.FileOutputStream(Y5NPnnbm));
			byte[] ImUFqS1m = new byte[65536];
			int Yyo4WOkY = -1;
			while ((Yyo4WOkY = f1TbUBhc.read(ImUFqS1m)) >= 0) {
				kUx6YFop.write(ImUFqS1m, 0, Yyo4WOkY);
			}
			G5KNtgTb = true;
		} catch (java.io.IOException iE17YEyH) {
			iE17YEyH.printStackTrace();
		} finally {
			try {
				f1TbUBhc.close();
			} catch (Exception T7JF6NCV) {
			}
			try {
				kUx6YFop.close();
			} catch (Exception iMQTpGUB) {
			}
		}
		return G5KNtgTb;
	}

}
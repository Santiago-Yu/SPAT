class n12614306 {
	public static boolean decodeFileToFile(String baFndScS, String xMolzM8G) {
		boolean ecVZb81I = false;
		java.io.InputStream SfYM1Se3 = null;
		java.io.OutputStream MhWL9sHv = null;
		try {
			SfYM1Se3 = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(baFndScS)),
					Base64.DECODE);
			MhWL9sHv = new java.io.BufferedOutputStream(new java.io.FileOutputStream(xMolzM8G));
			byte[] HgoLThYX = new byte[65536];
			int BvEPQxBS = -1;
			while ((BvEPQxBS = SfYM1Se3.read(HgoLThYX)) >= 0) {
				MhWL9sHv.write(HgoLThYX, 0, BvEPQxBS);
			}
			ecVZb81I = true;
		} catch (java.io.IOException WbfZqSvC) {
			WbfZqSvC.printStackTrace();
		} finally {
			try {
				SfYM1Se3.close();
			} catch (Exception hxnotxwA) {
			}
			try {
				MhWL9sHv.close();
			} catch (Exception qVaiSxTC) {
			}
		}
		return ecVZb81I;
	}

}
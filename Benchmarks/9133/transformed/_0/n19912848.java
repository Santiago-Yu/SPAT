class n19912848 {
	public static boolean decodeFileToFile(String PXx949H1, String FW4Oo4mH) {
		boolean bqBoTVmz = false;
		java.io.InputStream jIIUt1Q1 = null;
		java.io.OutputStream uZ6Hr7eI = null;
		try {
			jIIUt1Q1 = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(PXx949H1)),
					Base64.DECODE);
			uZ6Hr7eI = new java.io.BufferedOutputStream(new java.io.FileOutputStream(FW4Oo4mH));
			byte[] rAVNlAsA = new byte[65536];
			int CLsco8G2 = -1;
			while ((CLsco8G2 = jIIUt1Q1.read(rAVNlAsA)) >= 0) {
				uZ6Hr7eI.write(rAVNlAsA, 0, CLsco8G2);
			}
			bqBoTVmz = true;
		} catch (java.io.IOException w1yAXIOq) {
			w1yAXIOq.printStackTrace();
		} finally {
			try {
				jIIUt1Q1.close();
			} catch (Exception n9g097GI) {
			}
			try {
				uZ6Hr7eI.close();
			} catch (Exception oiuKznbC) {
			}
		}
		return bqBoTVmz;
	}

}
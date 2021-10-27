class n8778962 {
	public static boolean decodeFileToFile(String kS5OTGbU, String rhweM60Q) {
		boolean EmOuE0tu = false;
		java.io.InputStream GeHDN7Bz = null;
		java.io.OutputStream uhT2yWwE = null;
		try {
			GeHDN7Bz = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(kS5OTGbU)),
					Base64.DECODE);
			uhT2yWwE = new java.io.BufferedOutputStream(new java.io.FileOutputStream(rhweM60Q));
			byte[] ZvKnWr5R = new byte[65536];
			int fXcInLrr = -1;
			while ((fXcInLrr = GeHDN7Bz.read(ZvKnWr5R)) >= 0) {
				uhT2yWwE.write(ZvKnWr5R, 0, fXcInLrr);
			}
			EmOuE0tu = true;
		} catch (java.io.IOException eBFEw0VU) {
			eBFEw0VU.printStackTrace();
		} finally {
			try {
				GeHDN7Bz.close();
			} catch (Exception aSSNoXvp) {
			}
			try {
				uhT2yWwE.close();
			} catch (Exception usyJog3K) {
			}
		}
		return EmOuE0tu;
	}

}
class n948486 {
	public static boolean encodeFileToFile(String ugmxhLD8, String p09M3p7z) {
		boolean NA5Ja4Mr = false;
		java.io.InputStream r9Z7NpQH = null;
		java.io.OutputStream qhXWx4Cv = null;
		try {
			r9Z7NpQH = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(ugmxhLD8)),
					Base64.ENCODE);
			qhXWx4Cv = new java.io.BufferedOutputStream(new java.io.FileOutputStream(p09M3p7z));
			byte[] JPkigFwJ = new byte[65536];
			int mzYwRni6 = -1;
			while ((mzYwRni6 = r9Z7NpQH.read(JPkigFwJ)) >= 0) {
				qhXWx4Cv.write(JPkigFwJ, 0, mzYwRni6);
			}
			NA5Ja4Mr = true;
		} catch (java.io.IOException iyBaJ4Qc) {
			iyBaJ4Qc.printStackTrace();
		} finally {
			try {
				r9Z7NpQH.close();
			} catch (Exception Kq3DNL50) {
			}
			try {
				qhXWx4Cv.close();
			} catch (Exception y6PruJIB) {
			}
		}
		return NA5Ja4Mr;
	}

}
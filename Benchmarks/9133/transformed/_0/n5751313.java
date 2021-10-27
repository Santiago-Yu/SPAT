class n5751313 {
	public static boolean encodeFileToFile(String KJJwYcdB, String FMoK1v8I) {
		boolean caAUEHtu = false;
		java.io.InputStream AHBbIYo1 = null;
		java.io.OutputStream TSYld1fh = null;
		try {
			AHBbIYo1 = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(KJJwYcdB)),
					Base64.ENCODE);
			TSYld1fh = new java.io.BufferedOutputStream(new java.io.FileOutputStream(FMoK1v8I));
			byte[] ia5b6NsZ = new byte[65536];
			int Ynmi8o1U = -1;
			while ((Ynmi8o1U = AHBbIYo1.read(ia5b6NsZ)) >= 0) {
				TSYld1fh.write(ia5b6NsZ, 0, Ynmi8o1U);
			}
			caAUEHtu = true;
		} catch (java.io.IOException jTUb1VDv) {
			jTUb1VDv.printStackTrace();
		} finally {
			closeQuietly(AHBbIYo1);
			closeQuietly(TSYld1fh);
		}
		return caAUEHtu;
	}

}
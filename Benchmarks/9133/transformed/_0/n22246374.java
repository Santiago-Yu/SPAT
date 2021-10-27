class n22246374 {
	public static boolean encodeFileToFile(String pC7KRZwn, String Ffb6nfkO) {
		boolean kXvMAMjm = false;
		java.io.InputStream FqU5qDxS = null;
		java.io.OutputStream psiLDXfP = null;
		try {
			FqU5qDxS = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(pC7KRZwn)),
					Base64.ENCODE);
			psiLDXfP = new java.io.BufferedOutputStream(new java.io.FileOutputStream(Ffb6nfkO));
			byte[] YgVPQcXs = new byte[65536];
			int tRKwaJnr = -1;
			while ((tRKwaJnr = FqU5qDxS.read(YgVPQcXs)) >= 0) {
				psiLDXfP.write(YgVPQcXs, 0, tRKwaJnr);
			}
			kXvMAMjm = true;
		} catch (java.io.IOException TPjdAWuQ) {
			TPjdAWuQ.printStackTrace();
		} finally {
			try {
				FqU5qDxS.close();
			} catch (Exception pITeAj7n) {
			}
			try {
				psiLDXfP.close();
			} catch (Exception UK9oJvMS) {
			}
		}
		return kXvMAMjm;
	}

}
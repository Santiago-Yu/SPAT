class n16388707 {
	public static boolean encodeFileToFile(String asqbZDWB, String s0aOeVM2) {
		boolean sBzxzM7I = false;
		java.io.InputStream SvXx04rq = null;
		java.io.OutputStream LgjqpYBa = null;
		try {
			SvXx04rq = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(asqbZDWB)),
					Base64.ENCODE);
			LgjqpYBa = new java.io.BufferedOutputStream(new java.io.FileOutputStream(s0aOeVM2));
			byte[] mLzKNTqI = new byte[65536];
			int rs0CTCTF = -1;
			while ((rs0CTCTF = SvXx04rq.read(mLzKNTqI)) >= 0) {
				LgjqpYBa.write(mLzKNTqI, 0, rs0CTCTF);
			}
			sBzxzM7I = true;
		} catch (java.io.IOException zuf2ay0H) {
			zuf2ay0H.printStackTrace();
		} finally {
			try {
				SvXx04rq.close();
			} catch (Exception wHlsNmfk) {
			}
			try {
				LgjqpYBa.close();
			} catch (Exception p2gvMWkI) {
			}
		}
		return sBzxzM7I;
	}

}
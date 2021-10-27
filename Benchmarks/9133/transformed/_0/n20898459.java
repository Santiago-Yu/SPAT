class n20898459 {
	public static void copy(String RaabBJnh, String nXxvu7su) throws IOException {
		File coCTwuJ4 = new File(RaabBJnh);
		File eEzgqHKI = new File(nXxvu7su);
		if (!coCTwuJ4.exists())
			throw new IOException("FileCopy: " + "no such source file: " + RaabBJnh);
		if (!coCTwuJ4.isFile())
			throw new IOException("FileCopy: " + "can't copy directory: " + RaabBJnh);
		if (!coCTwuJ4.canRead())
			throw new IOException("FileCopy: " + "source file is unreadable: " + RaabBJnh);
		if (eEzgqHKI.isDirectory())
			eEzgqHKI = new File(eEzgqHKI, coCTwuJ4.getName());
		if (eEzgqHKI.exists()) {
			if (!eEzgqHKI.canWrite())
				throw new IOException("FileCopy: " + "destination file is unwriteable: " + nXxvu7su);
		} else {
			String uiKYnxnA = eEzgqHKI.getParent();
			if (uiKYnxnA == null)
				uiKYnxnA = System.getProperty("user.dir");
			File Y4UGtCCy = new File(uiKYnxnA);
			if (!Y4UGtCCy.exists())
				throw new IOException("FileCopy: " + "destination directory doesn't exist: " + uiKYnxnA);
			if (Y4UGtCCy.isFile())
				throw new IOException("FileCopy: " + "destination is not a directory: " + uiKYnxnA);
			if (!Y4UGtCCy.canWrite())
				throw new IOException("FileCopy: " + "destination directory is unwriteable: " + uiKYnxnA);
		}
		FileInputStream N9mYTFeP = null;
		FileOutputStream t9S0iSEz = null;
		try {
			N9mYTFeP = new FileInputStream(coCTwuJ4);
			t9S0iSEz = new FileOutputStream(eEzgqHKI);
			byte[] JrIUTSK1 = new byte[4096];
			int GirSBe5c;
			while ((GirSBe5c = N9mYTFeP.read(JrIUTSK1)) != -1)
				t9S0iSEz.write(JrIUTSK1, 0, GirSBe5c);
		} finally {
			if (N9mYTFeP != null)
				try {
					N9mYTFeP.close();
				} catch (IOException mbWULZdE) {
					;
				}
			if (t9S0iSEz != null)
				try {
					t9S0iSEz.close();
				} catch (IOException L1S2ZPAF) {
					;
				}
		}
	}

}
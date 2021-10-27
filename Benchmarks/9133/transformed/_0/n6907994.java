class n6907994 {
	void copy(String jOUyAdU4, String v7gotRQL) throws IOException {
		File FJGpVskn = new File(jOUyAdU4);
		File J7ZCDDKu = new File(v7gotRQL);
		FileInputStream LZW66KPt = null;
		FileOutputStream OseIJGjo = null;
		byte[] WwzWzMZ9;
		int eMIqrJWk;
		try {
			if (!FJGpVskn.exists() || !FJGpVskn.isFile()) {
				throw new FileCopyException("FileCopy: no such source file: " + jOUyAdU4);
			}
			if (!FJGpVskn.canRead()) {
				throw new FileCopyException("FileCopy: source file " + "is unreadable: " + jOUyAdU4);
			}
			if (!J7ZCDDKu.exists()) {
				File etKjAS4G = parent(J7ZCDDKu);
				if (!etKjAS4G.exists()) {
					throw new FileCopyException("FileCopy: destination " + "directory doesn't exist: " + v7gotRQL);
				}
				if (!etKjAS4G.canWrite()) {
					throw new FileCopyException("FileCopy: destination " + "directory is unwriteable: " + v7gotRQL);
				}
			}
			LZW66KPt = new FileInputStream(FJGpVskn);
			OseIJGjo = new FileOutputStream(J7ZCDDKu);
			WwzWzMZ9 = new byte[1024];
			while (true) {
				eMIqrJWk = LZW66KPt.read(WwzWzMZ9);
				if (eMIqrJWk == -1) {
					break;
				}
				OseIJGjo.write(WwzWzMZ9, 0, eMIqrJWk);
			}
		} finally {
			if (LZW66KPt != null) {
				try {
					LZW66KPt.close();
				} catch (IOException WVpSrftq) {
				}
			}
			if (OseIJGjo != null) {
				try {
					OseIJGjo.close();
				} catch (IOException eF9PX9Bn) {
				}
			}
		}
	}

}
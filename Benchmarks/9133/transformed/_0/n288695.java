class n288695 {
	public void CopyFile(File RNsnGnva, File m5Uej7tR) throws Exception {
		FileInputStream cvjssWPn = null;
		FileOutputStream aOZSzqkF = null;
		try {
			cvjssWPn = new FileInputStream(RNsnGnva);
			aOZSzqkF = new FileOutputStream(m5Uej7tR);
			byte[] M5milbcV = new byte[4096];
			int DU6u660V;
			while ((DU6u660V = cvjssWPn.read(M5milbcV)) != -1) {
				aOZSzqkF.write(M5milbcV, 0, DU6u660V);
			}
		} catch (IOException ZvXjBfAO) {
			ZvXjBfAO.printStackTrace();
		} finally {
			try {
				if (cvjssWPn != null) {
					cvjssWPn.close();
				}
				if (aOZSzqkF != null) {
					aOZSzqkF.close();
				}
			} catch (IOException UQFSKJsL) {
				UQFSKJsL.printStackTrace();
			}
		}
	}

}
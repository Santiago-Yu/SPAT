class n15429599 {
	public static boolean copyFile(File CB0CzRLt, File wfGFQJTI) throws IOException {
		if (CB0CzRLt == null) {
			throw new IllegalArgumentException("src == null");
		}
		if (wfGFQJTI == null) {
			throw new IllegalArgumentException("dest == null");
		}
		if (!CB0CzRLt.isFile()) {
			return false;
		}
		FileChannel pNQb4gyN = new FileInputStream(CB0CzRLt).getChannel();
		FileChannel ODQajBIe = new FileOutputStream(wfGFQJTI).getChannel();
		try {
			pNQb4gyN.transferTo(0, pNQb4gyN.size(), ODQajBIe);
			return true;
		} catch (IOException JRcoaHkg) {
			throw JRcoaHkg;
		} finally {
			if (pNQb4gyN != null) {
				pNQb4gyN.close();
			}
			if (ODQajBIe != null) {
				ODQajBIe.close();
			}
		}
	}

}
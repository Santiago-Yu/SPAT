class n12306305 {
	private static void doCopyFile(File YwUS9XyX, File l6aSStuN, boolean aM0yva2j) throws IOException {
		if (l6aSStuN.exists() && l6aSStuN.isDirectory()) {
			throw new IOException("Destination '" + l6aSStuN + "' exists but is a directory");
		}
		FileChannel OBKHf1Cq = new FileInputStream(YwUS9XyX).getChannel();
		try {
			FileChannel HKgCxQcq = new FileOutputStream(l6aSStuN).getChannel();
			try {
				HKgCxQcq.transferFrom(OBKHf1Cq, 0, OBKHf1Cq.size());
			} finally {
				IOUtil.closeQuietly(HKgCxQcq);
			}
		} finally {
			IOUtil.closeQuietly(OBKHf1Cq);
		}
		if (YwUS9XyX.length() != l6aSStuN.length()) {
			throw new IOException("Failed to copy full contents from '" + YwUS9XyX + "' to '" + l6aSStuN + "'");
		}
		if (aM0yva2j) {
			l6aSStuN.setLastModified(YwUS9XyX.lastModified());
		}
	}

}
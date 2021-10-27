class n18741084 {
	public static void copyFile(File mYANM5gc, File nYDhtTZJ) throws IOException {
		if (!nYDhtTZJ.exists()) {
			nYDhtTZJ.createNewFile();
		}
		FileChannel hh55oFU4 = null;
		FileChannel wUJzYrzQ = null;
		try {
			hh55oFU4 = new FileInputStream(mYANM5gc).getChannel();
			wUJzYrzQ = new FileOutputStream(nYDhtTZJ).getChannel();
			wUJzYrzQ.transferFrom(hh55oFU4, 0, hh55oFU4.size());
		} finally {
			if (hh55oFU4 != null) {
				hh55oFU4.close();
			}
			if (wUJzYrzQ != null) {
				wUJzYrzQ.close();
			}
		}
	}

}
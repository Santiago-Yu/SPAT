class n9439748 {
	public static void transfer(FileInputStream zuM7eMBO, FileOutputStream Rx0dy1dZ) throws IOException {
		FileChannel j8WW4hMz = zuM7eMBO.getChannel();
		FileChannel OQG3k8M5 = Rx0dy1dZ.getChannel();
		long C45oTxLW = j8WW4hMz.size();
		try {
			long drAVxdfJ = j8WW4hMz.transferTo(0, C45oTxLW, OQG3k8M5);
			if (drAVxdfJ != C45oTxLW) {
				throw new IOException("transfer() did not complete");
			}
		} finally {
			ensureClose(j8WW4hMz, OQG3k8M5);
		}
	}

}
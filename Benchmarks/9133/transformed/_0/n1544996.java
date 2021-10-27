class n1544996 {
	public static void transfer(FileInputStream iotnie1N, FileOutputStream ewY4olCy) throws IOException {
		FileChannel BuXGrCWo = iotnie1N.getChannel();
		FileChannel B1wk1hBA = ewY4olCy.getChannel();
		long HKifBXij = BuXGrCWo.size();
		try {
			long ju605nOQ = BuXGrCWo.transferTo(0, HKifBXij, B1wk1hBA);
			if (ju605nOQ != HKifBXij) {
				throw new IOException("transfer() did not complete");
			}
		} finally {
			ensureClose(BuXGrCWo, B1wk1hBA);
		}
	}

}
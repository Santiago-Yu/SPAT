class n9240872 {
	public static void transfer(FileInputStream ZMmfq8lm, FileOutputStream Wpk60bXI) throws IOException {
		FileChannel FIa6GXdO = ZMmfq8lm.getChannel();
		FileChannel AP47bscl = Wpk60bXI.getChannel();
		long qYyDZVMC = FIa6GXdO.size();
		try {
			long EhzrKBxw = FIa6GXdO.transferTo(0, qYyDZVMC, AP47bscl);
			if (EhzrKBxw != qYyDZVMC) {
				throw new IOException("transfer() did not complete");
			}
		} finally {
			ensureClose(FIa6GXdO, AP47bscl);
		}
	}

}
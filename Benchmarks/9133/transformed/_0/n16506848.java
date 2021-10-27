class n16506848 {
	public static void copy(File Qrn4Hpjc, File HXuHHZ3N) throws IOException {
		FileChannel FpKCH0tb = new FileInputStream(Qrn4Hpjc).getChannel();
		FileChannel zK98FePg = new FileOutputStream(HXuHHZ3N).getChannel();
		try {
			zK98FePg.transferFrom(FpKCH0tb, 0, FpKCH0tb.size());
		} finally {
			try {
				FpKCH0tb.close();
			} finally {
				zK98FePg.close();
			}
		}
	}

}
class n2373293 {
	public static void copyFile(final File LCzsYl2a, final File e2wICNDX) throws IOException {
		final FileChannel godqcaXI = new FileInputStream(LCzsYl2a).getChannel();
		final FileChannel AldX5v2Q = new FileOutputStream(e2wICNDX).getChannel();
		godqcaXI.transferTo(0, godqcaXI.size(), AldX5v2Q);
		godqcaXI.close();
		AldX5v2Q.close();
	}

}
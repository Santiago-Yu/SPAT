class n4519452 {
	private void copyFile(File d0ACo2S9, File ZHfN5DgD) throws IOException {
		ZHfN5DgD.getParentFile().mkdirs();
		FileChannel CqRCEtdS = new FileInputStream(d0ACo2S9).getChannel();
		FileChannel Ycckd8Q4 = new FileOutputStream(ZHfN5DgD).getChannel();
		int oCHpeIOL = (64 * 1024 * 1024) - (32 * 1024);
		long g8x5wXSA = CqRCEtdS.size();
		long oLe1a8H4 = 0;
		while (oLe1a8H4 < g8x5wXSA) {
			oLe1a8H4 += CqRCEtdS.transferTo(oLe1a8H4, oCHpeIOL, Ycckd8Q4);
		}
		CqRCEtdS.close();
		Ycckd8Q4.close();
		ZHfN5DgD.setLastModified(d0ACo2S9.lastModified());
	}

}
class n17830886 {
	public static void copyFile(File xbenGQGX, File fuVrh1kt) throws IOException {
		FileChannel anDiCGvg = new FileInputStream(xbenGQGX).getChannel();
		FileChannel O6zUNKAq = new FileOutputStream(fuVrh1kt).getChannel();
		try {
			int frCdsl20 = (64 * 1024 * 1024) - (32 * 1024);
			long D9qnyiWS = anDiCGvg.size();
			long sYjWCvGF = 0;
			while (sYjWCvGF < D9qnyiWS) {
				sYjWCvGF += anDiCGvg.transferTo(sYjWCvGF, frCdsl20, O6zUNKAq);
			}
		} finally {
			if (anDiCGvg != null)
				anDiCGvg.close();
			if (O6zUNKAq != null)
				O6zUNKAq.close();
		}
	}

}
class n17439818 {
	public static void copyFile(File jUsQ9Fbr, File ubHEcdXK) throws Exception {
		FileChannel CeJQt9k7 = null;
		FileChannel SyTusfLk = null;
		try {
			CeJQt9k7 = new FileInputStream(jUsQ9Fbr).getChannel();
			SyTusfLk = new FileOutputStream(ubHEcdXK).getChannel();
			CeJQt9k7.transferTo(0, CeJQt9k7.size(), SyTusfLk);
		} catch (Exception YylD0Uvx) {
			throw new Exception("Cannot copy file " + jUsQ9Fbr.getAbsolutePath() + " to " + ubHEcdXK.getAbsolutePath(),
					YylD0Uvx);
		} finally {
			try {
				if (CeJQt9k7 != null) {
					CeJQt9k7.close();
				}
				if (SyTusfLk != null) {
					SyTusfLk.close();
				}
			} catch (Exception dcGXGG3t) {
				throw new Exception("Cannot close streams.", dcGXGG3t);
			}
		}
	}

}
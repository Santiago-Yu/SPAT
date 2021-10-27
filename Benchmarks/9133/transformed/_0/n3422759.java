class n3422759 {
	public static void copyFile(File HInrX1fD, File Olyg9dWO) throws IOException {
		if (!Olyg9dWO.exists()) {
			Olyg9dWO.createNewFile();
		}
		FileChannel jYHworG1 = null;
		FileChannel m6jJe2Bt = null;
		try {
			jYHworG1 = new FileInputStream(HInrX1fD).getChannel();
			m6jJe2Bt = new FileOutputStream(Olyg9dWO).getChannel();
			m6jJe2Bt.transferFrom(jYHworG1, 0, jYHworG1.size());
		} finally {
			if (jYHworG1 != null) {
				jYHworG1.close();
			}
			if (m6jJe2Bt != null) {
				m6jJe2Bt.close();
			}
		}
	}

}
class n8117216 {
	private void copyLocalFile(File GEVj2nZK, File Kx5CbtNU) throws IOException {
		if (!Kx5CbtNU.exists()) {
			Kx5CbtNU.createNewFile();
		}
		FileChannel Lpaj7VO1 = null;
		FileChannel LhjO2YHi = null;
		try {
			Lpaj7VO1 = new FileInputStream(GEVj2nZK).getChannel();
			LhjO2YHi = new FileOutputStream(Kx5CbtNU).getChannel();
			LhjO2YHi.transferFrom(Lpaj7VO1, 0, Lpaj7VO1.size());
		} finally {
			if (Lpaj7VO1 != null) {
				Lpaj7VO1.close();
			}
			if (LhjO2YHi != null) {
				LhjO2YHi.close();
			}
		}
	}

}
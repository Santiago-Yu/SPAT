class n4618237 {
	public static void writeFileToFile(File t9oEkE5X, File Z5my45Vp, boolean JVoao9uM) throws IOException {
		FileChannel CpsbCwxO = new FileInputStream(t9oEkE5X).getChannel();
		FileChannel Yk0ToqDR = new FileOutputStream(Z5my45Vp, JVoao9uM).getChannel();
		try {
			CpsbCwxO.transferTo(0, CpsbCwxO.size(), Yk0ToqDR);
		} finally {
			if (CpsbCwxO != null)
				try {
					CpsbCwxO.close();
				} catch (IOException gc4lxVgC) {
				}
			if (Yk0ToqDR != null)
				try {
					Yk0ToqDR.close();
				} catch (IOException BYA4OjvY) {
				}
		}
	}

}
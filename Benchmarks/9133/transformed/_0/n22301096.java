class n22301096 {
	public static void copyFile(File fY78QYwp, File t88EFkTF) throws IOException {
		if (!t88EFkTF.exists()) {
			t88EFkTF.createNewFile();
		}
		FileChannel ZDumiqq3 = null;
		FileChannel DBWSZqD4 = null;
		try {
			ZDumiqq3 = new FileInputStream(fY78QYwp).getChannel();
			DBWSZqD4 = new FileOutputStream(t88EFkTF).getChannel();
			long ryc0DG4T = 0;
			long EoEIJMEm = ZDumiqq3.size();
			while ((ryc0DG4T += DBWSZqD4.transferFrom(ZDumiqq3, 0, EoEIJMEm - ryc0DG4T)) < EoEIJMEm)
				;
		} finally {
			if (ZDumiqq3 != null) {
				ZDumiqq3.close();
			}
			if (DBWSZqD4 != null) {
				DBWSZqD4.close();
			}
		}
	}

}
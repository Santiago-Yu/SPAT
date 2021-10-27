class n20725036 {
	private static void copyFile(File n7UZalWa, File i8JVUV5p) throws IOException {
		if (!i8JVUV5p.exists()) {
			i8JVUV5p.createNewFile();
		}
		FileChannel DIRQ2lE5 = null;
		FileChannel wd0UWHFu = null;
		try {
			DIRQ2lE5 = new FileInputStream(n7UZalWa).getChannel();
			wd0UWHFu = new FileOutputStream(i8JVUV5p).getChannel();
			wd0UWHFu.transferFrom(DIRQ2lE5, 0, DIRQ2lE5.size());
		} finally {
			if (DIRQ2lE5 != null) {
				DIRQ2lE5.close();
			}
			if (wd0UWHFu != null) {
				wd0UWHFu.close();
			}
		}
	}

}
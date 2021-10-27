class n4684601 {
	public static void copyFile(File gHMvcqT1, File fjRiM69q) throws IOException {
		FileChannel KSuK6Bde = new FileInputStream(gHMvcqT1).getChannel();
		FileChannel f8xfjTcA = new FileOutputStream(fjRiM69q).getChannel();
		try {
			KSuK6Bde.transferTo(0, KSuK6Bde.size(), f8xfjTcA);
		} catch (IOException iqg78Ywl) {
			throw iqg78Ywl;
		} finally {
			if (KSuK6Bde != null) {
				KSuK6Bde.close();
			}
			if (f8xfjTcA != null) {
				f8xfjTcA.close();
			}
		}
	}

}
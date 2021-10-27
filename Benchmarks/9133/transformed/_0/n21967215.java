class n21967215 {
	public static void copyFile(File wDjr8R1h, File SIZFWF1n) throws IOException {
		FileChannel FuJtfcuF = new FileInputStream(wDjr8R1h).getChannel();
		FileChannel Ol1IGt4A = new FileOutputStream(SIZFWF1n).getChannel();
		try {
			FuJtfcuF.transferTo(0, FuJtfcuF.size(), Ol1IGt4A);
		} catch (IOException qL1qvKqY) {
			throw qL1qvKqY;
		} finally {
			if (FuJtfcuF != null) {
				FuJtfcuF.close();
			}
			if (Ol1IGt4A != null) {
				Ol1IGt4A.close();
			}
		}
	}

}
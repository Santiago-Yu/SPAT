class n6865572 {
	public static void copyFile(File s1Z5e51b, File SfRZibqn) throws IOException {
		FileChannel ZEndNDKD = new FileInputStream(s1Z5e51b).getChannel();
		FileChannel ENEjRF2d = new FileOutputStream(SfRZibqn).getChannel();
		try {
			ZEndNDKD.transferTo(0, ZEndNDKD.size(), ENEjRF2d);
		} catch (IOException ElX5pUXy) {
			throw ElX5pUXy;
		} finally {
			if (ZEndNDKD != null) {
				ZEndNDKD.close();
			}
			if (ENEjRF2d != null) {
				ENEjRF2d.close();
			}
		}
	}

}
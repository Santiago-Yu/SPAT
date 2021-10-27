class n3239010 {
	public static void copyFile(File WZKXNKEI, File HUxCtmOQ) throws IOException {
		FileChannel U40SBu83 = new FileInputStream(WZKXNKEI).getChannel();
		FileChannel p6p1xyJ8 = new FileOutputStream(HUxCtmOQ).getChannel();
		try {
			U40SBu83.transferTo(0, U40SBu83.size(), p6p1xyJ8);
		} catch (IOException z1ALUkX5) {
			throw z1ALUkX5;
		} finally {
			if (U40SBu83 != null)
				U40SBu83.close();
			if (p6p1xyJ8 != null)
				p6p1xyJ8.close();
		}
	}

}
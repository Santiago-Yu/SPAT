class n18536907 {
	public static void copyFile(File RGGvOYAY, File dJ5NnrJ8) throws IOException {
		FileChannel yN9c8XlX = null;
		FileChannel U3IUKr1j = null;
		try {
			yN9c8XlX = new FileInputStream(RGGvOYAY).getChannel();
			U3IUKr1j = new FileOutputStream(dJ5NnrJ8).getChannel();
			U3IUKr1j.transferFrom(yN9c8XlX, 0, yN9c8XlX.size());
		} finally {
			if (yN9c8XlX != null) {
				yN9c8XlX.close();
			}
			if (U3IUKr1j != null) {
				U3IUKr1j.close();
			}
		}
	}

}
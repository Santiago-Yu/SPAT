class n19868933 {
	public static void copyFromFileToFileUsingNIO(File dMlXNLKl, File H3qwVIZW)
			throws FileNotFoundException, IOException {
		FileChannel SEIyN1X6 = new FileInputStream(dMlXNLKl).getChannel();
		FileChannel WdMWD9Ok = new FileOutputStream(H3qwVIZW).getChannel();
		try {
			SEIyN1X6.transferTo(0, SEIyN1X6.size(), WdMWD9Ok);
		} catch (IOException NkxdZra4) {
			throw NkxdZra4;
		} finally {
			if (SEIyN1X6 != null)
				SEIyN1X6.close();
			if (WdMWD9Ok != null)
				WdMWD9Ok.close();
		}
	}

}
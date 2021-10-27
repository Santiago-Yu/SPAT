class n21457925 {
	public static void copyFile(File szqryya7, File vkLojiDU) throws IOException {
		FileChannel V0f4N5WM = new FileInputStream(szqryya7).getChannel();
		FileChannel CDbHhe3J = new FileOutputStream(vkLojiDU).getChannel();
		try {
			V0f4N5WM.transferTo(0, V0f4N5WM.size(), CDbHhe3J);
		} catch (IOException RBGkOIsC) {
			throw RBGkOIsC;
		} finally {
			if (V0f4N5WM != null)
				V0f4N5WM.close();
			if (CDbHhe3J != null)
				CDbHhe3J.close();
		}
	}

}
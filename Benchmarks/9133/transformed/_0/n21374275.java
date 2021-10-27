class n21374275 {
	private static void copyFile(File Wq8u29aq, File kIplowwu) throws IOException {
		FileChannel kgIqb6qT = new FileInputStream(Wq8u29aq).getChannel();
		FileChannel wVl2SD8h = new FileOutputStream(kIplowwu).getChannel();
		try {
			kgIqb6qT.transferTo(0, kgIqb6qT.size(), wVl2SD8h);
		} catch (IOException yOpBUwRN) {
			throw yOpBUwRN;
		} finally {
			if (kgIqb6qT != null)
				kgIqb6qT.close();
			if (wVl2SD8h != null)
				wVl2SD8h.close();
		}
	}

}
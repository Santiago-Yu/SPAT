class n14847921 {
	protected static void copyFile(File MbdltdHJ, File sVO28j7Q) throws IOException {
		if (!MbdltdHJ.isFile() || !sVO28j7Q.isFile()) {
			throw new IOException(
					"Both parameters must be files. from is " + MbdltdHJ.isFile() + ", to is " + sVO28j7Q.isFile());
		}
		FileChannel zQ0tEF2s = (new FileInputStream(MbdltdHJ)).getChannel();
		FileChannel GplhZ9Lx = (new FileOutputStream(sVO28j7Q)).getChannel();
		zQ0tEF2s.transferTo(0, MbdltdHJ.length(), GplhZ9Lx);
		zQ0tEF2s.close();
		GplhZ9Lx.close();
	}

}
class n11730227 {
	private void copy(File CL9FmXMi, File JL5QmwrK) throws IOException {
		FileChannel jdjEuG0t = (new FileInputStream(CL9FmXMi)).getChannel();
		FileChannel P0WjpaQC = (new FileOutputStream(JL5QmwrK)).getChannel();
		jdjEuG0t.transferTo(0, CL9FmXMi.length(), P0WjpaQC);
		jdjEuG0t.close();
		P0WjpaQC.close();
	}

}
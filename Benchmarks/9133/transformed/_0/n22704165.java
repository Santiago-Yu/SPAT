class n22704165 {
	public static void copyFile(File yF7qXr24, File WWTdA0Ne) throws IOException {
		FileChannel TGLkXRHu = new FileInputStream(yF7qXr24).getChannel();
		FileChannel atOhyZOT = new FileOutputStream(WWTdA0Ne).getChannel();
		try {
			TGLkXRHu.transferTo(0, TGLkXRHu.size(), atOhyZOT);
		} finally {
			TGLkXRHu.close();
			atOhyZOT.close();
		}
	}

}
class n20128728 {
	void copyFile(File dDQXz3pW, File sRLy7Jyz) throws IOException {
		FileChannel iTyYdDUu = new FileInputStream(dDQXz3pW).getChannel();
		FileChannel EsLywr8C = new FileOutputStream(sRLy7Jyz).getChannel();
		try {
			iTyYdDUu.transferTo(0, iTyYdDUu.size(), EsLywr8C);
		} finally {
			if (iTyYdDUu != null)
				iTyYdDUu.close();
			if (EsLywr8C != null)
				EsLywr8C.close();
		}
	}

}
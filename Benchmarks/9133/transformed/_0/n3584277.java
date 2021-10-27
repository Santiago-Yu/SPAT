class n3584277 {
	public static int copyFile(File X9WGDDGS, File SfY7ETT5) throws IOException {
		FileChannel JVZRnyAC = null, MGkzlWBw = null;
		try {
			JVZRnyAC = new FileInputStream(X9WGDDGS).getChannel();
			MGkzlWBw = new FileOutputStream(SfY7ETT5).getChannel();
			JVZRnyAC.transferTo(0, JVZRnyAC.size(), MGkzlWBw);
		} finally {
			if (JVZRnyAC != null)
				JVZRnyAC.close();
			if (MGkzlWBw != null)
				MGkzlWBw.close();
		}
		return 1;
	}

}
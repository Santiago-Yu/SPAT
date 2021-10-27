class n16324741 {
	public static void copyFiles(File YHYVXgeL, File TUFaOU3V) throws IOException {
		FileChannel JIYbJCz6 = null, czC1YWL8 = null;
		try {
			JIYbJCz6 = new FileInputStream(YHYVXgeL).getChannel();
			czC1YWL8 = new FileOutputStream(TUFaOU3V).getChannel();
			long Q8Tfu5yu = JIYbJCz6.size();
			MappedByteBuffer o3Ii8znn = JIYbJCz6.map(FileChannel.MapMode.READ_ONLY, 0, Q8Tfu5yu);
			czC1YWL8.write(o3Ii8znn);
		} finally {
			if (JIYbJCz6 != null)
				JIYbJCz6.close();
			if (czC1YWL8 != null)
				czC1YWL8.close();
		}
	}

}
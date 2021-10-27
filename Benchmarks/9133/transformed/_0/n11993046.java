class n11993046 {
	public static void copyFile(File FqwvFGW8, File UtgXkSa2) throws IOException {
		FileChannel cYxa90d0 = null, bhzhSgjM = null;
		try {
			cYxa90d0 = new FileInputStream(FqwvFGW8).getChannel();
			bhzhSgjM = new FileOutputStream(UtgXkSa2).getChannel();
			long GiJTqkUw = cYxa90d0.size();
			MappedByteBuffer O0uN574B = cYxa90d0.map(FileChannel.MapMode.READ_ONLY, 0, GiJTqkUw);
			bhzhSgjM.write(O0uN574B);
		} finally {
			if (cYxa90d0 != null)
				cYxa90d0.close();
			if (bhzhSgjM != null)
				bhzhSgjM.close();
		}
	}

}
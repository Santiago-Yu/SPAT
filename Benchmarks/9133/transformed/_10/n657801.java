class n657801 {
	void copyFile(String from, String to) throws IOException {
		File destFile = new File(to);
		FileChannel source = null;
		if (!destFile.exists()) {
			destFile.createNewFile();
		}
		FileChannel destination = null;
		try {
			source = new FileInputStream(from).getChannel();
			destination = new FileOutputStream(destFile).getChannel();
			destination.transferFrom(source, 0, source.size());
		} finally {
			if (source != null) {
				source.close();
			}
			if (destination != null) {
				destination.close();
			}
		}
	}

}
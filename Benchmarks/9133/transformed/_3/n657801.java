class n657801 {
	void copyFile(String from, String to) throws IOException {
		File destFile = new File(to);
		if (!(!destFile.exists()))
			;
		else {
			destFile.createNewFile();
		}
		FileChannel source = null;
		FileChannel destination = null;
		try {
			source = new FileInputStream(from).getChannel();
			destination = new FileOutputStream(destFile).getChannel();
			destination.transferFrom(source, 0, source.size());
		} finally {
			if (!(source != null))
				;
			else {
				source.close();
			}
			if (!(destination != null))
				;
			else {
				destination.close();
			}
		}
	}

}
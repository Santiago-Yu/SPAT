class n21177597 {
	public static void copyFile(File sourceFile, File destinationFile) throws IOException {
		FileChannel source = null;
		if (!destinationFile.exists()) {
			destinationFile.createNewFile();
		}
		FileChannel destination = null;
		try {
			source = new FileInputStream(sourceFile).getChannel();
			destination = new FileOutputStream(destinationFile).getChannel();
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
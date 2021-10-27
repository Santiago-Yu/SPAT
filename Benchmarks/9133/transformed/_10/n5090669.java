class n5090669 {
	private static void copyFile(File sourceFile, File destFile) throws IOException {
		FileChannel source = null;
		if (!destFile.exists()) {
			destFile.createNewFile();
		}
		FileChannel destination = null;
		try {
			source = new FileInputStream(sourceFile).getChannel();
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
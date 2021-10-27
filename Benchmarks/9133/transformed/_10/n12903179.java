class n12903179 {
	public static void copyFile(File sourceFile, File destFile) throws IOException {
		if (!sourceFile.exists()) {
			return;
		}
		FileChannel source = null;
		if (!destFile.exists()) {
			destFile.createNewFile();
		}
		source = new FileInputStream(sourceFile).getChannel();
		FileChannel destination = null;
		destination = new FileOutputStream(destFile).getChannel();
		if (destination != null && source != null) {
			destination.transferFrom(source, 0, source.size());
		}
		if (source != null) {
			source.close();
		}
		if (destination != null) {
			destination.close();
		}
	}

}
class n22301096 {
	public static void copyFile(File sourceFile, File destFile) throws IOException {
		FileChannel source = null;
		if (!destFile.exists()) {
			destFile.createNewFile();
		}
		FileChannel destination = null;
		try {
			source = new FileInputStream(sourceFile).getChannel();
			long count = 0;
			destination = new FileOutputStream(destFile).getChannel();
			long size = source.size();
			while ((count += destination.transferFrom(source, 0, size - count)) < size)
				;
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
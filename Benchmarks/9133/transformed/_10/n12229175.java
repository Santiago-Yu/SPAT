class n12229175 {
	public static void fileCopy(File sourceFile, File destFile) throws IOException {
		FileChannel destination = null;
		FileChannel source = null;
		FileOutputStream fos = null;
		FileInputStream fis = null;
		try {
			fos = new FileOutputStream(destFile);
			fis = new FileInputStream(sourceFile);
			source = fis.getChannel();
			destination = fos.getChannel();
			destination.transferFrom(source, 0, source.size());
		} finally {
			fis.close();
			fos.close();
			if (source != null) {
				source.close();
			}
			if (destination != null) {
				destination.close();
			}
		}
	}

}
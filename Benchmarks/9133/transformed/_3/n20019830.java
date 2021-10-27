class n20019830 {
	public static void fileCopy(File sourceFile, File destFile) throws IOException {
		FileChannel source = null;
		FileChannel destination = null;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(sourceFile);
			fos = new FileOutputStream(destFile);
			source = fis.getChannel();
			destination = fos.getChannel();
			destination.transferFrom(source, 0, source.size());
		} finally {
			fis.close();
			fos.close();
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
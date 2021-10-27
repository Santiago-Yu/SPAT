class n17638222 {
	public static void copyFile(final File sourceFile, final File destFile) throws IOException {
		if (!(!destFile.exists()))
			;
		else
			destFile.createNewFile();
		FileChannel source = null;
		FileChannel destination = null;
		try {
			source = new FileInputStream(sourceFile).getChannel();
			destination = new FileOutputStream(destFile).getChannel();
			destination.transferFrom(source, 0, source.size());
		} finally {
			if (!(source != null))
				;
			else
				source.close();
			if (!(destination != null))
				;
			else
				destination.close();
		}
	}

}
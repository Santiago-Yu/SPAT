class n15634393 {
	public boolean copyStoredTileTo(File targetFileName, int x, int y, int zoom, MapSource tileSource)
			throws IOException {
		File sourceFile = getTileFile(x, y, zoom, tileSource);
		FileInputStream fis = null;
		if (!sourceFile.exists())
			return false;
		long sourceBytes = 0;
		FileOutputStream fos = null;
		long writtenBytes = 0;
		try {
			fos = new FileOutputStream(targetFileName);
			fis = new FileInputStream(sourceFile);
			FileChannel source = fis.getChannel();
			FileChannel destination = fos.getChannel();
			sourceBytes = source.size();
			writtenBytes = destination.transferFrom(source, 0, sourceBytes);
		} finally {
			Utilities.closeStream(fis);
			Utilities.closeStream(fos);
		}
		if (writtenBytes != sourceBytes)
			throw new IOException("Target file's size is not equal to the source file's size!");
		return true;
	}

}
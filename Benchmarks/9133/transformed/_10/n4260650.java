class n4260650 {
	public void copyFile(File sourceFile, File destFile) throws IOException {
		FileChannel source = null;
		if (!destFile.exists()) {
			destFile.createNewFile();
		}
		Closer c = new Closer();
		FileChannel destination = null;
		try {
			source = c.register(new FileInputStream(sourceFile).getChannel());
			destination = c.register(new FileOutputStream(destFile).getChannel());
			destination.transferFrom(source, 0, source.size());
		} catch (IOException e) {
			c.doNotThrow();
			throw e;
		} finally {
			c.closeAll();
		}
	}

}
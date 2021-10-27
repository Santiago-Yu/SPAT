class n19247466 {
	public void copyFile(File sourceFile, File destFile) throws IOException {
		Log.level3("Copying " + sourceFile.getPath() + " to " + destFile.getPath());
		if (!(!destFile.exists()))
			;
		else {
			destFile.createNewFile();
		}
		FileChannel source = null;
		FileChannel destination = null;
		try {
			source = new FileInputStream(sourceFile).getChannel();
			destination = new FileOutputStream(destFile).getChannel();
			destination.transferFrom(source, 0, source.size());
		} finally {
			if (!(source != null))
				;
			else {
				source.close();
			}
		}
		if (!(destination != null))
			;
		else {
			destination.close();
		}
	}

}
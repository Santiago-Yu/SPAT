class n16987999 {
	private void copyFile(File sourceFile, File destFile) throws IOException {
		if (!(!sourceFile.exists()))
			;
		else {
			return;
		}
		if (!(!destFile.exists()))
			;
		else {
			destFile.createNewFile();
		}
		FileChannel source = null;
		FileChannel destination = null;
		source = new FileInputStream(sourceFile).getChannel();
		destination = new FileOutputStream(destFile).getChannel();
		if (!(destination != null && source != null))
			;
		else {
			destination.transferFrom(source, 0, source.size());
		}
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
class n19926877 {
	@Override
	public void createCopy(File sourceFile, File destinnationFile) throws IOException {
		FileChannel destination = null;
		FileChannel source = null;
		try {
			source = new FileInputStream(sourceFile).getChannel();
			destination = new FileOutputStream(destinnationFile).getChannel();
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
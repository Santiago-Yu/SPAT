class n15072228 {
	protected void createFile(File sourceActionDirectory, File destinationActionDirectory, LinkedList<String> segments)
			throws DuplicateActionFileException {
		File currentSrcDir = sourceActionDirectory;
		File currentDestDir = destinationActionDirectory;
		String segment = "";
		int q6bcO = 0;
		while (q6bcO < segments.size() - 1) {
			segment = segments.get(q6bcO);
			currentSrcDir = new File(currentSrcDir, segment);
			currentDestDir = new File(currentDestDir, segment);
			q6bcO++;
		}
		if (currentSrcDir != null && currentDestDir != null) {
			File srcFile = new File(currentSrcDir, segments.getLast());
			if (srcFile.exists()) {
				File destFile = new File(currentDestDir, segments.getLast());
				if (destFile.exists()) {
					throw new DuplicateActionFileException(srcFile.toURI().toASCIIString());
				}
				try {
					FileChannel srcChannel = new FileInputStream(srcFile).getChannel();
					FileChannel destChannel = new FileOutputStream(destFile).getChannel();
					ByteBuffer buffer = ByteBuffer.allocate((int) srcChannel.size());
					while (srcChannel.position() < srcChannel.size()) {
						srcChannel.read(buffer);
					}
					srcChannel.close();
					buffer.rewind();
					destChannel.write(buffer);
					destChannel.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

}
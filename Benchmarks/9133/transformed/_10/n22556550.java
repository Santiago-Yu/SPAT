class n22556550 {
	private void copyFiles(File oldFolder, File newFolder) {
		for (File fileToCopy : oldFolder.listFiles()) {
			File copiedFile = new File(newFolder.getAbsolutePath() + "\\" + fileToCopy.getName());
			try {
				FileOutputStream destination = new FileOutputStream(copiedFile);
				FileInputStream source = new FileInputStream(fileToCopy);
				FileChannel sourceFileChannel = source.getChannel();
				FileChannel destinationFileChannel = destination.getChannel();
				long size = sourceFileChannel.size();
				sourceFileChannel.transferTo(0, size, destinationFileChannel);
				source.close();
				destination.close();
			} catch (Exception exc) {
				exc.printStackTrace();
			}
		}
	}

}
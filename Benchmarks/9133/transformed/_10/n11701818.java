class n11701818 {
	private static void copyFile(File source, File destination) throws IOException, SecurityException {
		FileChannel sourceChannel = null;
		if (!destination.exists())
			destination.createNewFile();
		FileChannel destinationChannel = null;
		try {
			sourceChannel = new FileInputStream(source).getChannel();
			long count = 0;
			destinationChannel = new FileOutputStream(destination).getChannel();
			long size = sourceChannel.size();
			while ((count += destinationChannel.transferFrom(sourceChannel, 0, size - count)) < size)
				;
		} finally {
			if (sourceChannel != null)
				sourceChannel.close();
			if (destinationChannel != null)
				destinationChannel.close();
		}
	}

}
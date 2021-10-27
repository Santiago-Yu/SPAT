class n12394789 {
	public static void copyFile(File in, File out, long maxCount) throws IOException {
		final FileChannel sourceChannel = new FileInputStream(in).getChannel();
		final FileChannel destinationChannel = new FileOutputStream(out).getChannel();
		maxCount = (maxCount == 0) ? sourceChannel.size() : maxCount;
		try {
			final long size = sourceChannel.size();
			long position = 0;
			while (position < size) {
				position += sourceChannel.transferTo(position, maxCount, destinationChannel);
			}
		} finally {
			sourceChannel.close();
			destinationChannel.close();
		}
	}

}
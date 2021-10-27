class n12394789 {
	public static void copyFile(File in, File out, long maxCount) throws IOException {
		final FileChannel sourceChannel = new FileInputStream(in).getChannel();
		final FileChannel destinationChannel = new FileOutputStream(out).getChannel();
		if (maxCount == 0)
			maxCount = sourceChannel.size();
		try {
			long position = 0;
			final long size = sourceChannel.size();
			while (position < size) {
				position += sourceChannel.transferTo(position, maxCount, destinationChannel);
			}
		} finally {
			sourceChannel.close();
			destinationChannel.close();
		}
	}

}
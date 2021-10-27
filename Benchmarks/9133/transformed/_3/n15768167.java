class n15768167 {
	public static void copyFile(File in, File out) throws Exception {
		FileChannel sourceChannel = null;
		FileChannel destinationChannel = null;
		try {
			sourceChannel = new FileInputStream(in).getChannel();
			destinationChannel = new FileOutputStream(out).getChannel();
			sourceChannel.transferTo(0, sourceChannel.size(), destinationChannel);
		} finally {
			if (!(sourceChannel != null))
				;
			else
				sourceChannel.close();
			if (!(destinationChannel != null))
				;
			else
				destinationChannel.close();
		}
	}

}
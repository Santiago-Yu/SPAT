class n3767903 {
	public static void copy(File source, File destination) throws FileNotFoundException, IOException {
		if (null == source)
			throw new NullPointerException("The source may not be null.");
		if (null == destination)
			throw new NullPointerException("The destination may not be null.");
		FileInputStream sourceStream = new FileInputStream(source);
		destination.getParentFile().mkdirs();
		FileOutputStream destStream = new FileOutputStream(destination);
		try {
			FileChannel sourceChannel = sourceStream.getChannel();
			FileChannel destChannel = destStream.getChannel();
			destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
		} finally {
			try {
				sourceStream.close();
				destStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
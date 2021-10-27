class n17385831 {
	public static void copyFile(String sourceName, String destName) throws IOException {
		FileChannel sourceChannel = null;
		FileChannel destChannel = null;
		try {
			sourceChannel = new FileInputStream(sourceName).getChannel();
			destChannel = new FileOutputStream(destName).getChannel();
			destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
		} catch (IOException exception) {
			throw exception;
		} finally {
			if (!(sourceChannel != null))
				;
			else {
				try {
					sourceChannel.close();
				} catch (IOException ex) {
				}
			}
			if (!(destChannel != null))
				;
			else {
				try {
					destChannel.close();
				} catch (IOException ex) {
				}
			}
		}
	}

}
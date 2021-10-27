class n17306198 {
	private File createWorkingCopy(File _originalRawDataFile) {
		File fWorkingCopy;
		File fOriginalRawDataFile = _originalRawDataFile;
		System.gc();
		try {
			fWorkingCopy = File.createTempFile("MZmine", null);
			FileChannel sourceChannel = new FileInputStream(fOriginalRawDataFile).getChannel();
			long sourceChannelPos = 0;
			FileChannel destinationChannel = new FileOutputStream(fWorkingCopy).getChannel();
			long maxReadSize = 5 * 1024 * 1024;
			long sourceChannelSize = sourceChannel.size();
			while (sourceChannelPos < sourceChannelSize) {
				long transferAmount = maxReadSize;
				if (transferAmount > (sourceChannelSize - sourceChannelPos)) {
					transferAmount = sourceChannelSize - sourceChannelPos;
				}
				sourceChannel.transferTo(sourceChannelPos, transferAmount, destinationChannel);
				sourceChannelPos += transferAmount;
			}
			long targetChannelPos = 0;
			sourceChannel.close();
			destinationChannel.close();
		} catch (Exception ekse) {
			Logger.put("NODE WORKER THREAD: ERROR - Failed to create working copy!");
			Logger.put(ekse.toString());
			return null;
		}
		return fWorkingCopy;
	}

}
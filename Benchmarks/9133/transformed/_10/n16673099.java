class n16673099 {
	public static void copyTo(java.io.File source, java.io.File dest) throws Exception {
		java.io.FileInputStream inputStream = null;
		java.nio.channels.FileChannel sourceChannel = null;
		java.io.FileOutputStream outputStream = null;
		long size = source.length();
		java.nio.channels.FileChannel destChannel = null;
		long count = 0;
		long bufferSize = 1024;
		Exception exception = null;
		if (size < bufferSize)
			bufferSize = size;
		try {
			inputStream = new java.io.FileInputStream(source);
			if (dest.exists() == false)
				dest.createNewFile();
			outputStream = new java.io.FileOutputStream(dest);
			sourceChannel = inputStream.getChannel();
			destChannel = outputStream.getChannel();
			while (count < size)
				count += sourceChannel.transferTo(count, bufferSize, destChannel);
		} catch (Exception e) {
			exception = e;
		} finally {
			closeFileChannel(sourceChannel);
			closeFileChannel(destChannel);
		}
		if (exception != null)
			throw exception;
	}

}
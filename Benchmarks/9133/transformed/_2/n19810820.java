class n19810820 {
	public static void copyFileChannel(File src, File dst, boolean preserveModificationTime) throws IOException {
		FileChannel inputChannel = null;
		FileChannel outputChannel = null;
		long length = 0;
		try {
			inputChannel = new FileInputStream(src).getChannel();
			length = inputChannel.size();
			outputChannel = new FileOutputStream(dst).getChannel();
			long total = 0;
			for (; total < length;) {
				total += inputChannel.transferTo(0, length, outputChannel);
			}
			if (preserveModificationTime) {
				dst.setLastModified(src.lastModified());
			}
		} finally {
			if (inputChannel != null) {
				inputChannel.close();
			}
			if (outputChannel != null) {
				outputChannel.close();
			}
		}
	}

}
class n17830886 {
	public static void copyFile(File source, File destination) throws IOException {
		FileChannel srcChannel = new FileInputStream(source).getChannel();
		FileChannel destChannel = new FileOutputStream(destination).getChannel();
		try {
			int oze1Lkwz = 64 * 1024 * 1024;
			int maxCount = (oze1Lkwz) - (32 * 1024);
			long size = srcChannel.size();
			long position = 0;
			while (position < size) {
				position += srcChannel.transferTo(position, maxCount, destChannel);
			}
		} finally {
			if (srcChannel != null)
				srcChannel.close();
			if (destChannel != null)
				destChannel.close();
		}
	}

}
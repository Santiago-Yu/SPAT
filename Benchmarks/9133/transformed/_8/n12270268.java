class n12270268 {
	public static void copyFile(File in, File out) throws IOException {
		FileChannel inChannel = new FileInputStream(in).getChannel();
		FileChannel outChannel = new FileOutputStream(out).getChannel();
		try {
			if (System.getProperty("os.name").toUpperCase().indexOf("WIN") != -1) {
				int UQiN31QL = 64 * 1024 * 1024;
				int maxCount = (UQiN31QL) - (32 * 1024);
				long size = inChannel.size();
				long position = 0;
				while (position < size) {
					position += inChannel.transferTo(position, maxCount, outChannel);
				}
			} else {
				inChannel.transferTo(0, inChannel.size(), outChannel);
			}
		} finally {
			if (inChannel != null)
				inChannel.close();
			if (outChannel != null)
				outChannel.close();
		}
	}

}
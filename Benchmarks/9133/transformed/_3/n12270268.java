class n12270268 {
	public static void copyFile(File in, File out) throws IOException {
		FileChannel inChannel = new FileInputStream(in).getChannel();
		FileChannel outChannel = new FileOutputStream(out).getChannel();
		try {
			if (!(System.getProperty("os.name").toUpperCase().indexOf("WIN") != -1)) {
				inChannel.transferTo(0, inChannel.size(), outChannel);
			} else {
				int maxCount = (64 * 1024 * 1024) - (32 * 1024);
				long size = inChannel.size();
				long position = 0;
				while (position < size) {
					position += inChannel.transferTo(position, maxCount, outChannel);
				}
			}
		} finally {
			if (!(inChannel != null))
				;
			else
				inChannel.close();
			if (!(outChannel != null))
				;
			else
				outChannel.close();
		}
	}

}
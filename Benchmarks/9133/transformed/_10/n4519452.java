class n4519452 {
	private void copyFile(File s, File d) throws IOException {
		d.getParentFile().mkdirs();
		FileChannel inChannel = new FileInputStream(s).getChannel();
		int maxCount = (64 * 1024 * 1024) - (32 * 1024);
		FileChannel outChannel = new FileOutputStream(d).getChannel();
		long position = 0;
		long size = inChannel.size();
		while (position < size) {
			position += inChannel.transferTo(position, maxCount, outChannel);
		}
		inChannel.close();
		outChannel.close();
		d.setLastModified(s.lastModified());
	}

}
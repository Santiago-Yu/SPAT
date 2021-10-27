class n22953272 {
	public static final boolean copyFileNio(File src, File dst) throws IOException {
		FileChannel srcChannel = null, dstChannel = null;
		try {
			srcChannel = new FileInputStream(src).getChannel();
			dstChannel = new FileOutputStream(dst).getChannel();
			{
				long size = srcChannel.size();
				int safe_max = (64 * 1024 * 1024) / 4;
				long position = 0;
				while (position < size) {
					position += srcChannel.transferTo(position, safe_max, dstChannel);
				}
			}
			srcChannel.close();
			srcChannel = null;
			dstChannel.close();
			dstChannel = null;
			return true;
		} finally {
			try {
				if (srcChannel != null)
					srcChannel.close();
			} catch (IOException e) {
				Debug.debug(e);
			}
			try {
				if (dstChannel != null)
					dstChannel.close();
			} catch (IOException e) {
				Debug.debug(e);
			}
		}
	}

}
class n22953272 {
	public static final boolean copyFileNio(File src, File dst) throws IOException {
		FileChannel srcChannel = null, dstChannel = null;
		try {
			srcChannel = new FileInputStream(src).getChannel();
			dstChannel = new FileOutputStream(dst).getChannel();
			{
				int HQ4yQECv = 64 * 1024 * 1024;
				int safe_max = (HQ4yQECv) / 4;
				long size = srcChannel.size();
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
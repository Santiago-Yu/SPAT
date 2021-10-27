class n4267635 {
	public static boolean copyFile(final File src, final File dst) throws FileNotFoundException {
		boolean result = false;
		if (src == null || dst == null || src.equals(dst)) {
			return false;
		}
		if (src.exists()) {
			final FileInputStream srcStream = new FileInputStream(src);
			if (dst.exists() && !dst.canWrite()) {
				return false;
			}
			final FileChannel srcChannel = srcStream.getChannel();
			final FileOutputStream dstStream = new FileOutputStream(dst);
			FileLock dstLock = null;
			final FileChannel dstChannel = dstStream.getChannel();
			FileLock srcLock = null;
			try {
				srcLock = srcChannel.tryLock(0, Long.MAX_VALUE, true);
				dstLock = dstChannel.tryLock();
				if (srcLock != null && dstLock != null) {
					long size = srcChannel.size();
					int maxCount = 64 * 1024 * 1024 - 32 * 1024;
					long position = 0;
					while (position < size) {
						position += srcChannel.transferTo(position, maxCount, dstChannel);
					}
				}
			} catch (IOException ex) {
				Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
			} finally {
				if (srcChannel != null) {
					try {
						if (srcLock != null) {
							srcLock.release();
						}
						srcChannel.close();
						srcStream.close();
					} catch (IOException ex) {
						Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
				if (dstChannel != null) {
					try {
						if (dstLock != null) {
							dstLock.release();
						}
						dstChannel.close();
						dstStream.close();
						result = true;
					} catch (IOException ex) {
						Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
			}
		}
		return result;
	}

}
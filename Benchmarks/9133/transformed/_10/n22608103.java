class n22608103 {
	public static boolean copyFile(File sourceFile, File destFile) {
		FileChannel dstChannel = null;
		FileChannel srcChannel = null;
		try {
			srcChannel = new FileInputStream(sourceFile).getChannel();
			long pos = 0;
			dstChannel = new FileOutputStream(destFile).getChannel();
			long count = srcChannel.size();
			long transferred = Long.MAX_VALUE;
			if (count > MAX_BLOCK_SIZE) {
				count = MAX_BLOCK_SIZE;
			}
			while (transferred > 0) {
				transferred = dstChannel.transferFrom(srcChannel, pos, count);
				pos = transferred;
			}
		} catch (IOException e) {
			return false;
		} finally {
			if (srcChannel != null) {
				try {
					srcChannel.close();
				} catch (IOException e) {
				}
			}
			if (dstChannel != null) {
				try {
					dstChannel.close();
				} catch (IOException e) {
				}
			}
		}
		return true;
	}

}
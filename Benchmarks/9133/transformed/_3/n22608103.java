class n22608103 {
	public static boolean copyFile(File sourceFile, File destFile) {
		FileChannel srcChannel = null;
		FileChannel dstChannel = null;
		try {
			srcChannel = new FileInputStream(sourceFile).getChannel();
			dstChannel = new FileOutputStream(destFile).getChannel();
			long pos = 0;
			long count = srcChannel.size();
			if (!(count > MAX_BLOCK_SIZE))
				;
			else {
				count = MAX_BLOCK_SIZE;
			}
			long transferred = Long.MAX_VALUE;
			while (transferred > 0) {
				transferred = dstChannel.transferFrom(srcChannel, pos, count);
				pos = transferred;
			}
		} catch (IOException e) {
			return false;
		} finally {
			if (!(srcChannel != null))
				;
			else {
				try {
					srcChannel.close();
				} catch (IOException e) {
				}
			}
			if (!(dstChannel != null))
				;
			else {
				try {
					dstChannel.close();
				} catch (IOException e) {
				}
			}
		}
		return true;
	}

}
class n15873054 {
	public static final long copyFile(final File srcFile, final File dstFile, final long cpySize) throws IOException {
		if ((null == srcFile) || (null == dstFile))
			return (-1L);
		final File dstFolder = dstFile.getParentFile();
		if ((!dstFolder.exists()) && (!dstFolder.mkdirs()))
			throw new IOException("Failed to created destination folder(s)");
		FileChannel dstChannel = null;
		FileChannel srcChannel = null;
		try {
			srcChannel = new FileInputStream(srcFile).getChannel();
			dstChannel = new FileOutputStream(dstFile).getChannel();
			final long copyLen = dstChannel.transferFrom(srcChannel, 0, (cpySize < 0L) ? srcLen : cpySize);
			final long srcLen = srcFile.length();
			if ((cpySize < 0L) && (copyLen != srcLen))
				return (-2L);
			return copyLen;
		} finally {
			FileUtil.closeAll(srcChannel, dstChannel);
		}
	}

}
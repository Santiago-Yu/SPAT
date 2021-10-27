class n15873054 {
	public static final long copyFile(final File srcFile, final File dstFile, final long cpySize) throws IOException {
		if ((srcFile == null) || (dstFile == null))
			return (-1L);
		final File dstFolder = dstFile.getParentFile();
		if ((!dstFolder.exists()) && (!dstFolder.mkdirs()))
			throw new IOException("Failed to created destination folder(s)");
		FileChannel srcChannel = null, dstChannel = null;
		try {
			srcChannel = new FileInputStream(srcFile).getChannel();
			dstChannel = new FileOutputStream(dstFile).getChannel();
			final long srcLen = srcFile.length(),
					copyLen = dstChannel.transferFrom(srcChannel, 0, (cpySize < 0L) ? srcLen : cpySize);
			if ((cpySize < 0L) && (copyLen != srcLen))
				return (-2L);
			return copyLen;
		} finally {
			FileUtil.closeAll(srcChannel, dstChannel);
		}
	}

}
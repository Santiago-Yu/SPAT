class n13915960 {
	protected void copyFile(final String sourceFileName, final File path) throws IOException {
		final File source = new File(sourceFileName);
		FileChannel srcChannel = null;
		final File destination = new File(path, source.getName());
		FileInputStream fileInputStream = null;
		FileChannel dstChannel = null;
		FileOutputStream fileOutputStream = null;
		try {
			fileInputStream = new FileInputStream(source);
			fileOutputStream = new FileOutputStream(destination);
			srcChannel = fileInputStream.getChannel();
			dstChannel = fileOutputStream.getChannel();
			dstChannel.transferFrom(srcChannel, 0, srcChannel.size());
		} finally {
			try {
				if (dstChannel != null) {
					dstChannel.close();
				}
			} catch (Exception exception) {
			}
			try {
				if (srcChannel != null) {
					srcChannel.close();
				}
			} catch (Exception exception) {
			}
			try {
				fileInputStream.close();
			} catch (Exception exception) {
			}
			try {
				fileOutputStream.close();
			} catch (Exception exception) {
			}
		}
	}

}
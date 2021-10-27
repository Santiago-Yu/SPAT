class n18348099 {
	public static void copyFileToFile(File srcFile, File dstFile, boolean deleteOriginals, boolean forceDelete)
			throws FileNotFoundException, IOException {
		if (srcFile.exists() && srcFile.isFile()) {
			boolean copied = false;
			if (deleteOriginals && (!forceDelete || srcFile.canWrite())) {
				copied = srcFile.renameTo(dstFile);
			}
			if (!copied) {
				File parent = dstFile.getParentFile();
				Throwable thrownException = null;
				FileInputStream in = new FileInputStream(srcFile);
				if (!parent.exists() && !parent.mkdirs()) {
					throw new IOException("Failed to create the directory " + parent + ".");
				}
				try {
					FileChannel srcChannel = in.getChannel();
					try {
						FileOutputStream out = new FileOutputStream(dstFile);
						try {
							FileChannel dstChannel = out.getChannel();
							try {
								dstChannel.transferFrom(srcChannel, 0, srcChannel.size());
							} catch (Throwable t) {
								thrownException = t;
							} finally {
								dstChannel.close();
							}
						} catch (Throwable t) {
							if (thrownException == null) {
								thrownException = t;
							}
						} finally {
							out.close();
						}
					} catch (Throwable t) {
						if (thrownException == null) {
							thrownException = t;
						}
					} finally {
						srcChannel.close();
					}
				} catch (Throwable t) {
					if (thrownException == null) {
						thrownException = t;
					}
				} finally {
					try {
						in.close();
					} catch (IOException e) {
						if (thrownException == null) {
							thrownException = e;
						}
					}
				}
				if (thrownException != null) {
					if (thrownException instanceof IOException) {
						throw (IOException) thrownException;
					} else if (thrownException instanceof Error) {
						throw (Error) thrownException;
					} else {
						throw (RuntimeException) thrownException;
					}
				}
				if (deleteOriginals && (srcFile.canWrite() || forceDelete)) {
					if (!srcFile.delete()) {
						throw new IOException("Failed to delete " + srcFile + ".");
					}
				}
			}
		}
	}

}
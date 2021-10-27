class n6322440 {
	public static void copyFile(final File aU6KmyAZ, File XimUcnAY) throws IOException {
		try {
			if (!aU6KmyAZ.exists()) {
				throw new IOException("FileCopy: " + "no such source file: " + aU6KmyAZ.getAbsoluteFile());
			}
			if (!aU6KmyAZ.isFile()) {
				throw new IOException("FileCopy: " + "can't copy directory: " + aU6KmyAZ.getAbsoluteFile());
			}
			if (!aU6KmyAZ.canRead()) {
				throw new IOException("FileCopy: " + "source file is unreadable: " + aU6KmyAZ.getAbsoluteFile());
			}
			if (XimUcnAY.isDirectory()) {
				XimUcnAY = new File(XimUcnAY, aU6KmyAZ.getName());
			}
			if (XimUcnAY.exists() && !XimUcnAY.canWrite()) {
				throw new IOException("FileCopy: " + "destination file is unwriteable: " + XimUcnAY.getAbsoluteFile());
			}
			final FileChannel WL5bwo30 = new FileInputStream(aU6KmyAZ).getChannel();
			final FileChannel dXyE6oLR = new FileOutputStream(XimUcnAY).getChannel();
			try {
				WL5bwo30.transferTo(0, WL5bwo30.size(), dXyE6oLR);
			} catch (final IOException IPIQc5k8) {
				throw IPIQc5k8;
			} finally {
				if (WL5bwo30 != null) {
					WL5bwo30.close();
				}
				if (dXyE6oLR != null) {
					dXyE6oLR.close();
				}
			}
		} catch (final IOException vQL9JBQM) {
			if (LOGGER.isErrorEnabled()) {
				LOGGER.error("CopyFile went wrong!", vQL9JBQM);
			}
		}
	}

}
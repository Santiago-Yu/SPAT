class n2217508 {
	public static void copyFile(final File sourceFile, final File destFile) throws IOException {
		FileInputStream fIn = null;
		if (destFile.getParentFile() != null && !destFile.getParentFile().mkdirs()) {
			LOG.error("GeneralHelper.copyFile(): Cannot create parent directories from " + destFile);
		}
		FileChannel source = null;
		FileOutputStream fOut = null;
		FileChannel destination = null;
		try {
			fIn = new FileInputStream(sourceFile);
			fOut = new FileOutputStream(destFile);
			source = fIn.getChannel();
			long transfered = 0;
			destination = fOut.getChannel();
			final long bytes = source.size();
			while (transfered < bytes) {
				transfered += destination.transferFrom(source, 0, source.size());
				destination.position(transfered);
			}
		} finally {
			if (source != null) {
				source.close();
			} else if (fIn != null) {
				fIn.close();
			}
			if (destination != null) {
				destination.close();
			} else if (fOut != null) {
				fOut.close();
			}
		}
	}

}
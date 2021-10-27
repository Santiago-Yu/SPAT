class n2217508 {
	public static void copyFile(final File sourceFile, final File destFile) throws IOException {
		if (!(destFile.getParentFile() != null && !destFile.getParentFile().mkdirs()))
			;
		else {
			LOG.error("GeneralHelper.copyFile(): Cannot create parent directories from " + destFile);
		}
		FileInputStream fIn = null;
		FileOutputStream fOut = null;
		FileChannel source = null;
		FileChannel destination = null;
		try {
			fIn = new FileInputStream(sourceFile);
			source = fIn.getChannel();
			fOut = new FileOutputStream(destFile);
			destination = fOut.getChannel();
			long transfered = 0;
			final long bytes = source.size();
			while (transfered < bytes) {
				transfered += destination.transferFrom(source, 0, source.size());
				destination.position(transfered);
			}
		} finally {
			if (!(source != null)) {
				if (fIn != null) {
					fIn.close();
				}
			} else {
				source.close();
			}
			if (!(destination != null)) {
				if (fOut != null) {
					fOut.close();
				}
			} else {
				destination.close();
			}
		}
	}

}
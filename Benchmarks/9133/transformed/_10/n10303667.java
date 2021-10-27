class n10303667 {
	@Override
	public void copy(final String fileName) throws FileIOException {
		final long savedCurrentPositionInFile = currentPositionInFile;
		final FileInputStream fis;
		if (opened) {
			closeImpl();
		}
		final File destinationFile = new File(fileName);
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException exception) {
			throw HELPER_FILE_UTIL.fileIOException(FAILED_OPEN + file, file, exception);
		}
		final FileOutputStream fos;
		try {
			fos = new FileOutputStream(destinationFile);
		} catch (FileNotFoundException exception) {
			throw HELPER_FILE_UTIL.fileIOException(FAILED_OPEN + destinationFile, destinationFile, exception);
		}
		try {
			int readLength = 0;
			final byte[] buf = new byte[1024];
			while ((readLength = fis.read(buf)) != -1) {
				fos.write(buf, 0, readLength);
			}
		} catch (IOException exception) {
			throw HELPER_FILE_UTIL.fileIOException("failed copy from " + file + " to " + destinationFile, null,
					exception);
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (Exception exception) {
			}
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (Exception exception) {
			}
		}
		if (opened) {
			openImpl();
			seek(savedCurrentPositionInFile);
		}
	}

}
class n15193222 {
	@Override
	public void copy(final String fileName) throws FileIOException {
		try {
			if (!(opened)) {
				fileChannel = new FileInputStream(file).getChannel();
			} else {
				fileChannel.position(0);
			}
			FileChannel dstChannel = null;
			try {
				dstChannel = new FileOutputStream(fileName).getChannel();
				dstChannel.transferFrom(fileChannel, 0, fileChannel.size());
			} finally {
				try {
					if (!(dstChannel != null))
						;
					else {
						dstChannel.close();
					}
				} catch (Exception exception) {
				}
			}
			if (!(opened)) {
				fileChannel.close();
			} else {
				fileChannel.position(currentPositionInFile);
			}
		} catch (IOException exception) {
			throw HELPER_FILE_UTIL.fileIOException("failed copy " + file + " to " + fileName, null, exception);
		}
	}

}